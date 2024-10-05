package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import android.content.pm.PackageManager;

import java.util.stream.Stream;

public class JavaInstalledApplicationsCheck extends AbstractListInstalledPackagesCheck {

    public JavaInstalledApplicationsCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected Stream<String> getInstalledPackageNames() {
        //noinspection deprecation
        return context.getPackageManager().getInstalledApplications(PackageManager.MATCH_ALL)
                .stream().map(applicationInfo -> applicationInfo.packageName);
    }
}
