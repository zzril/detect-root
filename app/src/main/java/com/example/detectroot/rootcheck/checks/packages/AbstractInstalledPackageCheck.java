package com.example.detectroot.rootcheck.checks.packages;

import android.content.Context;
import com.example.detectroot.rootcheck.checks.AbstractParametrizedRootCheck;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract class AbstractInstalledPackageCheck extends AbstractParametrizedRootCheck {

    protected final Context context;
    protected final Set<String> suspiciousPackageNames;

    protected AbstractInstalledPackageCheck(Context context, String[] suspiciousPackageNames) {
        this.context = context;
        this.suspiciousPackageNames = new HashSet<>(Arrays.asList(suspiciousPackageNames));
    }
}
