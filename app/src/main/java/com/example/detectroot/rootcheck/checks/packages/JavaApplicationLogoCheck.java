package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import android.content.pm.PackageManager;

public class JavaApplicationLogoCheck extends AbstractSingleInstalledPackageCheck {

    public JavaApplicationLogoCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected boolean isInstalled(String packageName) {
        boolean installed = true;
        try {
            context.getPackageManager().getApplicationLogo(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
}
