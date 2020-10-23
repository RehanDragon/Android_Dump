App42_JAVA_SDK
==============


1. [Register] (https://apphq.shephertz.com/register) with App42 platform.
2. Create an app once you are on Quick start page after registration.
3. If you are already registered, login to [AppHQ] (http://apphq.shephertz.com/register/app42Login) console and create an app from App Manager Tab.

__Download and Set up SDK :-__

1). [Download] (https://github.com/shephertz/App42_JAVA_SDK/archive/master.zip) Java SDK

2). Unzip downloaded Zip file. Unzip folder contains version folder of jar and sample folder.

3). Version folder will contain App42_JAVA_SDK-x.x.x.jar,other required jar file in lib folder and docs.

4). If you are making new project then add App42_JAVA_SDK-x.x.x.jar and other required jar file in lib folder.

 or 
 
4). If your using your existing project then add App42_JAVA_SDK-x.x.x.jar in your lib folder.
 
5).Put these jar files in class path of your Java project.


__Initializing SDK :-__
You have to instantiate ServiceAPI class and pass your ApiKey/SecretKey to initialize the SDK.

```
ServiceAPI serviceAPI = new ServiceAPI("YOUR_API_KEY","YOUR_SECRET_KEY"); 
```

__Using App42 Services :-__
 you have to build target service that you want to use in your app. For example, User Service can be build with following snippet. Similarly you can build other service also with same notation.
 
```
UserService userService = serviceAPI.buildUserService();
//Similarly you can build other services like serviceAPI.buildXXXXService()
```

