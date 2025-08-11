#include <stdio.h>
#include <stdlib.h>

//command line args in c
//common set bits means bitwise anding of each of the numbers, checking result for what are '1' in it
//bitshift right to count the number of 1s in each integer arg until it becomes 0
int main(int argc, char* argv[]){
    //argv[0] is the program file name which is not our args
    int result = atoi(argv[1]);
    for(int i = 1; i<argc; i++){
        int number = atoi(argv[i]);
        result = result&number; // anding all the bits into result
        int history = number;
        int countSetBits = 0;
        while(number>0){
            
            if((number&1) == 1) countSetBits++;
            number = number>>1;
        }
        printf("the number of set bits in %d is %d\n", history, countSetBits);
    }
    int position = 0;
    while(result>0){
        if((result&1) == 1)
            printf("position %d is a common set bit\n", position++);
        result = result >> 1;
    }
    return 0;
}

/// to run do gcc LearnCLI.c -o LearnCLI
// then just do this like ./LearnCLI 5 7 15