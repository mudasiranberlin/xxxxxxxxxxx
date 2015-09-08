#include<math.h>
#include<stdlib.h>
#include<algorithm>
#include<time.h>
#include<stdio.h>
#include<iostream>
#include<ctime>
#include<unistd.h>
#include<cstdlib>
#include<cuda_runtime.h>
#include<cuda.h>
#include<curand_kernel.h>
#include "device_launch_parameters.h"
#include <cuda_runtime_api.h>
#include <thrust/host_vector.h>
#include <thrust/device_vector.h>
#include <thrust/transform.h>
#include <thrust/sequence.h>
#include <thrust/copy.h>
#include <thrust/fill.h>
#include <thrust/replace.h>
#include <thrust/functional.h>
__global__


void computation(int n, float a, float *r1, float *r2)
{
  int temp = blockIdx.x*blockDim.x + threadIdx.x;
  if (temp < n) r1[temp] = a*r1[temp] + r2[temp];
}

int main(void)
{
  int NUM = 20 * (1 << 20);
  float *r1, *r2, *d_x, *d_y;
  r1 = (float*)malloc(NUM*sizeof(float));
  r2 = (float*)malloc(NUM*sizeof(float));

  cudaMalloc(&d_x, NUM*sizeof(float)); 
  cudaMalloc(&d_y, NUM*sizeof(float));

  for (int t = 0; t < NUM; t++) 
  {
    r1[i] = 10.0f;
    r2[i] = 20.0f;
  }

  cudaEvent_t start, stop;
  cudaEventCreate(&start);
  cudaEventCreate(&stop);

  cudaMemcpy(d_x, r1, NUM*sizeof(float), cudaMemcpyHostToDevice);
  cudaMemcpy(d_y, r2, NUM*sizeof(float), cudaMemcpyHostToDevice);

  cudaEventRecord(start);

  computation<<<(NUM+511)/512,512>>>(NUM, 2.0f, d_x, d_y);


  cudaEventRecord(stop);

  cudaMemcpy(r2, d_y, NUMs*sizeof(float), cudaMemcpyDeviceToHost);

  cudaEventSynchronize(stop);
  float milliseconds = 0;
  cudaEventElapsedTime(&milliseconds, start, stop);

  float maxError = 0.0f;
  for (int z = 0; z < NUM; z++) 
  {
    maxError = max(maxError, abs(r1[z]-4.0f));
  }

  printf("\n ***THE Max error found: %fn", maxError);
  printf(" \n **Gflops = %f\n",2NUM / (t * 109));
  printf("\n **Effective Bandwidth (GB/s): %fn", NUM*4*3/milliseconds/1e6);
}

