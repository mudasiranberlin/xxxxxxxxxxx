NETWORK BENCHMARK


PURPOSE: 
This benchmark exploits the client-server architecture to measure the Throughput and Latency of the underlying network.

CODE FLOW: 
This benchmark contains to files in it. 
•	server.c
•	client.c


SERVER MODULE
Server code has a function readwrite(int sockfd,int newsockfd,char buffer[]). The arguments for this function is as follows.
•	sockfd : It is a socket object.
•	newsockfd: It is a connect object.
•	Char buf[]: It is a buffer.

The following function reads data from buffer and returns the number of bytes read from buffer and stores it in temp variable.
temp = read(newsockfd, buffer, MAX_VALUE);
The following write function is used to send the message to the client.
temp = write(newsockfd, <message>, <size of the message>);
In this 1st parameter is a socket connection to the client, 2nd is the message that has to be sent to the client and 3rd is the length of the message sent.

The void *server(void *pass) function, port numbers 5073 and 6880 are assigned to thread1 and thread2 respectively. 
a.	sockfd = socket(AF_INET, SOCK_STREAM, 0) : this creates a tunnel or socket from server to the client for communication. AF_INET: Specifies that we are using internet connection, SOCK_STREAM: Specifies that we are using TCP connection and 0
b.	server_addr.sin_family = AF_INET; It specifies that we are using internet connection. server_addr.sin_addr.s_addr = INADDR_ANY; The systems are free to choose any available address. server_addr.sin_port = htons(port_no); Port number through which the server is connected to the client.
c.	The command bind(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0), binds the server to the particular socket descriptor by specifying it’s address and the size of address. If the bind function returns negative value the binding fails. 
d.	Further listen(sockfd, 5); function is used to listen to any client in the network that is ready to establish connection with the server through socket descriptor mentioned in the function. The number in this functions specifies the maximum no. of clients server can listen to. 
e.	The line newsockfd = accept(sockfd, (struct sockaddr )&client_addr,(socklen_t) &client); the server is accepting the connection from the client using the accept() method. The parameters of this methods are sockfd, client_addr, address length. After that we read and write the buffer to and fro the client and server. At last we close all the socket descriptors. 

The main() function implements the code to create the threads and these threads call the void *server(void *pass) function.


CLIENT MODULE
The client file has 3 functions in it.

i.	void read_send(int sockfd, char buffer[]). temp = write(sockfd, buffer,  trlen(buffer));  here we are writing the buffer to the server through the socket descriptor. If it returns a negative value, the write function is not completed. The bzero(buffer, MAX_VALUE) clears the buffer and then temp = read(sockfd, buffer, 2); reads data from buffer.

ii.	client(void *pass). The under condition if(message = = ‘Thread1’) it validates if it is thread 1 and open port no. port numbers 5073 and 6880 are assigned to thread1 and thread2 respectively. And user enter the host name. Then after open the socket using socket() method. And store the address of the server in the variable of type struct hostent. Copy this server address into server_addr.sin_addr.s_addr using the function bcopy as mentioned below, bcopy((char *)server->h_addr, (char *)&server_addr.sin_addr.s_addr, server->h_length); and at the end the transfer function is called.

iii.	transfer().The user then has to enter his choice in the transfer function.
1.	 Byte transfer  
2.	 1 Kilobyte transfer  
3.	 64 Kilobyte transfer
On entering the choice, following process followed,
•	 Time is started,
•	 Send and receive the data to and from the server
•	 Stop the time
•	 Calculate the difference in time, latency and throughput accordingly.

main() function then procures the input from the user and stores it in var1 and var2 variables for 1 and 2 threads respectively.


EXECUTION:
Open 2 terminals one for server and other for the client.
Terminal 1:  
$ g++ server.c –pthread
./a.out
Or
$ make –f server_compile
	Terminal 2:
$ g++ client.c –pthread
./a.out
Or 
$ make –f client_compile


