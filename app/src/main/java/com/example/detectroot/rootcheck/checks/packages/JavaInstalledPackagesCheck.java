package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import android.content.pm.PackageManager;

import java.util.stream.Stream;

public class JavaInstalledPackagesCheck extends AbstractListInstalledPackagesCheck {

    public JavaInstalledPackagesCheck(Context context, String[] suspiciousPackageNames) {
        super(context, suspiciousPackageNames);
    }

    @Override
    protected Stream<String> getInstalledPackageNames() {
        //noinspection deprecation
        return context.getPackageManager().getInstalledPackages(PackageManager.MATCH_ALL)
                .stream().map(packageInfo -> packageInfo.packageName);
    }
}
