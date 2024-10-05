package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import android.content.pm.PackageManager;

public class JavaPackageGidsCheck extends AbstractSingleInstalledPackageCheck {

    public JavaPackageGidsCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected boolean isInstalled(String packageName) {
        boolean installed = true;
        try {
            context.getPackageManager().getPackageGids(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
}
