# Mobile App Automation with Appium



## Description 
A training automation project to test native apps. As an example, the Wikipedia app has been selected to use in this automation project. The .apk file is stored within `/src/test/resources` path 
GitHub [mobile-app-testing](https://github.com/luisaferco/mobile-app-testing)

## Starting 🚀

### Environment setting

  - Java JDK installed 11 [download](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)
  - Maven installed [download]()
  - Appium Server installed [download](https://github.com/appium/appium-desktop/releases)
  - Any physical o emulated device.


### Installation 🛠️
Once you have cloned the repository on your computer, open a terminal and run the following command:
```
mvn clean install
```


### Device setup 🔧
- Physical devices: On your device, activate developer mode, then enable "USB Debugging".
- Emulated device: 
  - Android
    Prerequisites: Android SDK installed.
    > It is necessary to ensure that the 'Hypervisor' is enabled on your local environment, ([how to configure it](https://learn.microsoft.com/en-us/virtualization/hyper-v-on-windows/quick-start/enable-hyper-v))
    
    It is recommended to restart the computer before running an emulator in order for the changes to take effect.
  - Create a Virtual Device (AVD) in Android Studio, ([how to create it](https://developer.android.com/studio/run/managing-avds?hl=es-419#createavd))
  - Use `adb` command to install the .apk file on your emulated device 
  
    > `install [option] <PATH>`
    
    Also, the .apk file can be dragged to the emulated device.


#### Capabilities 🔩

Appium capabilities must be configured in one of the android.properties or ios.properties files depending on the selected device type. Must be include device-related information such as platformName, platformVersion, deviceName, and appPackage/appActivity for Android devices

in physical devices, once the mobile device is connected to the computer, it is possible to confirm that the device is properly configured and ready to be managed by Appium using the adb command 

```powerShell
adb devices
```
returning a list of connected devices with their deviceId associated

![img.png](img.png)

**Some useful command lines to get capabilities:**

`PlatformVersion`: adb -s "deviceId" shell getprop ro.build.version.release

`DeviceName`: adb -s "deviceId" shell getprop ro.product.model

### Integrate with Browserstack

The *.yml config files were created at the /test/java/resources/config path of the project. This file holds all the required capabilities to run tests on BrowserStack.

It must be added as environment variables the `BROWSERSTACK_USERNAME` and `BROWSERSTACK_ACCESS_KEY` secret variables
The parameters can be got in the [BrowserStack automate dashboard[(https://www.browserstack.com/automate)


### Running tests 🧪

-Once you have your device enabled, open the Appium either the Appium server or the Appium GUI you have configured and open a connection with IP address 127.0.0.1 and port 4723.
-Open a terminal and run the following command:
 ```
 run mvn verify
 ```

To run using the Browserstack platform use the following commands
  ```
 To run local test: 
  ```
run mvn verify -P Local
  ```
The suite.conf.yml configure all capabilities to run parallel tests through CI/CD pipeline which is configured to run using the following command
  ```
run mvn verify -P Suite

## Links 🔗
Do you have comments? Let me know on Twitter: [@Luisaferco](https://twitter.com/LuisaFer0826)

My Linkedin profile on [Luisa Colorado](https://www.linkedin.com/in/luisa-fernanda-ce-81a399137)