package com.example.detectroot.rootcheck.checks;

public interface RootCheck {

    boolean isRooted();

    default String getName() {
        return getClass().getSimpleName();
    }

}
