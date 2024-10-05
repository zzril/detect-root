package com.example.detectroot.rootcheck.checks.processes;

import android.content.Context;

public abstract class AbstractDumpProcessInfoCheck extends AbstractRunningProcessesCheck {

    protected AbstractDumpProcessInfoCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    protected abstract String getProcessInfo();

    @Override
    protected final void performChecks() {
        String processInfo = getProcessInfo();
        if(processInfo == null) {
            positives = new String[0];
            return;
        }
        positives = suspiciousProcessNames.stream().filter(processInfo::contains).toArray(String[]::new);
    }
}
