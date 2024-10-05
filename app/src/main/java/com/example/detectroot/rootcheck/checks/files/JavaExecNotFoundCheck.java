package com.example.detectroot.rootcheck.checks.files;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;

public class JavaExecNotFoundCheck extends AbstractFileExistenceCheck {

    public JavaExecNotFoundCheck(String[] suspiciousPaths, String purpose) {
        super(suspiciousPaths, purpose);
    }

    @Override
    protected boolean exists(String path) {
        boolean exists = true;
        try {
            getRuntime().exec(path);
        } catch (IOException ignored) {
            // For FileNotFoundException, we know for sure the file does not exist.
            // For others, we do not know, but return false as a safe default.
            exists = false;
        }
        return exists;
    }
}
