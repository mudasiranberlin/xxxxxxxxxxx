GPU BENCHMARK

PURPOSE:
This benchmark is used to compute the GFLOPS i.e the performance of the Graphics Processing Unit. This is can be used to run concurrently and also varying block sizes can be used with the following benchmark.

CODE FLOW:
The execution starts from the main() function and calls malloc() where the memory is assigned of a particular size. 
cudaEvent_t start, stop;
cudaEventCreate(&start);
cudaEventCreate(&stop);
These inbuilt functions are used to start and stop the events.

cudaMemcpy(d_x, r1, NUM*sizeof(float), cudaMemcpyHostToDevice);   
cudaMemcpy(d_y, r2, NUM*sizeof(float), cudaMemcpyHostToDevice);
Copies count bytes from the memory area pointed to by source to the memory area pointed to by destination.
dst 	- Destination memory address
src 	- Source memory address
count 	- Size in bytes to copy
kind 	- Type of transfer

The computation() function is then called and that function computes the performance of the GPU in GFLOPS.

EXECUTION:  
$ g++ cuda.cpp
$ ./a/out
 
