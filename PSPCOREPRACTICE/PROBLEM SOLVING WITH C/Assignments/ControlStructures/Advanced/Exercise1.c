#include <stdio.h>
#include <string.h>

void prime(int a){
    if(a==2){
        printf("It is a prime number\n");
        return;
    }
    for(int i = a-1; i>=2; i--){
        if(a%i==0){
            printf("Not a prime number\n");
            break;
        }
    }
    if(a%2!=0){
        printf("It is a prime number\n");
    }
}

void fibo(int a){
    if(a == 0){ 
        printf("0\n");
    }
    if(a == 1){
        printf("0\n");
    }
    if(a == 2){
        printf("1\n");
    }
    if(a>=3){
        int prev = 0;
        int next = 1;
        int sum = 0;
        for(int i = 1; i<a; i++){
            sum = prev+next;
            prev = next;
            next = sum;
        }
        printf("%d \n", prev);
    }
}

void checkpal(int numberr){
    int number2 = numberr;
    int count = 0;
    while(number2>0){
        number2/=10;
        count++;
    }
    char str[12];
    _Bool status = 1;
    sprintf(str, "%d", numberr);
    
    for(int i = 0; i<count/2; i++){
        if(str[i]!= str[count-i-1]){
            status = 0;
            break;
        }
    }
    if(status == 1){
        printf("Palindrome");
    }else{
        printf("Not a palindrome");
    }
}

int main(){
    _Bool b = 1;
    while(b == 1){
        printf("Choose your program...\n");
        printf("Press 1 for checking if number is prime,\n");
        printf("Press 2 for fibonacci up to n terms,\n");
        printf("Press 3 to check if a number is Palindrome,\n");
        printf("Press anything else to exit the program.\n");
        printf("Then press enter:\n");
        int cond = 0;
        int number = 0;
        scanf("%d", &cond);
        
        switch(cond){
            case 1:
                printf("Enter a numbe to check if it is prime or not: \n");
                number = 0;
                scanf("%d", &number);
                prime(number);
                break;
            case 2:
                printf("Enter upto how much you want your fibonacci numbers: \n");
                number = 0;
                scanf("%d", &number);
                fibo(number);
                break;
            case 3:
                printf("Enter a number to check if it is palindrome or not\n");
                number = 0;
                scanf("%d", &number);
                checkpal(number);
                break;
            default:
                b = 0;
                break;
        }
    }
    return 0;
}
