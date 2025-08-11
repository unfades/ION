//dynamic memory allocation using pointer
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
    int *arr;
    arr = (int*)malloc(5*sizeof(int)); //int size memory allocated, its an array
    for(int i = 0; i<5; i++){
        arr[i] = i+1; //assigning vals into array
    }

    for(int i = 0; i<5; i++){
        printf("%d ", arr[i]); //prints stored vals
    }
    free(arr); //deallocates the memory that was for arr array
    //dont make a dangling pointer, set them to null after using them
    arr = NULL;
    return 0;
}

/*program 1

#include <stdio.h>

int main(){

    int i = 3;
    //%u means unsigned integer, meaning no negative representation
    printf("\nAddress of i=%u", &i);
    printf("\nvalue at i=%u", i);
    
    return 0;
}

why we use poiners:

memory management - 
efficient data manipulation - 
dynamic memory allocation - 
passing function arguments - 
hardware level access - device drivers, embedded system programming
interfacing with low level apis - direct memory access game dev, OS, network hardware

Basic pointer concepts: 

1 memory address - every pointer resides in memory
2 pointer variable - stores the address of another variable
3 address of operator(&) ampersand - gets the address of the variable
4 dereference operator(*) dereference - used for accessing or modifying the pointer variable

//program 2 how to declare and initialize the pointer

#include <stdio.h>

int main(){

    //syntax: datatype *pointer_name
    //ex
    //a variable x = 5
    int x = 5;
    //pointer variable *p stores the address of x
    //pointer variable always stores the address of a variable
    int *p = &x;
    //NOTE
    //similarly these store the addresses of these values at some address
    //the address is not int, char, float, addresses are a whole number always!
    //the values stored at the addresses however are int, char, float
    int *alpha;
    char *ch;
    float *s;

    return 0;
}

//Example of the previous NOTE from program 2

#include <stdio.h>

int main(){
    //image explanation: https://prnt.sc/-vreV9avuZn1
    int x = 10;
    int *ptr = &x;
    printf("value of x:%d\n", x);
    //it must be because the addresses cannot be negative, that is why
    //the specifiere %u
    printf("Address of x:%u\n", &x);

    printf("Value stored in ptr: %u\n",ptr); //address
    printf("Value pointed by ptr: %d\n", *ptr); //val of x
    return 0;
}

//HOUSE Address Analogy of pointers

#include <stdio.h>

int main(){
    
    char person[20] = "person"; // string person is stored at some house address in memory
    char* ptr = person; 
    //pointer holding the house address of the value, here, person.
    //without knowing the house address in memory, we cannot access the person,
    //because that person is at that house address.

    printf("The name of the person is %s", ptr);
    printf("The address at which person resides is %u", *ptr);
}

A dangling pointer is a pointer which points to an old address but the value has moved

//VALUE AT THE ADDRESS USAGE ASTERIX(AMPERSAND VARIABLE)

#include <stdio.h>

int main(){

    int i = 3;
    printf("\nAddress of i=%u",&i);
    printf("\nValue of i=%d", i);
    //asterix (ampersand i)
    //address of i is 65524
    //asterix before it means value at
    //meaning value at that address
    //*(&i) means value at address of i, meaning 3
    printf("\nValue of i=%d", *(&i));
    
    return 0;
}

//REFERENCING and DEREFERENCING

#include <stdio.h>
#include <string.h>

int main(){

    int y = 20;
    int*p = &y; //means p stores the address of y

    printf("Before the value of y is: %u\n", *p); //value at the address of p, y's value
    printf("Before the value of y is: %u\n", y); // the same thing as y
    //changing the value
    *p = 30; //modifies the value stored at the address of y, y changed from 20 to 30
    printf("After the value of y is: %u\n", *p); //value at the address of p
    printf("After the value of y is: %u\n", y); // the same thing as y

    //self practice
    char name[20] = "shadab";
    printf("Hello the name is %s", name);
    char* changer = name;
    strcpy(changer, "ali");
    printf("I changed my name to %s now", name);
    return 0;
}

//REFERENCING and DEREFERENCING

#include <stdio.h>
#include <string.h>

int main(){

    int i = 3;
    int *j;
    j = &i;

    printf("\nAddress of i = %u", &i); //it means this is the memory location of i
    printf("\nAddress of i = %u", j); //j holds the value of i's memory location

    printf("\nAddress of j = %u", &j); //the memory location of j is different
    printf("\nValue of j = %u", j); //the value of j is the memory location of i
    printf("\nValue of i = %u", i); //the value of i held in i directly
    printf("\nValue of i = %u", *(&i)); //the value of i via asterix(address of i)
    printf("\nValue of i = %u", *j); //the value of i using j's asterix(j) as j holds address of i

}

//Swapping of 2 numbers using pointer variables, swapping strings,
//swapping arrays
//SWAPPING USING POINTERS

#include <stdio.h>
#include <string.h>

//swap takes in &x, &y addresses into pointer variables
//then it swaps the addresses values for the pointers
//meaning they now point to each others locations in memory
void swap(int* a, int* b){

    int temp = *a;
    *a = *b;
    *b = temp;
}

//*a holds the value of the address of str
//a is the value at the str
void swap2(char* a, char* b){
    char temp[20] = "";
    strcpy(temp, a);
    strcpy(a, b);
    strcpy(b, temp);
}


//swap arrays in c
void swap3(int* a, int* b, int size){
    for(int i = 0; i<size; i++){
        int temp = *a;
        *a = *b;
        *b = temp;
        //pointer arithmetic, moving memory locations of int size forward
        //if it was char then it would move char memory locations forward,
        //effectively accessing the next character
        a+=1;
        b+=1;
    }
}
int main(){

    int x, y;
    printf("Enter 2 numbers: ");
    scanf("%d %d", &x, &y);

    printf("Before swapping x: %d y: %d\n", x,y);
    //pass addresses of x and y into swap()
    swap( &x, &y);
    printf("After swapping x: %d y: %d\n", x,y);

    ///self practice
    char name[20] = "ali";
    char* p1 = name;
    char name2[20] = "lia";
    char* p2 = name2;
    swap2(p1,p2);
    printf("%s\n", name);
    printf("%s\n", name2);

    //swap arrays
    int array1[3] = {1,2,3};
    int array2[3] = {4,5,6};
    printf("before swapping: \n");
    for(int i = 0; i<3; i++)
        printf("%d,",array1[i]);
    printf("\n");
    for(int i = 0; i<3; i++)
        printf("%d,",array2[i]);
    swap3(&array1[0], &array2[0], 3);
    printf("\n");
    printf("after swapping: \n");
    for(int i = 0; i<3; i++)
        printf("%d,",array1[i]);
    printf("\n");
    for(int i = 0; i<3; i++)
        printf("%d,",array2[i]);
    
    return 0;
}

//Incrementing a pointer
#include <stdio.h>
#include <string.h>


int main(){

    int arr[3] = {10,20,30};
    int* p = arr; //first index of array
    for(int i = 0; i<3; i++){
        printf("value of arr[%d] is %d\n", i, *(&arr[i]));
        printf("value of arr[%d] is %d\n", i, *p);
        p++; //increments to the next element in the array without it it points to arr[0]
    }
    return 0;
}

//pointer subscript notation with []

#include <stdio.h>
#include <string.h>

//u can use p[i] instead of *p in order to mention memory locations of pointers accessing certain types
//like arrays
int main(){

    int arr[3] = {10,20,30};
    int* p = arr; //first index of array
    for(int i = 0; i<3; i++){
        printf("value of arr[%d] is %d\n", i, *(&arr[i]));
        printf("value of arr[%d] is %d\n", i, p[i]);
        
    }
    
    return 0;
}

//HOW TO DYNAMICALLY ALLOCATE MEMORY USING POINTERS

//dynamic memory allocation using pointer
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
    int *arr;
    arr = (int*)malloc(5*sizeof(int)); //int size memory allocated, its an array
    for(int i = 0; i<5; i++){
        arr[i] = i+1; //assigning vals into array
    }

    for(int i = 0; i<5; i++){
        printf("%d ", arr[i]); //prints stored vals
    }
    free(arr); //deallocates the memory that was for arr array
    //dont make a dangling pointer, set them to null after using them
    arr = NULL;
    return 0;
}
*/