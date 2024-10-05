package com.example.detectroot.rootcheck.checks.processes;

import android.app.ActivityManager;
import android.content.Context;

import java.util.stream.Stream;

public class JavaRunningAppProcessesCheck extends AbstractListRunningProcessesCheck {

    public JavaRunningAppProcessesCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    @Override
    protected Stream<String> getRunningProcessNames() {
        return ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getRunningAppProcesses().stream().map(processInfo -> processInfo.processName);
    }
}
