package com.example.detectroot.rootcheck.checks.processes;

import android.content.Context;
import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

import java.util.stream.Stream;

public class ShellPsCheck extends AbstractListRunningProcessesCheck {

    public ShellPsCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    @Override
    protected Stream<String> getRunningProcessNames() {
        return ProcessUtils.getStdoutFromSubProcess("ps");
    }
}
