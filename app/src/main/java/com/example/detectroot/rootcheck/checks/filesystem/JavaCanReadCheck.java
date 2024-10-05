package com.example.detectroot.rootcheck.checks.filesystem;

import java.io.File;

public class JavaCanReadCheck extends AbstractFilesystemCheck {

    public JavaCanReadCheck(String[] suspiciousPaths) {
        super(suspiciousPaths);
    }

    @Override
    protected boolean check(String path) {
        return new File(path).canRead();
    }
}
