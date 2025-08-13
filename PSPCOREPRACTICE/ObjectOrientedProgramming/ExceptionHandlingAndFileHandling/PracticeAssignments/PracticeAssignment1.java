package ExceptionHandlingAndFileHandling.PracticeAssignments;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
//reading
import java.io.FileReader;
import java.io.BufferedReader;
//writing PrintWriter>FileWriter because no need to convert those values to Strings
import java.io.PrintWriter;
//exceptions imported I am catching
import java.io.IOException;

class Book{
    private int bookID;
    private String bookName;
    private String bookAuthor;

    public void setBook(int bookID, String bookName, String bookAuthor){
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public void getBook(){
        System.out.println("Book information is: ");
        System.out.println(this.bookID);
        System.out.println(this.bookName);
        System.out.println(this.bookAuthor);
        System.out.println("_________________________");
    }

    public String getBookInfo(){
        StringBuilder str = new StringBuilder();
        str.append("id: " + this.bookID + ", name: " + this.bookName + ", author: " + this.bookAuthor);
        return str.toString();
    }
}

class BookSystem{
    private List<Book> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addBook(){
        Book b = new Book();
        System.out.println("What is the book ID?: ");
        int bookID = Integer.valueOf(sc.nextLine());
        System.out.println("What is the book name?: ");
        String name = String.valueOf(sc.nextLine());
        System.out.println("What is the Author name?: ");
        String author = String.valueOf(sc.nextLine());
        b.setBook(bookID, name, author);
        list.add(b);
    }

    public void displayAllBooks(){
        for(Book b : list){
            b.getBook();
        }
    }

    public List<Book> getList(){
        return list;
    }

    public String getBookData(){
        StringBuilder str = new StringBuilder();
        for(Book b: list){
            str.append("" + b.getBookInfo() + "\n");
        }
        return str.toString();
    }
}

public class PracticeAssignment1 {
    public static void main(String[] args) {
        BookSystem bs = new BookSystem();
        bs.addBook();
        bs.addBook();
        bs.displayAllBooks();


        File myFile = null;
        PrintWriter prw = null;
        //use filehandling and try catch to add to a file
        //then read the entered values from the file also
        //handle fnf and io exceptions ie read write failures
        //or data format issues also
        String path = "D:/Code Playground/PSPION/PSPCOREPRACTICE/ObjectOrientedProgramming/ExceptionHandlingAndFileHandling/PracticeAssignments/FileToAlter.txt";
        try{
            prw = new PrintWriter(path);
            String content = bs.getBookData();
            prw.println(content);

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(prw!=null){
                try{
                    prw.close();
                    System.out.println("file closed successfully...");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        //this is for reading the file...
        myFile = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            myFile = new File("D:/Code Playground/PSPION/PSPCOREPRACTICE/ObjectOrientedProgramming/ExceptionHandlingAndFileHandling/PracticeAssignments/FileToAlter.txt");
            fr = new FileReader(myFile);
            br = new BufferedReader(fr);
            String str;
            StringBuilder fileStore = new StringBuilder();
            while((str = br.readLine())!= null){
                    fileStore.append("\n");
                    fileStore.append(str);
            }
            str = fileStore.toString();
            //now str holds all the data in the File
            System.out.println("The scanned file was read and this is the data from the file: ");
            System.out.println(str);
        }catch(IOException e){
            System.out.println("There was some io exception reading the file " + e.getMessage());
        }finally{
            if(fr!=null){
                try{
                    fr.close();
                }catch(Exception e){
                    System.out.println("Some problem closing the file " + e.getMessage());
                }
            }
        }
    }
}

/*
Use any programming language (C++,Java or Python)
ü Create a Book class to encapsulate book details such as Book ID, Title,
and Author, and provide a method to display book information.
ü Implement methods to add new books to a list and display all stored
books, ensuring modular and reusable code.
ü Use file handling to write the list of books to a file (e.g., in CSV or
plain text format) and read it back into the program.
ü Apply exception handling (e.g., try-except in Python or try-catch in
Java/C++) to manage errors like file not found, read/write failures, or
data format issues.
ü Test the system by adding sample books, saving them to a file,
reloading them, and displaying the loaded data to verify correctness.
ü Ensure data persistence by maintaining file integrity and handling
edge cases like empty files or corrupted data gracefully
 */
