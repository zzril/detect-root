package com.example.detectroot.rootcheck.checks;

public abstract class AbstractParametrizedRootCheck implements ParametrizedRootCheck {

    protected String[] positives;
    private boolean finished;

    protected AbstractParametrizedRootCheck() {
        positives = null;
        finished = false;
    }

    protected abstract void performChecks();

    @Override
    public final synchronized boolean isRooted() {
        if (!finished) {
            performChecks();
            finished = true;
        }
        return positives.length > 0;
    }

    @Override
    public final String[] getPositives() {
        return positives;
    }
}
