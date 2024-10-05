package com.example.detectroot.rootcheck.utils.processes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessUtils {

    public static Stream<String> getStdoutFromSubProcess(String cmdline) {
        Process process;
        try {
            process = Runtime.getRuntime().exec(cmdline);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            return null;
        }
        return new BufferedReader(new InputStreamReader(process.getInputStream())).lines();
    }

    public static String getStdoutAsString(String cmdline) {
        Stream<String> lines = getStdoutFromSubProcess(cmdline);
        return lines == null ? null : lines.collect(Collectors.joining("\n"));
    }

}
