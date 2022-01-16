imdb_client - command line java application that allows to download information about movies of your choice from IMDB_API

Technologies used:\
Java 11\
Maven\

You need an https://imdb-api.com account that will provide you with apiKey needed for the app to run. This key grants an access to IMDb-API\
In order to run the app you'll need to provide your apiKey in app.properties and compile classes from this repository.\
Then you can simply open cmd and run:\
java MovieApplication <your-path-to-a-catalog-for-saving-files> <movies-titles-that-you-want-info-about-separated-by-space>\
e.g. java MovieApplication D:/movies/ inception avengers superman

Have fun!