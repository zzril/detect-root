package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

public class ShellPmPathPackageCheck extends AbstractSingleInstalledPackageCheck {

    public ShellPmPathPackageCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected boolean isInstalled(String packageName) {
        String location = ProcessUtils.getStdoutAsString("pm path " + packageName);
        return location != null && !location.isEmpty();
    }
}
