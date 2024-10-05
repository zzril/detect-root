package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;

abstract class AbstractSingleInstalledPackageCheck extends AbstractInstalledPackageCheck {

    protected AbstractSingleInstalledPackageCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    protected abstract boolean isInstalled(String packageName);

    @Override
    protected final void performChecks() {
        positives = suspiciousPackageNames.stream().filter(this::isInstalled).toArray(String[]::new);
    }
}
