#include<stdlib.h>
#include<time.h>
#include<iostream>
#include<ctime>
#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

using namespace std;

float total_time;
void *status;
clock_t start, end;

void* increment_of_integer(void * ) //addition function
{
	int sample_int;
	sample_int = 50;
	for(int i=1;i<1000000000;i++)
	{
		sample_int = sample_int+i;
	}
	pthread_exit(NULL);        	
}

main()
{

	pthread_t *thread = new pthread_t[30];
	pthread_attr_t attribute;
	pthread_attr_init (&attribute);
	pthread_attr_setdetachstate(&attribute, PTHREAD_CREATE_JOINABLE);
	int temp,temp1;
  	time_t start_1, start_2, start_3, end_1,end_2;
	

	// IOPS for 1 thread
	cout<<"\n******************** IOPS for One(1) thread ********************\n";	
	start_1 = clock();
	start_2 = time(NULL);
	time(&start_3);
	temp = pthread_create(&thread[3],&attribute,increment_of_integer,NULL);
         if(temp)
	{
			cout<<"\nerror in creating thread\n"<<temp<<endl;
			exit(-1);
	}
	pthread_join(thread[3],&status);
	end_1 = clock();
	total_time = (double)end_1-start_1;
	cout<<"\nIOPS for  thread = "<<(float)1000000000*2/(total_time/CLOCKS_PER_SEC)<<endl;



	// IOPS for 2 threads
	cout<<"\n******************** IOPS for two(2) thread ********************\n";
	start_1 = clock();
	temp = pthread_create(&thread[4],&attribute,increment_of_integer,NULL);
         if(temp)
	{
			cout<<"\nerror in creating thread"<<temp<<endl;
			exit(-1);
	}

	temp = pthread_create(&thread[5],&attribute,increment_of_integer,NULL);
         if(temp)
	{
			cout<<"\nerror in creating thread"<<temp<<endl;
			exit(-1);
	}

	pthread_join(thread[4],&status);
	pthread_join(thread[5],&status);
	end_1 = clock();
	total_time = (double)end_1-start_1;
	cout<<"\nIOPS for  thread = "<<(float)1000000000*2*2/(total_time/CLOCKS_PER_SEC)<<endl;
	
	
		
	
	// IOPS for 4 threads
	cout<<"\n******************** IOPS for Four(4) thread ********************\n";
	start_1 = clock();
	
	for(int i=0;i<4;i++)
	{
		temp = pthread_create(&thread[i],&attribute,increment_of_integer,NULL);
        	 if(temp)
		{
			cout<<"\nerror in creating thread"<<temp<<endl;
			exit(-1);
		}
	}
	
	for(int i=0;i<4;i++)
	pthread_join(thread[i],&status);
	
	end_1 = clock();
	
	total_time = (double)end_1-start_1;
	cout<<"\nIOPS for  thread = "<<(double)1000000000*2*4/(total_time/CLOCKS_PER_SEC)<<endl;


	// IOPS for 8 threads
	cout<<"\n******************** IOPS for Eight(8) thread ********************\n";
	start_1 = clock();
	
	for(int i=0;i<8;i++)
	{
		temp = pthread_create(&thread[i],&attribute,increment_of_integer,NULL);
        	 if(temp)
		{
			cout<<"\nerror in creating thread"<<temp<<endl;
			exit(-1);
		}
	}
	
	for(int i=0;i<8;i++)
	pthread_join(thread[i],&status);
	
	end_1 = clock();
	
	total_time = (double)end_1-start_1;
	cout<<"\nIOPS for  thread = "<<(double)1000000000*2*8/(total_time/CLOCKS_PER_SEC)<<endl;
}

