# AppiumDemo

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