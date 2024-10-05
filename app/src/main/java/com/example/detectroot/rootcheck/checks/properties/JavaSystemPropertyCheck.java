package com.example.detectroot.rootcheck.checks.properties;

import java.util.Map;

public class JavaSystemPropertyCheck extends AbstractPropertyCheck {

    public JavaSystemPropertyCheck(Map<String, String> expectedProperties) {
        super(expectedProperties);
    }

    @Override
    protected String getValueOfProperty(String property) {
        // NOTE: This should always be null because Java's System.getProperty() has nothing to do with Android
        // properties. However, multiple sources report its usage for root detection, so we include it here anyway.
        return System.getProperty(property);
    }
}
