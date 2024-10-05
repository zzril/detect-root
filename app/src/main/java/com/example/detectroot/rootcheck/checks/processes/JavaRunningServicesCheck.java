package com.example.detectroot.rootcheck.checks.processes;

import android.app.ActivityManager;
import android.content.Context;

import java.util.stream.Stream;

public class JavaRunningServicesCheck extends AbstractListRunningProcessesCheck {

    public JavaRunningServicesCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    @Override
    protected Stream<String> getRunningProcessNames() {
        //noinspection deprecation
        return ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getRunningServices(Integer.MAX_VALUE).stream().map(ServiceInfo -> ServiceInfo.process);
    }
}
