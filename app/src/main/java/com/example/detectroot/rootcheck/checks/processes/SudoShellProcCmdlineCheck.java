package com.example.detectroot.rootcheck.checks.processes;

import android.content.Context;
import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

public class SudoShellProcCmdlineCheck extends AbstractDumpProcessInfoCheck {

    public SudoShellProcCmdlineCheck(Context context, String[] suspiciousProcessNames, String purpose) {
        super(context, suspiciousProcessNames, purpose);
    }

    @Override
    protected String getProcessInfo() {
        return ProcessUtils.getStdoutAsString("su -c for p in /proc/*; do cat $p/cmdline; echo; done");
    }
}
