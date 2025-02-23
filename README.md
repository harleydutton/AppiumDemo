# AppiumDemo

## Variables
```
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk                                                                   
export ANDROID_HOME=/home/hdutton/Android/Sdk                                                                   
export PATH=/home/hdutton/bin/node_modules/bin:$PATH                                                            
export PATH=/home/hdutton/bin/android-studio/bin:$PATH                                                          
export PATH=/home/hdutton/Android/Sdk:$PATH
```

## Setup Instructions for a Fedora Atomic distribution
```
toolbox create appium
toolbox enter appium
dnf install npm maven
npm config set prefix ~/bin
npm install -g appium
```

## Execution Instructions for the same
```
# From project root
./appium_serverv.sh
mci
```

## Hello World
```
mci
java -jar target/<jarname>
```

## How I got the APK
```
# At project root, in toolbox
npm install sample-apps
cp ./node-modules/* ./src/test/resources/
```

## Android Emulation
```
in toolbox, at project root
download android studio from https://developer.android.com/studio
tar -xf /path/to/downloads/directory/android-studio-version.tar.gz
use android studio to download and install an an sdk, the obsolete sdk, and a virtual device
npm install -g appium-doctor
appium-doctor
fix the issues found by appium-doctor
```