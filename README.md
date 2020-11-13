# VkWallNotifier

An application to notify a user if something interesting was posted on a group Vk wall. I personally use it to buy things on a secondary market faster then others. 
I prefer to use telegram so all notifications are coming to my bot there.

### Getting started:
To get this application working you should have a registered vk account and an access_token. You can register your own application and get access_token quite easilly:
https://vk.com/dev/first_guide (steps 2 and 3).

When you have both of these done make sure you have access_token=(your access_token) and user_id=(your vk user id) in appication.properties file.

### What this application do:

1. It can send a request using VK API and java sdk(https://vk.com/dev/Java_SDK) and recieve a collection of posts from a group wall. To adjust group, number of latest posts you will get after every request and frequency of requests make sure you defined group_id=(target group id), number_of_posts=(desired number of posts),thread_sleep_time=(time in ms that application will sleep in between requests). 
2. After application recieved posts it can analyze there text to verify is there something interesting based on your logic. This is possible thanks to template method pattern realized through abstract class VkService and abstract method isInteresting. You have to pass text to analyze and EditinigDistanceAlgorithm object to isInterestingMethod and make it to return InterstingAnswer object which is basicly a wrapper of a boolean and List<String> objects. EditingDistanceAlgorithm is an object that incapsulates desired algorithm of verifiing if this text is what you wanted. It can be Levenstein distance for example. For convenience I included fuzzy search library and wrote adapter. 
3. If post is interesting and wasn't yet processed there will be a call of a MessageBuilder object to produce a required message. One can easilly write his/her own implementation. Then Notifier is called to notify user. Notifier is also an interface which user can implement to send messages for example to Whats App.

