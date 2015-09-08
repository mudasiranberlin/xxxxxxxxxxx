#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <sys/types.h>
#include <sys/socket.h>
#include<sys/time.h>
#include <netinet/in.h>
#include <netdb.h> 
#include <time.h>

#define MAX_VALUE 65536
#define BYTE 4
#define KB 1024

int check;
int sockfd, port_no;
struct timeval start_time, end_time;


void read_send(int sockfd, char buffer[])
{
	int temp;
	printf("\n\n*** Client is ready to send ***\n");
	temp = write(sockfd, buffer, strlen(buffer));
	if(temp < 0)
	{
        	printf("\n Error in writing to socket \n");
        	exit(0);
    	}

    	bzero(buffer, MAX_VALUE);
    	temp = read(sockfd, buffer, 2);
    	if(temp < 0)
    	{
       		printf("\n Error in Reading \n");
        	exit(0);
    	}  

    	if(buffer[0] == '@')
    	{
        	check = 0;
    	}
    	else if(buffer[0] == '&')
    	{
        	check = 1;
    	}

}

void transfer()
{
	int choice;
	char buffer_for_byte[BYTE]="H";
    	char buffer_for_kilobyte[KB];
    	char buffer_for_maxvalue[MAX_VALUE];
    	double theTime, bitcount; 
	
    	printf("\n\n *** OPTIONS TO TRANSFER TO THE SERVER *** \n 1-->1 Byte transfer \n 2-->1 Kilobyte transfer \n 3-->64 Kilobyte transfer\n\n");    
	printf("\n Select your choice from above options : ");
	scanf("%d", &choice);
	
	switch(choice)
	{

    		case 1 : 
			 gettimeofday(&start_time, NULL);
        		 read_send(sockfd, buffer_for_byte);
        		 gettimeofday(&end_time, NULL);
        		 theTime = (((double)(1000000*(end_time.tv_sec - start_time.tv_sec))+(double)(end_time.tv_usec - 				 start_time.tv_usec))/8000000);
        		 bitcount = BYTE;
        		 printf("\n The speed of network for 1B transfer is : %f Mbps\n", (bitcount*8)/(theTime*(1024*1024)));
        		 printf("\n The latency of the network is : %f ms\n", theTime);
    	   		 break;

		case 2 : for(int i=0; i<KB; i++)
        		 {
            			buffer_for_kilobyte[i] = 'c';
        		 }
        		 gettimeofday(&start_time, NULL);
        		 read_send(sockfd, buffer_for_kilobyte);
        		 gettimeofday(&end_time, NULL);
        		 theTime = (((double)(1000000*(end_time.tv_sec - start_time.tv_sec))+(double)(end_time.tv_usec - 		  				 start_time.tv_usec))/2000000);
        		 bitcount = KB;
        		 printf("\n The speed of network for 1KB transfer is : %f Mbps\n", (bitcount*8)/(theTime*1024*1024));
        		 printf("\n The latency of the network is : %f ms\n", theTime*1000000);
    			 break;


    		case 3 : 
        		 int check1;

        		 if(check == 0)
        		 {
            			check1 = 2000000;
        		 }
        		 else if(check == 1)
        		 {
            			check1 = 1000000;
        		 }

        		 for(int i=0; i<MAX_VALUE; i++)
         		 {
            			buffer_for_maxvalue[i] = 'm';
        		 }
   
        		 gettimeofday(&start_time, NULL);
        		 read_send(sockfd, buffer_for_maxvalue);
        		 gettimeofday(&end_time, NULL);
        		 theTime = (((double)(1000000*(end_time.tv_sec - start_time.tv_sec))+(double)(end_time.tv_usec - 		 				 start_time.tv_usec))/	check1);
        		 bitcount = MAX_VALUE;
        		 printf("\n The speed of network for 64KB transfer is : %f Mbps\n", (bitcount*8)/(theTime*1024*1024));
        		 printf("\n The latency of the network is : %f ms\n", theTime*1000000);
    			 break;

    		default :printf("\nPLEASE ENTER A VALID INPUT!!\n");
        		 exit(1);
    }

    close(sockfd);
}

void *client(void *pass)
{
	char hostname[128];
	char *message = (char *)pass;
	struct sockaddr_in server_addr;
	struct hostent *server;
	
	printf("\n Please Enter the host name : ");
	scanf("%s", hostname);
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
        	printf("\n Error in opening socket !!!!! \n");
        	exit(1);
    	}


    	server = gethostbyname(hostname);

    	if(server == NULL)
    	{
    		printf("\n Cannot find the mentioned server name on the net!\n");
    		exit(0);
    	}

    	bzero((char *)&server_addr, sizeof(server_addr));
	server_addr.sin_family = AF_INET;
    	bcopy((char *)server->h_addr, (char *)&server_addr.sin_addr.s_addr, server->h_length);
	server_addr.sin_port = htons(port_no);

    
    	if(connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0)
    	{
    		printf("\n Connecting error!\n");
    		exit(0);
    	}
	else
	{
		printf("\n Connection established between Client and Server \n");
	}

	transfer();
}



int main(int argc, char *argv[])
{
    int thread_count;
    char *pass1 = (char *)"Thread1";
    char *pass2 = (char *)"Thread2";
    
    printf("\n\n********* Client Executing *********\n\n");
    printf("\n Enter no. of threads (1 or 2) : \n");
    scanf("%d", &thread_count);

    if(thread_count == 1)
    {
	int var1;
        pthread_t thread1;
        var1 = pthread_create(&thread1, NULL, client, (void *)pass1);
        pthread_join(thread1, NULL);
    }

    else if(thread_count == 2)
    {
        int var1,var2;
	pthread_t thread1, thread2;       
        var1 = pthread_create(&thread1, NULL, client, (void *)pass1);
	pthread_join(thread1, NULL);
        var2 = pthread_create(&thread2, NULL, client, (void *)pass2);
        pthread_join(thread2, NULL);

    }

	else
	printf("\n INVALID INPUT!!!!!!!!!!\n");

    exit(0);
}
