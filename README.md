# VkWallNotifier

An application to notify a user if something interesting was posted on a group Vk wall. I personally use it to buy things on a secondary market faster then others. 
I prefer to use telegram so all notifications are coming to my bot there.

To get this application working you should have a registered vk account and an access_token. You can register your own application and get access_token quite easilly:
https://vk.com/dev/first_guide (steps 2 and 3).

When you have both of these done make sure you have access_token=(your access_token) and user_id=(your vk user id) in appication.properties file.

One can easily adjust this application implementing following interfaces:
1. Notifier 
2. MessageBuilder 
3. EditingDistanceAlgorithm
