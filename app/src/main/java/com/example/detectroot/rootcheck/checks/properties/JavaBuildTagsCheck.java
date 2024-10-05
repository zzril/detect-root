package com.example.detectroot.rootcheck.checks.properties;

import android.os.Build;

public class JavaBuildTagsCheck extends AbstractBuildTagsCheck {

    public JavaBuildTagsCheck(String expectedBuildTags) {
        super(expectedBuildTags);
    }

    @Override
    protected String getBuildTags() {
        return Build.TAGS;
    }
}
