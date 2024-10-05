package com.example.detectroot.rootcheck.utils.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

@SuppressWarnings("UnusedReturnValue")
public interface CLibrary extends Library {

    CLibrary INSTANCE = Native.load("c", CLibrary.class);

    int access(String pathname, int mode);
    int bind(int sockfd, Structure addr, int addrlen);
    int close(int fd);
    int open(String pathname, int flags, int mode);
    int socket(int domain, int type, int protocol);
    int stat(String pathname, Structure statbuf);
}
