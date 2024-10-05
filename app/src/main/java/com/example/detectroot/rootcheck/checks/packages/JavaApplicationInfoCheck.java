package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import android.content.pm.PackageManager;

public class JavaApplicationInfoCheck extends AbstractSingleInstalledPackageCheck {

    public JavaApplicationInfoCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected boolean isInstalled(String packageName) {
        boolean exists = true;
        try {
            //noinspection deprecation
            context.getPackageManager().getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException ignored) {
            exists = false;
        }
        return exists;
    }
}
