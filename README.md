DetectRoot
==========

A simple Android app that searches for traces of the device being rooted.

This came out of a university project.

Build
-----

### Downloading the gradle wrapper

If you care about reproducible builds, you may want to use not only the same gradle version, but also the exact same gradle wrapper version that is used for downloading the actual gradle. It is recommended to simply check this in into the repository, but then it is also recommended to not check in binary files.

The wrapper originally used for this project is the one that comes with gradle version 7.0.2. You can download that using the following commands:  
```sh
cd gradle/wrapper/
wget 'https://services.gradle.org/distributions/gradle-7.0.2-src.zip'
7z x gradle-7.0.2-src.zip
mv gradle-7.0.2/gradle/wrapper/gradle-wrapper.jar .
mv gradle-7.0.2/gradlew ../../
mv gradle-7.0.2/gradlew.bat ../../
rm -r gradle-7.0.2*
cd ../../
```

