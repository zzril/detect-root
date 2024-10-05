package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;

import java.util.stream.Stream;

abstract class AbstractListInstalledPackagesCheck extends AbstractInstalledPackageCheck {

    protected AbstractListInstalledPackagesCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    protected abstract Stream<String> getInstalledPackageNames();

    @Override
    protected final void performChecks() {
        Stream<String> packages = getInstalledPackageNames();
        if(packages == null) {
            positives = new String[0];
            return;
        }
        positives = packages.filter(suspiciousPackageNames::contains).toArray(String[]::new);
    }
}
