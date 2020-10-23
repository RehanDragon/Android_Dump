* [Release Version 2.6](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-26)
* [Release Version 2.5.2](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-252)
* [Release Version 2.5.1](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-251)
* [Release Version 2.5](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-25)
* [Release Version 2.4.1](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-241)
* [Release Version 2.4](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-24)
* [Release Version 2.3.1](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-231)
* [Release Version 2.2.1](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-221)
* [Release Version 2.3](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-23)
* [Release Version 2.2](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-22)
* [Release Version 2.1](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-21)
* [Release Version 2.0](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-20)
* [Release Version 1.9](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-19)
* [Release Version 1.8](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-18)
* [Release Version 1.7](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-17)
* [Release Version 1.6](https://github.com/shephertz/App42_JAVA_SDK/blob/master/Change%20Log.md#version-16)



## Version 2.6

**Release Date:** 20-03-2015

**Release Version:** 2.6

**The following features have been pushed to the services :**

**GAME SERVICE**

```
deleteGame
```

**This release contains the following bug fix:**

```
None
```

## Version 2.5.2

**Release Date:** 26-02-2015

**Release Version:** 2.5.2

**This release contains the following bug fix:**

```
Internal Log added in case of exception 
```

## Version 2.5.1

**Release Date:** 18-02-2015

**Release Version:** 2.5.1

**This release contains the following bug fix:**

```
AppErrorCode Bug Fix 
```

## Version 2.5

**Release Date:** 22-01-2015

**Release Version:** 2.5

**The following Services have been pushed to the latest :**
```
Event Service
Bravoboard Service
```
**This release contains the following bug fix:**

```
None
```

## Version 2.4.1

**Release Date:** 17-09-2014

**Release Version:** 2.4.1

**This release contains the following bug fix:**

```
score board bug fix for user list in group .
```

## Version 2.4

**Release Date:** 14-08-2014 

**Release Version:** 2.4

**The following features have been pushed to the services :**


**PUSH NOTIFICATION SERVICE**

```
deleteChannel
getChannelUsersCount
getChannelUsers
getUserSubscribedChannelsCount
getUserSubscribedChannels
```
**AVATAR SERVICE**

```
updateAvatar
deleteAvatarByName
deleteAllAvatars
```

**QUERY BUILDER**

```
setCreatedOn
setUpdatedOn
setDocumentId
```

**This release contains the following bug fix:**

```
None
```

## Version 2.3.1

**Release Date:** 30-07-2014

**Release Version:** 2.3.1

**This release contains the following bug fix:**

```
class version bug fix
```

## Version 2.2.1

**Release Date:** 30-07-2014

**Release Version:** 2.2.1

**This release contains the following bug fix:**

```
class version bug fix
```


## Version 2.3

**Release Date:** 20-06-2014

**Release Version:** 2.3

**The following Services have been pushed to the latest :**
```
Timer Service
Gift Service
```
**This release contains the following bug fix:**

```
None
```


## Version 2.2
 

**Release Date:** 20-06-2014

**Release Version:** 2.2

**The following features have been pushed  :**

```
If you are upgrading from previous version of App42_ANDROID_SDK and have used getRecordCount() method on storage service, you have to change its return type as Integer instead of string, because the return type of this method is changed.

**OlD Code Snippet:
String  recordCount =storageResponse.getRecordCount();

**New Code Snippet :
Integer  recordCount =storageResponse.getRecordCount();
```

```
New NokiaX enum added in push DeviceType.
```

**The following features have been pushed to the services :**

**PUSH SERVICE**

```
updatePushBadgeforDevice
updatePushBadgeforUser
clearAllBadgeCount
```

**STORAGE SERVICE**

```
getCountByQuery
```



**SCOREBOARD SERVICE**

```
getUsersWithScoreRange
```

**This release contains the following bug fix:**

```
None
```

## Version 2.1
 

**Release Date:** 24-03-2014

**Release Version:** 2.1

**The following features have been pushed  :**

```
If you are upgrading from previous version of App42_JAVA_SDK_2.0 and have used setQuery method on any service, you have to set App42API.setDbName instead of passing it in method parameter.

**OlD Code Snippet:
setQuery("dbName","collectionName","query");

**New Code Snippet :
App42API.setDbName("dbName");
setQuery("collectionName","query");
```

**The following features have been pushed to the services :**

**PUSH SERVICE**

```
unsubscribeDevice
resubscribeDevice
deleteAllDevices

```

**STORAGE SERVICE**

```
addOrUpdateKeys
addAttachmentToDocs
insertJSONDocument(With Attach File)
```

**User SERVICE**

```
addJSONObject(Add Extra Information while creating user)
createUserWithProfile
getUsersByGroup
```

**SCOREBOARD SERVICE**

```
addJSONObject(Add Extra Information of user while saves score)
```

**REVIEW SERVICE**

```
getAllReviewsByUser
```


**This release contains the following bug fix:**

```
None
```




## Version 2.0
 

**Release Date:** 23-01-2014

**Release Version:** 2.0

**The following features have been pushed  :**

```
Meta info in UserService (getUser,getUsersByRole,getUserByEmailId) and ScoreBoardService(getTopNRankers).
```

**The following features have been pushed to the services :**

**PUSH SERVICE**

```
sendMessageToInActiveUsers
scheduleMessageToUser

```

**STORAGE SERVICE**

```
updateDocumentByQuery
```


**REVIEW SERVICE**

```
deleteReviewByReviewId
deleteCommentByCommentId
```

**BUDDY SERVICE**

```
unFriend
deleteMessageById
deleteMessageByIds
```

**SCOREBOARD SERVICE**

```
getTopNTargetRankers
getTopNRankersFromFacebook(With specefied dange range)
```

**AVATAR SERVICE**

```
createAvatar (With inputStream)
```

**GALLERY SERVICE**

```
updatePhoto
```

**This release contains the following bug fix:**

```
Bug fix of uncaught exception
```




## Version 1.9 


**Release Date:** 25-11-2013

**Release Version:** 1.9

**The following features have been pushed  :**

```
Set logged in user
Log uncaught exception
```

**The following features have been pushed to the services :**

**PUSH SERVICE**

```
sendPushToTargetUsers
```

**STORAGE SERVICE**

```
saveOrUpdateDocumentByKeyValue
```

**This release contains the following bug fix:**

```
None
```


## Version 1.8 
[Download] (https://github.com/shephertz/App42_JAVA_SDK/raw/1.x/1.8/app42_java_1.8.zip)

**Release Date:** 23-10-2013

**Release Version:** 1.8

**The following Services have been pushed to the latest :**

```
AB Test Service
```

**This release contains the following bug fix:**

```
None
```


## Version 1.7 
[Download] (https://github.com/shephertz/App42_JAVA_SDK/raw/1.x/1.7/app42_java_1.7.zip)

**Release Date:** 23-09-2013

**Release Version:** 1.7

**The following Services have been pushed to the latest :**

```
Avatar Service
Achievement Service
```

**The following features have been pushed to the services :**

**SOCIAL SERVICE**

```
facebookPublishStream
facebookLinkPost
facebookLinkPostWithCustomThumbnail
getFacebookProfile
```

**PUSHNOTIFICATION SERVICE**

```
sendPushMessageToGroup
deleteDeviceToken
```

**This release contains the following bug fix:**

```
None
```


## Version 1.6 
[Download] (https://github.com/shephertz/App42_JAVA_SDK/raw/1.x/1.6/app42_java_1.6.zip)

**Release Date:** 07-08-2013

**Release Version:** 1.6

**The following features have been pushed to the latest :**



**PUSHNOTIFICATION SERVICE**
```
subscribeToChannel
unsubscribeDeviceToChannel
```

**GAME SERVICE**
```
getTopRankersFromBuddyGroup
```

**UPLOAD SERVICE**

```
UploadFileForFriend
UploadFileForFriends
UploadFileForGroup
````

**LOG SERVICE**

```
setEvent(eventName)
setEvent(moduleName,eventName)
````


**BUDDY SERVICE**

```
sendMessageToGroup
sendMessageToFriend
sendMessageToFriends
getAllMessages
getAllMessagesFromBuddy
getAllMessagesFromGroup
```

**This release contains the following bug fix:**

```
None
```
