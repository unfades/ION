#include <stdio.h>
#include <stdlib.h>

//global variable for ez management of array length
unsigned int len = 0; //initially zero but dynamic, indexes are positive only
int* arr;
void displayElements(int* p){
    for(int i = 0; i<len; i++){
        printf("[%d] ", *p);
        p++;
    }
}

void resizeArray(){
    printf("What do you want the new array size to be?: ");
    int newSize = 0;
    scanf("%d", &newSize);
    if(newSize<len){
        int newArr[newSize]; 
        for(int i = 0; i<newSize; i++) newArr[i] = arr[i];
        len = newSize;
        arr = (int*)malloc(len*sizeof(int)); //reallocated to lower size than original array
        for(int i = 0; i<len; i++) arr[i] = newArr[i]; //now in the reallocated array stored newArr vals
        printf("The array size was reduced to %d\n", len);
        for(int i = 0; i<len; i++) printf("[%d] ", arr[i]);
    }else if(newSize>len){ // I allocated new zeros for the increased len
        int newArr[newSize];
        for(int i = 0; i<len; i++) newArr[i] = arr[i];
        for(int i = newSize-1; i>=len; i--) newArr[i] = 0;
        len = newSize;
        arr = (int*)malloc(len*sizeof(int)); //reallocated to a higher size than original array
        for(int i = 0; i<len; i++) arr[i] = newArr[i]; //now in the reallocated array stored newArr vals
        printf("The array size was increased to %d\n", len);
        for(int i = 0; i<len; i++) printf("[%d] ", arr[i]);
    }else{
        printf("The array was not changed...\n");
        for(int i = 0; i<len; i++) printf("[%d] ", arr[i]);
    }
}

void addElement(){
    printf("What is the number you want to add to the array?: ");
    int newSize = len+1;
    int element = 0;
    scanf("%d", &element);
    int newArr[newSize];
    for(int i = 0; i<len; i++) newArr[i] = arr[i];
    for(int i = newSize-1; i>=len; i--) newArr[i] = element;
    len = newSize;
    arr = (int*)malloc(len*sizeof(int)); //reallocated to a higher size than original array
    for(int i = 0; i<len; i++) arr[i] = newArr[i]; //now in the reallocated array stored newArr vals
    printf("The new element [%d]was added to the last index... %d\n", element);
    for(int i = 0; i<len; i++) printf("%d ", arr[i]);
}

void remElement(){
    int removed = arr[len-1];
    int newSize = len-1;
    if(newSize<0) newSize = 0;
    int element = 0;
    int newArr[newSize];
    for(int i = 0; i<len; i++) newArr[i] = arr[i];
    len = newSize;
    arr = (int*)malloc(len*sizeof(int)); //reallocated to a lower size than original array
    for(int i = 0; i<len; i++) arr[i] = newArr[i]; //now in the reallocated array stored newArr vals
    printf("The element [%d]was removed from the last index... %d\n", removed);
    for(int i = 0; i<len; i++) printf("%d ", arr[i]);
}

void searchElement(int* p){
    printf("What element do you want to search for?\n");
    int el;
    scanf("%d", &el);
    for(int i = 0; i<len; i++){
        if(p[i] == el){ printf("%d is found at index ",*p, i); break;}
        p++;
    }
}

void initializeArray(){
    printf("How many elements in your array?: \n");
    int elements = 0;
    scanf("%d", &elements);
    len = elements;
    arr = (int*)malloc(len*sizeof(int)); // len elements initialized
    for(int i = 0; i<len; i++){
        printf("store a number at element[%d]: ", i);
        int store = 0;
        scanf("%d", &store);
        arr[i] = store;
    }
    displayElements(&arr[0]);
}

void dynamicArray(){
    _Bool b = 1;
    while(b == 1){
        printf("press  0 to search for an element in the array: \n");
        printf("press  1 to make the whole array size different(warning it will wipe elements):\n");
        printf("press  2 to add an element to the array's end: \n");
        printf("press  4 to display the elements in the array: \n");
        printf("press  3 to remove an element from the array's end: \n");
        printf("enter  another number to end the program\n");
        int choice = -1;
        scanf("%d", &choice);
        switch(choice){
            case 0:
                searchElement(&arr[0]);
                break;
            case 1:
                resizeArray();
                break;
            case 2:
                addElement();
                break;
            case 3:
                remElement();
                break;
            case 4:
                displayElements(&arr[0]);
                break;
            default:
                printf("Thanks for using the system user... Program ended.");
                free(arr);
                b = 0;
        }
    }
}

void welcome(){
    printf("welcome to the system.\n");
    printf("do you want to make an array?:y/n\n");
    char response = 'n';
    scanf("%c", &response);
    if(response == 'y' || response == 'Y'){
        printf("program started...\n");
        //initialize n arr, setting len
        initializeArray();
        dynamicArray();
    }else{
        printf("Program ended. Thanks for using the system user.\n");
    }
}

int main(){
    welcome();
    return 0;
}
