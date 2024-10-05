package com.example.detectroot.rootcheck.utils.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class StructStat extends Structure {

    public long st_dev;
    public long st_ino;
    public int st_mode;
    public long st_nlink;
    public int st_uid;
    public int st_gid;
    public long st_rdev;
    public long st_size;
    public long st_blksize;
    public long st_blocks;

    protected List<String> getFieldOrder() {
        return Arrays.asList(
            "st_dev",
            "st_ino",
            "st_mode",
            "st_nlink",
            "st_uid",
            "st_gid",
            "st_rdev",
            "st_size",
            "st_blksize",
            "st_blocks"
        );
    }

}
