DetectRoot
==========

A simple Android app that searches for traces of the device being rooted.

This came out of a university project.

Build
-----

This project uses Gradle, but does not provide the Gradle wrapper binaries because checking in binaries into version control is a very bad practice.

If you have Gradle installed, you can probably use that directly. Otherwise, you can download the wrapper in the following way:  
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
(Newer versions will likely also do, but this is how I've tested it.)

To install the app on a connected device, run:  
```sh
./gradlew installDebug
```
Make sure `JAVA_HOME` points to the installation path of a Java 17 SDK and `ANDROID_HOME` points to the Android SDK installation path.

If you're using IntelliJ, the Gradle plugin should do its work alright if you download the Gradle wrapper in the way specified above and *then* use the default run configuration.

