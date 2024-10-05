package com.example.detectroot.rootcheck.checks.properties;

import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

import java.util.Objects;

public class ShellCatBuildTagsCheck extends AbstractBuildTagsCheck {

    public ShellCatBuildTagsCheck(String expectedBuildTags) {
        super(expectedBuildTags);
    }

    @Override
    protected String getBuildTags() {
        try {
            return Objects.requireNonNull(ProcessUtils.getStdoutAsString
                    ("cat /system/build.prop | grep ro.build.tags")).split("=", 1)[1];
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            return null;
        }
    }
}
