package com.example.detectroot.rootcheck.checks.processes;

import android.content.Context;
import com.example.detectroot.rootcheck.checks.AbstractParametrizedRootCheck;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractRunningProcessesCheck extends AbstractParametrizedRootCheck {

    protected final Context context;
    protected final Set<String> suspiciousProcessNames;
    protected final String purpose;

    protected AbstractRunningProcessesCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        this.context = context;
        this.suspiciousProcessNames = new HashSet<>(Arrays.asList(suspiciousProcessNames));
        this.purpose = purpose;
    }

}
