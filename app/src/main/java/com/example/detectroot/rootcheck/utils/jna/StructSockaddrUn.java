package com.example.detectroot.rootcheck.utils.jna;

import com.sun.jna.Structure;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class StructSockaddrUn extends Structure {

    public static int SUN_PATH_MAX = 108;
    public static int SIZEOF_SOCKADDR_UN = 2 + SUN_PATH_MAX;

    public short sun_family;
    public byte[] sun_path;

    public StructSockaddrUn(String sun_path) {
        if(sun_path.length() >= 108) {
            throw new IllegalArgumentException("Unix socket path too long");
        }
        this.sun_family = 1;
        this.sun_path = sun_path.getBytes(StandardCharsets.US_ASCII);
    }

    protected List<String> getFieldOrder() {
        return Arrays.asList("sun_family", "sun_path");
    }

}
