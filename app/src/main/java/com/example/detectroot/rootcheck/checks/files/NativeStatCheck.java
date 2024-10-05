package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.utils.jna.CLibrary;
import com.example.detectroot.rootcheck.utils.jna.StructStat;

public class NativeStatCheck extends AbstractFileExistenceCheck {

    public NativeStatCheck(String[] suspiciousPaths, String purpose) {
        super(suspiciousPaths, purpose);
    }

    @Override
    protected boolean exists(String path) {
        return CLibrary.INSTANCE.stat(path, new StructStat()) == 0;
    }
}
