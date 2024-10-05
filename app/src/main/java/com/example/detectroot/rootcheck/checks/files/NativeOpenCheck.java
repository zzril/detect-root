package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.utils.jna.CLibrary;

import static android.system.OsConstants.O_RDONLY;

public class NativeOpenCheck extends AbstractFileExistenceCheck {

    public NativeOpenCheck(String[] suspiciousPaths, String purpose) {
        super(suspiciousPaths, purpose);
    }

    @Override
    protected boolean exists(String path) {
        return CLibrary.INSTANCE.open(path, O_RDONLY, 0) >= 0;
    }
}
