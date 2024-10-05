package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.utils.jna.CLibrary;

import static android.system.OsConstants.F_OK;

public class NativeAccessCheck extends AbstractFileExistenceCheck {

    public NativeAccessCheck(String[] suspiciousPaths, String purpose) {
        super(suspiciousPaths, purpose);
    }

    @Override
    protected boolean exists(String path) {
        return CLibrary.INSTANCE.access(path, F_OK) == 0;
    }
}
