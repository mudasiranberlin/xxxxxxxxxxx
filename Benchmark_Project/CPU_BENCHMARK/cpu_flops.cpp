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

void* addition_of_float(void *) //floating point addition function
{
    float sample_float1,sample_float2,sample_float3;
	sample_float1 = 132.3;
	sample_float2 = 128.6;
	for(int i=1;i<1000000000;i++)
	{
		sample_float3 = sample_float1+sample_float2;
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
	
	
	// FLOPS for single thread	
	cout<<"\n******************** FLOPS for one(1) thread ********************\n";
	start_1 = clock();
	temp = pthread_create(&thread[0],&attribute,addition_of_float,NULL);
         if(temp)
	{
			cout<<"\nerror in creating thread"<<temp<<endl;
			exit(-1);
	}
	
	pthread_join(thread[0],&status);
	end_1 = clock();
	end_2 = time(NULL);
	total_time = (double)end_1-start_1;
	cout<<"\nFLOPS for  thread = "<<(float)1000000000*2/(total_time/CLOCKS_PER_SEC)<<endl;
	

	// FLOPS for 2 threads

	cout<<"\n******************** FLOPS for two(2) thread ********************\n";
	start_1 = clock();
	temp = pthread_create(&thread[1],&attribute,addition_of_float,NULL);
         if(temp)
	{
			cout<<"\nerror in creating thread"<<temp<<endl;
			exit(-1);
	}
	temp1 = pthread_create(&thread[2],&attribute,addition_of_float,NULL);
         if(temp1)
	{
			cout<<"\nerror in creating thread"<<temp1<<endl;
			exit(-1);
	}
	pthread_join(thread[1],&status);
	pthread_join(thread[2],&status);
	end_1 = clock();
	total_time = (double)end_1-start_1;
	cout<<"\nFLOPS for  thread = "<<(float)1000000000*2*2/(total_time/CLOCKS_PER_SEC)<<endl;

	
	// FLOPS for 4 threads
	cout<<"\n******************** FLOPS for Four(4) thread ********************\n";
	start_1 = clock();
	for(int i=0;i<4;i++)
	{
		temp = pthread_create(&thread[i],&attribute,addition_of_float,NULL);
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
	cout<<"\nFLOPS for  thread = "<<(double)1000000000*2*4/(total_time/CLOCKS_PER_SEC)<<endl;



	// FLOPS for 8 threads
	cout<<"\n******************** FLOPS for Eight(8) thread ********************\n";
	start_1 = clock();
	for(int i=0;i<8;i++)
	{
		temp = pthread_create(&thread[i],&attribute,addition_of_float,NULL);
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
	cout<<"\nFLOPS for  thread = "<<(double)1000000000*2*8/(total_time/CLOCKS_PER_SEC)<<endl;

}
