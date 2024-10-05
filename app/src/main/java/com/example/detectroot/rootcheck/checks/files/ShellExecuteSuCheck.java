package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.checks.RootCheck;

import java.io.IOException;

public class ShellExecuteSuCheck implements RootCheck {

    @Override
    public boolean isRooted() {
        boolean suExists = true;
        try {
            Runtime.getRuntime().exec("su");
        } catch (IOException e) {
            suExists = false;
        }
        return suExists;
    }
}
