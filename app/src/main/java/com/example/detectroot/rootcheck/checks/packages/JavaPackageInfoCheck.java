package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import android.content.pm.PackageManager;

public class JavaPackageInfoCheck extends AbstractSingleInstalledPackageCheck {

    public JavaPackageInfoCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected boolean isInstalled(String packageName) {
        boolean exists = true;
        try {
            //noinspection deprecation
            context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException ignored) {
            exists = false;
        }
        return exists;
    }
}
