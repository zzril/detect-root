package com.example.detectroot.rootcheck.checks.filesystem;

import com.example.detectroot.rootcheck.utils.jna.CLibrary;

import static android.system.OsConstants.W_OK;

public class NativeDirectoryWriteAccessCheck extends AbstractFilesystemCheck {

    public NativeDirectoryWriteAccessCheck(String[] suspiciousPaths) {
        super(suspiciousPaths);
    }

    @Override
    protected boolean check(String path) {
        return CLibrary.INSTANCE.access(path, W_OK) == 0;
    }
}
