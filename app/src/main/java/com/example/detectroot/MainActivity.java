package com.example.detectroot;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.example.detectroot.rootcheck.CheckResult;
import com.example.detectroot.rootcheck.checks.*;
import com.example.detectroot.rootcheck.checks.files.*;
import com.example.detectroot.rootcheck.checks.filesystem.JavaCanReadCheck;
import com.example.detectroot.rootcheck.checks.filesystem.JavaCanWriteCheck;
import com.example.detectroot.rootcheck.checks.filesystem.NativeDirectoryReadAccessCheck;
import com.example.detectroot.rootcheck.checks.filesystem.NativeDirectoryWriteAccessCheck;
import com.example.detectroot.rootcheck.checks.packages.*;
import com.example.detectroot.rootcheck.checks.processes.*;
import com.example.detectroot.rootcheck.checks.properties.JavaBuildTagsCheck;
import com.example.detectroot.rootcheck.checks.properties.JavaSystemPropertyCheck;
import com.example.detectroot.rootcheck.checks.properties.ShellCatBuildTagsCheck;
import com.example.detectroot.rootcheck.checks.properties.ShellGetpropBuildTagsCheck;
import com.example.detectroot.rootcheck.checks.properties.ShellGetpropCheck;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();

        String defaultBuildTags = resources.getString(R.string.build_tags);

        String[] packages = resources.getStringArray(R.array.packages);
        String[] suPaths = resources.getStringArray(R.array.su_paths);
        String[] nonReadablePaths = resources.getStringArray(R.array.non_readable_paths);
        String[] nonWritablePaths = resources.getStringArray(R.array.non_writable_paths);
        String[] processes = resources.getStringArray(R.array.process_names);

        String[] appDataDirectories = Arrays.stream(resources.getStringArray(R.array.app_data_prefixes)).flatMap
                (prefix -> Arrays.stream(packages).map(packageName -> prefix + packageName)).toArray(String[]::new);

        Map<String, String> defaultProperties = new HashMap<>();
        for (String s : resources.getStringArray(R.array.system_properties)) {
            String[] key_value = s.split(":", 2);
            defaultProperties.put(key_value[0], key_value[1]);
        }

        Context context = getApplicationContext();

        RootCheck[] rootChecks = {

                new JavaFileExistsCheck(suPaths, "su"),
                new JavaExecNotFoundCheck(suPaths, "su"),
                new NativeAccessCheck(suPaths, "su"),
                new NativeOpenCheck(suPaths, "su"),
                new NativeSocketCheck(suPaths, "su"),
                new NativeStatCheck(suPaths, "su"),
                new ShellExecuteSuCheck(),
                new ShellWhichSuCheck(),

                new JavaBuildTagsCheck(defaultBuildTags),
                new ShellCatBuildTagsCheck(defaultBuildTags),
                new ShellGetpropBuildTagsCheck(defaultBuildTags),
                new JavaSystemPropertyCheck(defaultProperties),
                new ShellGetpropCheck((defaultProperties)),

                new JavaInstalledPackagesCheck(context, packages),
                new JavaInstalledApplicationsCheck(context, packages),
                new JavaPackageInfoCheck(context, packages),
                new JavaApplicationInfoCheck(context, packages),
                new JavaApplicationLogoCheck(context, packages),
                new JavaLaunchIntentCheck(context, packages),
                new JavaPackageGidsCheck(context, packages),
                new ShellPmListPackagesCheck(context, packages),
                new ShellPmPathPackageCheck(context, packages),
                new JavaFileExistsCheck(appDataDirectories, "app data"),
                new JavaExecNotFoundCheck(appDataDirectories, "app data"),
                new NativeAccessCheck(appDataDirectories, "app data"),
                new NativeOpenCheck(appDataDirectories, "app data"),
                new NativeSocketCheck(appDataDirectories, "app data"),
                new NativeStatCheck(packages, "app data"),

                new JavaRunningAppProcessesCheck(context, packages, "package names"),
                new ShellPsCheck(context, packages, "package names"),
                new SudoShellProcCmdlineCheck(context, packages, "package names"),
                new JavaRunningAppProcessesCheck(context, processes, "process names"),
                new JavaRunningServicesCheck(context, processes, "process names"),
                new JavaRecentTasksCheck(context, processes, "process names"),
                new ShellPsCheck(context, processes, "process names"),
                new SudoShellProcCmdlineCheck(context, processes, "process names"),

                new JavaCanReadCheck(nonReadablePaths),
                new NativeDirectoryReadAccessCheck(nonReadablePaths),
                new JavaCanWriteCheck(nonWritablePaths),
                new NativeDirectoryWriteAccessCheck(nonWritablePaths),

        };

        CheckResult[] results = Arrays.stream(rootChecks).map(
                check -> new CheckResult(check, this)).toArray(CheckResult[]::new);

        ArrayAdapter<CheckResult> adapter
                = new ArrayAdapter<CheckResult>(this, android.R.layout.simple_list_item_1, results) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = super.getView(position, convertView, parent);
                if (getItem(position).isRooted()) {
                    row.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.red));
                } else {
                    row.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.green));
                }
                return row;
            }
        };

        ListView listView = findViewById(R.id.test_results);
        listView.setAdapter(adapter);

        listView.setBackgroundColor(this.getColor(Arrays.stream(results).parallel().anyMatch(CheckResult::isRooted) ?
                R.color.red : R.color.green));

    }

}
