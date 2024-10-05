package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.checks.RootCheck;
import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

public class ShellWhichSuCheck implements RootCheck {

    @Override
    public boolean isRooted() {
        String suPath = ProcessUtils.getStdoutAsString("which su");
        return suPath != null && !suPath.isEmpty();
    }
}
