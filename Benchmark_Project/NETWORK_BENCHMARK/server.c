#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

#define MAX_VALUE 65536

int readwrite(int sockfd, int newsockfd, char buffer[])
{
	int temp;

	printf("\n\n*** Server is ready to read ***\n");
	bzero(buffer, MAX_VALUE); 
	temp = read(newsockfd, buffer, MAX_VALUE);
	if(temp < 0)
	{
		printf("\nServer Reading Error!!!\n");
        	exit(1);
    	}

    	else if(temp >= 49152)
    	{
        	temp = write(newsockfd, "@\n", 2);
    	}

    	else if(temp <= 49152)
    	{
        	temp = write(newsockfd, "&\n", 2);
    	}

    	else if(temp < 0)
    	{
        	printf("\nServer Writing Error!\n");
        	exit(1);
    	}

}


void *server(void *pass)
{
	int client; 
    	char buffer[MAX_VALUE]; 
    	char *message = (char *)pass;
    	int sockfd, newsockfd, port_no;
    
    	struct sockaddr_in server_addr, client_addr;
	
    	if(message == "Thread1")
    	{
        	port_no = 5073;
    	}

    	else if(message == "Thread2")
    	{
        	port_no = 6880;
    	}

    	sockfd = socket(AF_INET, SOCK_STREAM, 0);
    
    	if(sockfd < 0)
    	{
        	printf("\n Error in opening socket !!!!!\n");
        	exit(1);
    	}

    	bzero((char *)&server_addr, sizeof(server_addr));
	
	server_addr.sin_family = AF_INET; 
    	server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    	server_addr.sin_port = htons(port_no);
    
    	
    	if(bind(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0)
    	{
        	printf("\nSorry....Binding error Occured...!!\n");
        	exit(0);
    	}

    	listen(sockfd, 5);

    	client = sizeof(client_addr);

    	newsockfd = accept(sockfd, (struct sockaddr *)&client_addr,(socklen_t*) &client);
    
    	if(newsockfd < 0)
    	{
        	printf("\nSorry.... Accepting error\n");
        	exit(1);
    	}

    	readwrite(sockfd, newsockfd, buffer);

    	close(sockfd);
    	close(newsockfd);
  	close(client);
}

int main(int argc, char *argv[])
{
	int thread_count;
    	char *pass1 = (char *)"Thread1";
    	char *pass2 = (char *)"Thread2";

    	printf("\n\n********* Server Executing *********\n\n");
    	printf("\n Enter no. of threads (1 or 2) : \n");
    	scanf("%d", &thread_count);
   
    	if(thread_count == 1)
    	{
		int var1;
        	pthread_t thread1;
        	var1 = pthread_create(&thread1, NULL, server, (void *)pass1);
        	pthread_join(thread1, NULL);
		printf("\n Data received successful!!!!\n\n");
    	}

    	else if(thread_count == 2)
    	{
        	int var2,var3;
		pthread_t thread2, thread3;       
        	var2 = pthread_create(&thread2, NULL, server, (void *)pass1);
        	var3 = pthread_create(&thread3, NULL, server, (void *)pass2);
        	pthread_join(thread2, NULL);
        	pthread_join(thread3, NULL);
		printf("\n Data received successful!!!!\n\n");
	
    	}

    	exit(0);
}
