package com.example.detectroot.rootcheck.checks.properties;

import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

public class ShellGetpropBuildTagsCheck extends AbstractBuildTagsCheck {

    public ShellGetpropBuildTagsCheck(String expectedBuildTags) {
        super(expectedBuildTags);
    }

    @Override
    protected String getBuildTags() {
        return ProcessUtils.getStdoutAsString("getprop ro.build.tags");
    }
}
