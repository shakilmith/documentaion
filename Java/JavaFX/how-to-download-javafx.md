# How to add javafx SDK in your system environment variables.

### Windows user:
## Linux user:
## Mac user:

In order to download javafx SDK(Software Development Kit) in your operating system, please follow the below steps: 

1. Please visit the official download page of javafx SDK: https://gluonhq.com/javafx

2. Let's say we are going to download latest LTS version, javafx 17.0.2 or the current released version.

3. Please scroll down and come over the Downloads section. (If you are a bad internet connection, please wait untill the page loads fully)

4. Then, in the drop-down box, select javafx version, operating system, architecture and 
type details based on your operating system. 

    - Javafx version: 17.0.8 or the latest (LTS) version. 
    - Operatin system: Select Linux (If you are Linux user), maxOS (If you are a mac user), Windows (If you are a windows user). As I am a windows user, I have selected windows. 
    - Architecture: Select architecture based on your operatng system. If you are a windwos user and your operating system supports x64 bit softwares, select x64.
    - Type : Selct SDK

//image

5. Now click on Download button (Righ side, red button) based on your system. I am x64 bit windows user, I have downloaded Windows 17.0.2 (x64) SDK. (You can download other sdks versions as well)

//image 

6. When the javafx SDK download will complete you will see a zip file - openjfx-17.0.2_windows-x64_bin-sdk.zip (Or, openjfx-17.0.2_(your operating system details))

The zip file location: "C:\Users\User\Downloads\openjfx-17.0.2_windows-x64_bin-sdk.zip" in my case.

7. Unzip the javafx SDK zip file to a specific location by clicking on it. 

Let's say, we want unzip the javafx sdk in C:\Program Files\JavaFX\javafx-sdk-17.0.2 here. So, open your Program files (C drive in your system) and create a folder called JavaFX. And then inside JavaFX folder create javafx-sdk-17.0.8 folder.

Now, click on the openjfx sdk and unzip it to the C:\Program Files\JavaFX location.

//image

- Right click on the javafx sdk zip file (You have just downloaded), then click Extract All. 

- Now, a new interface will appear before you.

//image

- It shows you, the javafx SDK will be extracted in this folder: C:\Users\User\Downloads\openjfx-17.0.2_windows-x64_bin-sdk. But we want to extract the javafx SDK in this folder: C:\Program Files\JavaFX (What we have created just now)

- So, clik on Browse button. And find out the folder JavaFX\javafx-sdk-17.0.2 (You find it in C:\Program Files\ here). Please look over the images below how to find out the exact location. 

//images 

8. After find out the C:\Program Files\JavaFX location, click Select Folder and you see the below interface then. 

//image

9. Then, click on Extract button. It will be extracted all the javafx SDK files in this directory - C:\Program Files\JavaFX\javafx-sdk-17.0.2 (The directory name can be different)

Note: If you don't want to create a new directory, just click on javafx-sdk zip file and extract it. (Then, please remeber the extracted location.)

10. Let's add the javafx SDK lib directory in our system variables. 

Windows user: 

Start Menu -> Edit the system environment variables (Just write env) -> Click on Edit the system environment variables -> Environment Variables -> System variables -> New -> Add variable Name (JAVAFX_HOME) -> Add Variable value (C:\Program Files\JavaFX\javafx-sdk-17.0.2) -> Click Ok button.

Then,
Click on Path -> New -> write: %JAVAFX_HOME%\bin -> Ok -> Ok -> Ok; 


Now, in your system, the Javafx sdk lib folder has been added. Though we don't need this to add in our environment variables to run our javafx application. But, if you want to run your application from CommandLine or Shell, you must add javafx SDK lib directory in your system variables.

