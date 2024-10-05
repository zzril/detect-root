package com.example.detectroot.rootcheck.checks.filesystem;

import java.io.File;

public class JavaCanWriteCheck extends AbstractFilesystemCheck {

    public JavaCanWriteCheck(String[] suspiciousPaths) {
        super(suspiciousPaths);
    }

    @Override
    protected boolean check(String path) {
        return new File(path).canWrite();
    }
}
