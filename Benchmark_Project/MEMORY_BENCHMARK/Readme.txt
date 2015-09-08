MEMORY BENCHMARK
PURPOSE:
This benchmark serves as a tool to measure the throughput and latency of the memory. The code is written such that is measures both random as well as sequential accesses thoroughly and gives out the result. Here the concurrency and the block sizes are varied.

CODE FLOW:
The benchmark has 3 individual file in it. 
•	memory_byte.cpp: This file has a function byte_of_copy(void *) which copies a byte of data into memory.
•	memory_kilobyte.cpp: This file has a function kilobyte_of_copy(void *) which copies a byte of data into memory.
•	memory_megabyte.cpp: This file has a function megabyte_of_copy(void *) which copies a byte of data into memory.

All of the three functions implements both sequential and random accesses respectively. Sequential access is achieved by a simple for loop implementation however the random access is done as follows.
•	int r = rand()%BYTE;
rand() is an inbuilt function which generates a random number. The memcpy() function uses the generated number to copy the data to that location. 

Then memcpy(sample2, sample1, sizeof(sample1)) function is used, where it copies the values of integer ‘sample1’ bytes from the location pointed by source ‘sample1’ directly to the memory block pointed by destination integer ‘sample2’. 

The start and end time of this process recorded using clock() function. The difference between end and start time computes the total time taken which is stored in variable total_time.

The latency is value of total_time, while throughput is calculated as size/(total_time).

a.	main() function has the code to create threads which runs concurrently adding the numbers.
i.	pthread_t *thread = new pthread_t[30];
b.	The attributes of the threads are set as follows
i.	pthread_attr_t attribute;
ii.	pthread_attr_init (&attribute);
iii.	pthread_attr_setdetachstate(&attribute, PTHREAD_CREATE_JOINABLE);
The creation of new thread for the specific function is implemented as,
•		temp = pthread_create(&thread[1],&attr,byte_of_copy,NULL);
•		temp = pthread_create(&thread[1],&attr,kilobyte_of_copy,NULL);
•	                temp = pthread_create(&thread[1],&attr,megabyte_of_copy,NULL);
Separate calling function functions are written for 1 and 2 threads and the total time is also calculated.
The command pthread_join(thread[0], &status); and pthread_join(thread[1], &status); functions waits for a thread to terminate, detaches the thread, then returns the threads exit status. At last, if user wish to continue i.e. choice == ‘y’, the menu is again displayed for re-execution of program.

Execution:
$ g++ memory_byte.cpp 
–pthread
$ ./a.out
Or
$ make –f memory_byte_compile	
$ g++ memory_kilobyte.cpp 
–pthread
$ ./a.out
Or
$ make –f memory_kilobyte_compile
	
$ g++ memory_megabyte.cpp 
–pthread
$ ./a.out
Or
$ make –f memory_megabyte_compile


