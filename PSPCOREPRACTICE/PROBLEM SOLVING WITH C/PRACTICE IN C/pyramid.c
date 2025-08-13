#include <stdio.h>
#include <string.h>

int main(){
    int n = 11;
    int repeat = 1;
    int spaces = n-1;
    char spaceadder[20] = " ";
    char pointadder[20] = "*";
    char twiceadder[20] ="**";
    for(int i = 0; i<n; i++){
        for(int j = 0; j<spaces; j++){
            printf("%s", spaceadder);
        }
        for(int j = 0; j<repeat; j++){
            printf("%s", pointadder);
        }
        spaces--;
        strcat(pointadder, twiceadder);
        printf("\n");
    }
}
/*
   4*
  3***
 2*****
1*******
*********<-0
*/