package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.checks.AbstractParametrizedRootCheck;

import java.util.Arrays;

abstract class AbstractFileExistenceCheck extends AbstractParametrizedRootCheck {

    private final String[] pathNames;
    private final String purpose;

    protected AbstractFileExistenceCheck(String[] suspiciousPaths, String purpose) {
        this.pathNames = suspiciousPaths;
        this.purpose = purpose;
    }

    protected abstract boolean exists(String path);

    @Override
    protected final void performChecks() {
        positives = Arrays.stream(pathNames).filter(this::exists).toArray(String[]::new);
    }

    @Override
    public final String getName() {
        return super.getName() + " (" + purpose + ")";
    }
}
