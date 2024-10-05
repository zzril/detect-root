package com.example.detectroot.rootcheck.checks.filesystem;

import com.example.detectroot.rootcheck.utils.jna.CLibrary;

import static android.system.OsConstants.R_OK;

public class NativeDirectoryReadAccessCheck extends AbstractFilesystemCheck {

    public NativeDirectoryReadAccessCheck(String[] suspiciousPaths) {
        super(suspiciousPaths);
    }

    @Override
    protected boolean check(String path) {
        return CLibrary.INSTANCE.access(path, R_OK) == 0;
    }
}
