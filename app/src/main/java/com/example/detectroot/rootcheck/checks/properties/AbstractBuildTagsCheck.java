package com.example.detectroot.rootcheck.checks.properties;

import com.example.detectroot.rootcheck.checks.RootCheck;

import java.util.Objects;

abstract class AbstractBuildTagsCheck implements RootCheck {

    private final String expectedBuildTags;

    protected AbstractBuildTagsCheck(String expectedBuildTags) {
        this.expectedBuildTags = expectedBuildTags;
    }

    protected abstract String getBuildTags();

    @Override
    public final synchronized boolean isRooted() {
        String actualBuildTags = getBuildTags();
        return actualBuildTags != null && !actualBuildTags.isEmpty()
                && !Objects.equals(actualBuildTags, expectedBuildTags);
    }
}
