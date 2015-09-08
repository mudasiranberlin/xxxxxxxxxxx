#include<stdio.h>
#include<iostream>
#include<stdlib.h>
#include<time.h>
#include<ctime>
#include<unistd.h>
#include<pthread.h>
#include<memory.h>

#define BYTE 1

using namespace std;

double total_time;
clock_t start,end;
void *status;


void* byte_of_copy (void *)
{
	char sample1[BYTE], sample2[BYTE];
	
	//For Sequential Access
	start = clock();
	for(int i=0;i<1000000000;i++)
	memcpy(sample2,sample1,sizeof(sample1)); 
	end = clock();
	total_time = (double)end - start/CLOCKS_PER_SEC;
	cout<<"\n* * * * * Seq Access * * * * *";
        cout<<"\nLatency for byte copy of sequential access is : "<<total_time/1000000000*1000<<"msec";
	cout<<"\nThroughput for byte, sequential access is : "<<(double)(BYTE/(1024*1024*total_time))<<"Mb/s";
	
	//For Random Access
	int sample3[BYTE], sample4[BYTE];
	start = clock();
	for(int j=0;j<1000000000;j++)
	for(int i=0; i<BYTE; i++)
	{
		int r = rand()%BYTE;
		memcpy(&sample4[r], &sample3[r], sizeof(sample3));
	}
	end = clock();		
	total_time = (double)end - start/CLOCKS_PER_SEC;
	cout<<"\n* * * * * Random Access * * * * *";
	cout<<"\nLatency for byte copy of random access is : "<<total_time/1000000000*1000<<" msec";
	cout<<"\nThroughput of byte, random access is : "<<(double)(BYTE/(1024*1024*total_time))<<"Mb/sec";

	pthread_exit(NULL);

}


main()
{ 
	pthread_t *thread = new pthread_t[10];
        pthread_attr_t attr;
        pthread_attr_init (&attr);
        pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
        int choice,temp,temp1;
        char choice1;
	
	while(1)
	{
	cout<<"\n\n ***** MENU *****\n\n 1-->Byte Copy of Single thread \n 2-->Byte Copy of Two threads \n\n";
 
	cout<<"\nSelect your choice from above menu : ";
	cin>>choice;
		
	switch(choice)
	{

		case 1 : cout<<"\n*** Byte copy(Single thread) ***";
		 	 temp = pthread_create(&thread[0],&attr,byte_of_copy,NULL);
		 	 pthread_join(thread[0], &status);
		 	 break; 

		case 2 : cout<<"\n*** Byte Copy(Two threads) ***";
		 	 temp = pthread_create(&thread[0],&attr,byte_of_copy,NULL);
		 	 temp1 = pthread_create(&thread[1],&attr,byte_of_copy,NULL);
		 	 if(temp!=0||temp1!=0)
		 	 {
		 	 	cout<<"\n Error in creating thread "<<temp<<endl;
		 	 	exit(-1);	 
		 	 }
		 	 pthread_join(thread[0], &status);
		 	 pthread_join(thread[1], &status);
		 	 break;
	
		default : cout<<"\nPLEASE ENTER A VALID INPUT!!\n";
			 exit(0);
	}

	cout<<"\n\nDo you wish to continue...??? (Yes(y)/No(n))";
	cin>>choice1;

	if(choice1=='y')
		continue;

	else
		exit(0);
	}
}
