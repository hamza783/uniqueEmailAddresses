"# uniqueEmailAddresses" 

Accept a list of email addresses and return an integer indicating the number of unique email addresses.

Unique email addresses means they will be delivered to the same account using Gmail account matching. 
Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+"

To run:
Run the main method in UniqueEmailsApplication.java file as a java project.

By Default, spring boot will use port 8080. to change the port  number, modify application.properties file
add below line to application.properties. (this line is already added to the project. just need to uncomment it and change port number)
server.port:8080

To test if the application is running properly paste below url in the browser(make sure to replace the port number with the port number	
	that the application is running on in your local machine.(default: 8080)).

URL: http://localhost:8080/ping
Result: you should se "pong" in the browser window.

To pass input list of emails, there are 2 methods. One through browser and the other through postman.

Method 1: Postman(preferred)

Use below endpoint in postman. Method type is GET
http://localhost:8080/getNumberOfUniqueEmails

Enter the list of emails as a json list in the request body.
Request body Example:
[
    "hamza4253@gmail.com",
    "hamza.4253@gmail.com",
    "ham.za4.253+spam@gmail.com",
    "hamza4253@yahoo.com",
    "hamzu@gmail.com"
]

Method 2:
To pass the list of emails through browser, you can use below url(replace comma_seperated_email_list with list of emails seperated by comma).
Method type is GET
http://localhost:8080/getNumberOfUniqueEmailsUrl/comma_seperated_email_list

Example:
http://localhost:8080/getNumberOfUniqueEmailsUrl/hamza4253@gmail.com,hamza.4253@gmail.com,ham.za4.253+spam@gmail.com,hamza4253@yahoo.com,hamzu@gmail.com