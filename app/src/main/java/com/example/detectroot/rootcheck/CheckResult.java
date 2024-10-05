package com.example.detectroot.rootcheck;

import android.content.Context;
import com.example.detectroot.R;
import com.example.detectroot.rootcheck.checks.ParametrizedRootCheck;
import com.example.detectroot.rootcheck.checks.RootCheck;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CheckResult {

    private final Context context;
    private final RootCheck check;
    private boolean finished;
    private boolean result;

    public CheckResult(RootCheck check, Context context) {
        this.context = context;
        this.check = check;
        this.finished = false;
    }

    public boolean isRooted() {
        synchronized (this) {
            if (!finished) {
                result = check.isRooted();
                finished = true;
            }
        }
        return result;
    }

    @NotNull
    public String toString() {
        return check.getName() + ": " + (isRooted() ?
                (context.getString(R.string.rooted) + (check instanceof ParametrizedRootCheck ?
                        " Found: " + Arrays.toString(((ParametrizedRootCheck) check).getPositives()) : ""))
                : context.getString(R.string.not_rooted));
    }
}
