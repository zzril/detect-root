package com.example.detectroot.rootcheck.checks.processes;

import android.app.ActivityManager;
import android.content.Context;

import java.util.stream.Stream;

public class JavaRecentTasksCheck extends AbstractListRunningProcessesCheck {

    public JavaRecentTasksCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Stream<String> getRunningProcessNames() {
        return ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getRecentTasks(Integer.MAX_VALUE, ActivityManager.RECENT_WITH_EXCLUDED).stream().map
                        (taskInfo -> taskInfo.baseActivity.getPackageName());
    }
}
