#include<stdio.h>
#include<iostream>
#include<stdlib.h>
#include<time.h>
#include<ctime>
#include<unistd.h>
#include<pthread.h>

#define MB (1024*1024)
#define BYTE 1

using namespace std;

clock_t start,end;
double total_read_time,total_write_time;
void *status; 
FILE *fp;
char *buffer =  new char[BYTE];


void* megabyte_of_transfer (void *)
{
       
        for(int i=0; i<BYTE; i++)
        buffer[i] = char(i);
	fp = fopen("Megabyte.txt","w+");

	//For Sequential Access
	//Write
	start = clock();
	for(int i=0;i<MB;i++)
	{            
		fwrite(&buffer[0],1,BYTE,fp);
		
	}
	end = clock();
	
	total_write_time = (double)end-start/CLOCKS_PER_SEC;
	cout<<"\n* * * * * Seq Access * * * * *";
	cout<<"\nLatency(time for megabyte write operation) is   : "<<total_write_time/(MB*1000)<<"msec";
        cout<<"\nMegaByte write speed : "<<(double)(BYTE/(total_write_time))<<"Mb/s";
	//Read
	start = clock();
	for(int i=0;i<MB;i++)
	{
		
		fread(&buffer[0],BYTE,1,fp);
		
	}
	end = clock();

	total_read_time = (double)end-start/CLOCKS_PER_SEC;
	cout<<"\nLatency(time for megaByte read operation) is  : "<<total_write_time/(MB*1000)<<"msec";
        cout<<"\nMegaByte read speed = "<<(double)(BYTE/(total_read_time))<<"Mb/s";
	

	//Random Access
	//Write
	start = clock();
	for(int i=0;i<MB;i++)
	{
		int r = rand()%MB;
		fseek(fp,r,SEEK_SET);        
		fwrite(buffer,1,BYTE,fp);		
	}
	end = clock();
	total_write_time = (double)end-start/CLOCKS_PER_SEC;
	cout<<"\n* * * * * Random Access * * * * *";
	cout<<"\nLatency(time for megabyte write operation) is   : "<<total_write_time/(MB*1000)<<"msec";
	cout<<"\nMegaByte write speed = "<<(double)(MB/(total_write_time))<<"Mb/s";

	//Read
	start = clock();
	for(int i=0;i<MB;i++)
	{	
		int r = rand()%MB;
		fseek(fp,r,SEEK_SET);
		fread(buffer,BYTE,1,fp);	
	}
	end = clock();
	total_read_time = (double)end-start/CLOCKS_PER_SEC;
	cout<<"\nLatency(time for megaByte read operation) is  : "<<total_write_time/(MB*1000)<<"msec";
        cout<<"\nMegaByte read speed = "<<(double)(MB/(total_read_time))<<"Mb/s";
	
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
	cout<<"\n\n ***** MENU *****\n\n 1-->Megabyte Transfer of Single thread \n 2-->Megabyte Transfer of Two threads \n 3-->Megabyte Transfer of Four threads \n\n";
 
	cout<<"\nSelect your choice from above menu : ";
	cin>>choice;
		
	switch(choice)
	{
		case 1 : cout<<"\n*** MegaByte Transfer(Single thread) ***";
		 	 temp = pthread_create(&thread[0],&attr,megabyte_of_transfer,NULL);
		 	 pthread_join(thread[0], &status);
		 	 break;

		case 2 : cout<<"\n*** MegaByte Transfer(Two threads) ***";
		 	 temp = pthread_create(&thread[0],&attr,megabyte_of_transfer,NULL);
		 	 temp1 = pthread_create(&thread[1],&attr,megabyte_of_transfer,NULL);
		 	 if(temp!=0||temp1!=0)
		 	 {
		 	 	cout<<"\n Error in creating thread "<<temp<<endl;
		 	 	exit(-1);	 
		 	 }
			 pthread_join(thread[0], &status);
		 	 pthread_join(thread[1], &status);
		 	 break;

		case 3 : cout<<"\n*** MegaByte Transfer(Four threads) ***";
			 for(int i=0;i<4;i++)
			 {
				temp = pthread_create(&thread[i],&attr,megabyte_of_transfer,NULL);
        	 		if(temp)
				{
					cout<<"\nerror in creating thread"<<temp<<endl;
					exit(-1);
				}
			 }
		 	 for(int i=0;i<4;i++)
			 pthread_join(thread[i],&status);
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
	free(buffer);
}

