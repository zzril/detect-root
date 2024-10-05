package com.example.detectroot.rootcheck.checks.filesystem;

import com.example.detectroot.rootcheck.checks.AbstractParametrizedRootCheck;

import java.util.Arrays;

public abstract class AbstractFilesystemCheck extends AbstractParametrizedRootCheck {

    private final String[] pathNames;

    protected AbstractFilesystemCheck(String[] suspiciousPaths) {
        this.pathNames = suspiciousPaths;
    }

    protected abstract boolean check(String path);

    @Override
    protected final void performChecks() {
        positives = Arrays.stream(pathNames).filter(this::check).toArray(String[]::new);
    }
}
