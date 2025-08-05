#include <stdio.h>
#include <conio.h>

int main(){
    
    //printing
    printf("%s", "Hello World");
    // types in c
    //unit 2.4 data types in C
    int myInt = 1;
    char myChar = 'A';
    float myFloat = 10.0f;
    double myDouble = 10.0;
    long double  myLongDouble = 10.000000000000009L;
    //Only integer vals char, int, short, long long can be unsigned
    unsigned int myUnsignedInt = 10;
    unsigned short myUnsignedShort = 10;
    unsigned char myUnsignedChar = 'A';
    unsigned long myUnsignedLong = 10000000L;
    unsigned long long myUnsignedLongLong = 100000000000L;
    char myCharArray[] = "Hello World";
    char myCharArr2[6] = {'H','e','l','l','o','\0'};
    
    /*
    constants in C
    3.14       // double
    3.14f      // float
    3.14L      // long double

    100        // int
    100U       // unsigned int
    100L       // long int
    100UL      // unsigned long
    100LL      // long long int
    100ULL     // unsigned long long
    */
    printf("\n%s", myCharArray);
    printf("\n%s", myCharArr2);

    //scanning in c
    int a;
    scanf("%d", &a);

    unsigned int b;
    scanf("%u", &b);

    short s;
    scanf("%hd", &s);

    unsigned short us;
    scanf("%hu", &us);

    long l;
    scanf("%ld", &l);

    long long ll;
    scanf("%lld", &ll);

    float f;
    scanf("%f", &f);

    double d;
    scanf("%lf", &d);

    long double ld;
    scanf("%Lf", &ld);

    char c;
    scanf(" %c", &c); // space to skip whitespace

    char str[100];
    scanf("%s", str);
    
    return 0;
}

