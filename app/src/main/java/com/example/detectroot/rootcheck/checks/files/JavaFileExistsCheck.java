package com.example.detectroot.rootcheck.checks.files;

import java.io.File;

public class JavaFileExistsCheck extends AbstractFileExistenceCheck {

    public JavaFileExistsCheck(String[] suspiciousPaths, String purpose) {
        super(suspiciousPaths, purpose);
    }

    @Override
    protected boolean exists(String path) {
        return new File(path).exists();
    }
}
