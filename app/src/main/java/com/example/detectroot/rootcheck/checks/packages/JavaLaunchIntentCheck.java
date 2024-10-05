package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;

public class JavaLaunchIntentCheck extends AbstractSingleInstalledPackageCheck {

    public JavaLaunchIntentCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected boolean isInstalled(String packageName) {
        return context.getPackageManager().getLaunchIntentForPackage(packageName) != null;
    }
}
