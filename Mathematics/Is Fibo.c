#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() 
{
 long int T,i,j;
 long double y,q,k;
 scanf("%ld\n",&T);
 long long int N[T];
 for(i=0;i<T;i++)
 {   scanf("%lld\n",&N[i]);
     k=N[i];
     y = sqrt(5*k*k+4);
     q = sqrt(5*k*k-4);
  
    if((y-(long int)y == 0)||(q-(long int)q == 0)) 
     printf("IsFibo\n");
    else 
     printf("IsNotFibo\n"); 
 } 
 
 return 0;
} 
