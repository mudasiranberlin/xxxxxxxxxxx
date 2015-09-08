DISK BENCHMARK
PURPOSE:
This benchmark measures the speed of the disk for the read and write operations. Both sequential and random seeks are implemented for varying concurrency levels[1 through 4 threads] and varying block sizes[ 1byte, 1 kilobyte and 1megabite]

CODE FLOW:
The benchmark has 3 individual file in it. 
•	disk_byte.cpp: This file has a function byte_of_transfer(void *) which copies a byte of data into the disk.
•	disk_kilobyte.cpp: This file has a function kilobyte_of_transfer(void *) which copies a byte of data into the disk.
•	disk_megabyte.cpp: This file has a function megabyte_of_transfer(void *) which copies a byte of data into the disk.
Three major file file handling functions are used. Their implementations are as follows,
•	fp = fopen("Byte.txt","w+");
A simple text file is created with this function.
•	fwrite(buffer,1,BYTE,fp);
This writes the data from buffer to the text file.
•	fread(buffer,BYTE,1,fp);
This reads a byte of data from the text file into the buffer.
File *fp; - It is file pointer that points to particular file location, while void *status; - returns the status of thread join.

The RANDOM seeks are used only with kilobyte and megabyte transfers. For instance, 
r = rand()%MB (for megabyte) 
statement selects any random number and stores in variable r.  
fseek(fp,r,SEEK_SET) 
places the pointer to that random position and further reads or writes into file.

Clock() function is used to determine the time taken for the transfers, Difference of end time and start time allocated in tot_time_write variable and latency and write speed is calculated in MB/sec accordingly.

The main() function provides the choice to the user for selecting the concurrency as well as the block size. 



EXECUTION:


$ g++ disk_byte.cpp 
–pthread
$ ./a.out
Or
$ make –f disk_byte_compile	
$ g++ disk_kilobyte.cpp 
–pthread
$ ./a.out
Or
$ make –f disk_kilobyte_compile	
$ g++ disk_megabyte.cpp 
–pthread
$ ./a.out
Or
$ make –f disk_megabyte_compile

