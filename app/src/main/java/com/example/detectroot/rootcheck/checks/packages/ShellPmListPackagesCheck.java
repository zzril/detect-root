package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

import java.util.stream.Stream;

public class ShellPmListPackagesCheck extends AbstractListInstalledPackagesCheck {

    public ShellPmListPackagesCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected Stream<String> getInstalledPackageNames() {
        return ProcessUtils.getStdoutFromSubProcess("pm list packages");
    }
}
