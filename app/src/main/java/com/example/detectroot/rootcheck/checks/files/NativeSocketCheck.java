package com.example.detectroot.rootcheck.checks.files;

import com.example.detectroot.rootcheck.utils.jna.CLibrary;
import com.example.detectroot.rootcheck.utils.jna.StructSockaddrUn;
import com.sun.jna.Native;

import static android.system.OsConstants.*;
import static com.example.detectroot.rootcheck.utils.jna.StructSockaddrUn.SIZEOF_SOCKADDR_UN;

public class NativeSocketCheck extends AbstractFileExistenceCheck {

    public NativeSocketCheck(String[] suspiciousPaths, String purpose) {
        super(suspiciousPaths, purpose);
    }

    /**
     * Returns the error code in errno after attempting to bind a unix socket to path.
     * Returns 0 if the call to bind() did not fail, or if an error happened elsewhere.
     */
    private static int errnoAfterUnixBind(String path) {
        int errno = 0;
        int sockFd = CLibrary.INSTANCE.socket(AF_UNIX, SOCK_STREAM, 0);
        if (sockFd >= 0) {
            if (CLibrary.INSTANCE.bind(sockFd, new StructSockaddrUn(path), SIZEOF_SOCKADDR_UN) < 0) {
                errno = Native.getLastError();
            }
            CLibrary.INSTANCE.close(sockFd);
        }
        return errno;
    }

    @Override
    protected boolean exists(String path) {
        return errnoAfterUnixBind(path) == EADDRINUSE || errnoAfterUnixBind(path + "/nonexistent") == ENOTDIR;
    }
}
