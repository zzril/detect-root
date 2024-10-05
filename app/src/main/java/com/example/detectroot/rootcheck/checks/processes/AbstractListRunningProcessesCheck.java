package com.example.detectroot.rootcheck.checks.processes;

import android.content.Context;

import java.util.stream.Stream;

abstract class AbstractListRunningProcessesCheck extends AbstractRunningProcessesCheck {

    protected AbstractListRunningProcessesCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    protected abstract Stream<String> getRunningProcessNames();

    @Override
    protected final void performChecks() {
        Stream<String> processes = getRunningProcessNames();
        if(processes == null) {
            positives = new String[0];
            return;
        }
        positives = processes.filter(suspiciousProcessNames::contains).toArray(String[]::new);
    }
}
