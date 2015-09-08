CPU BENCHMARK
•	PURPOSE: 
This benchmark measures the speed of the processor in terms of GFLOPS and GIOPS running multiple instructions concurrently. Multi-Threading environment is exploited by running the instructions in 2,4,8 threads also.

•	CODE FLOW: 
The file cpu_flops.cpp file has the code that measures the CPU speed in terms of GFLOPS. Addition of two floating point numbers is implemented for this purpose. The flow of this code is as follows.
a.	The addition operation of floating point numbers is performed by the function addition_of_float(void * ).
b.	main() function has the code to create threads which runs concurrently adding the numbers.
i.	pthread_t *thread = new pthread_t[30];
c.	The attributes of the threads are set as follows
i.	pthread_attr_t attribute;
ii.	pthread_attr_init (&attribute);
iii.	pthread_attr_setdetachstate(&attribute, PTHREAD_CREATE_JOINABLE);
The file cpu_iops.cpp file has the code that measures the CPU speed in terms of GIOPS. Unlike the previous code, here the increment operation of an integer is implemented.
a.	This is embedded inside the function increment_of_integer(void *).
b.	Workflow of main() function is as same as above.
A clock() function is used to determine the time taken to perform the addition as well as the increment operations. 
The creation of new thread for the specific function is implemented as,
	temp = pthread_create(&thread[1],&attribute,addition_of_float,NULL);
	temp = pthread_create(&thread[1],&attribute,increment_of_integer,NULL);
Separate calling function functions are written for 1,2,4 and 8 threads and the total time is also calculated.

•	EXECUTION:
 The source code code contains 2 separate files for measuring the speed in terms of GFLOPS and GIOPS respectively, and has to be compiled separately.
GFLOPS
$ g++ cpu_flops.cpp –pthread
./a.out
Or
$ make –f cpu_flops_compile
	GIOPS
$ g++ cpu_iops.cpp –pthread
./a.out
Or
$ make - f cpu_iops_compile
 

 
