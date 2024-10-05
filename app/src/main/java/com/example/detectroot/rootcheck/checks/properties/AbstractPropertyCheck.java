package com.example.detectroot.rootcheck.checks.properties;

import com.example.detectroot.rootcheck.checks.AbstractParametrizedRootCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

abstract class AbstractPropertyCheck extends AbstractParametrizedRootCheck {

    private final Map<String, String> expectedProperties;

    protected AbstractPropertyCheck(Map<String, String> expectedProperties) {
        this.expectedProperties = expectedProperties;
    }

    protected abstract String getValueOfProperty(String property);

    @Override
    protected final void performChecks() {
        List<String> positiveList = new ArrayList<>();
        for (String property : expectedProperties.keySet()) {
            String expectedValue = expectedProperties.get(property);
            String actualValue = getValueOfProperty(property);
            if (actualValue != null && !actualValue.isEmpty() && !actualValue.equals(expectedValue)) {
                positiveList.add(property + "=" + actualValue);
            }
        }
        positives = positiveList.toArray(new String[0]);
    }
}
