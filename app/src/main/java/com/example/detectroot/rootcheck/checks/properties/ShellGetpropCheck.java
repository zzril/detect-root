package com.example.detectroot.rootcheck.checks.properties;

import com.example.detectroot.rootcheck.utils.processes.ProcessUtils;

import java.util.Map;

public class ShellGetpropCheck extends AbstractPropertyCheck {

    public ShellGetpropCheck(Map<String, String> expectedProperties) {
        super(expectedProperties);
    }

    @Override
    protected String getValueOfProperty(String property) {
        return ProcessUtils.getStdoutAsString("getprop " + property);
    }
}
