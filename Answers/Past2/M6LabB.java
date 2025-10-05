package Answers;
import java.util.ArrayList;

public class M6LabB {

    public static void main(String[] args) { 

        ArrayList<String> citiesList = new ArrayList<>(); 
        citiesList.add("San Francisco"); 
        citiesList.add("Paris"); 
        citiesList.add("Lima"); 
        citiesList.add("Saigon");
        citiesList.add("Bangkok");
        citiesList.add("Tokyo");
        citiesList.add("Cairo");

        StringListPrinter printer = new StringListPrinter(citiesList);
        printer.print();

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(10);
        integerList.add(70);
        IntegerListPrinter printer2 = new IntegerListPrinter(integerList);
        printer2.print();
    }
} 
/*
Answer 4 Note: had to comment out 1,2 and 3 because if I didnt then 4 and 1,2,3 would conflict due to the same class names being set.
*/
interface Printable {
    abstract void print();
}

abstract class ListPrinter<T> implements Printable {
    protected ArrayList<T> list;
    public ListPrinter(ArrayList<T> list) {
        this.list = list;
    }
     @Override
    public abstract void print();
}

class StringListPrinter extends ListPrinter<String> {
    public StringListPrinter(ArrayList<String> list) {
        super(list);
    }
    @Override
    public void print() {
        for(String s : list) System.out.println(s);
    } 
}

class IntegerListPrinter extends ListPrinter<Integer> {
    public IntegerListPrinter(ArrayList<Integer> list) {
        super(list);
    }
    @Override
    public void print() { 
        for(Integer i: list) System.out.println(i);
    } 
}

/* 
public class MainClass {
    public static void main(String[] args) {
        ArrayList<String> citiesList = new ArrayList<>();
        citiesList.add("San Francisco");
        citiesList.add("Paris");
        citiesList.add("Lima");
        citiesList.add("Saigon");
        citiesList.add("Bangkok");
        citiesList.add("Tokyo");
        citiesList.add("Cairo");
    }
}
1st answer:
abstract class ListPrinter<T> { 
    protected ArrayList<T> list;  
    public ListPrinter(ArrayList<T> list) { 
        this.list = list;
    } 
    public abstract void print();
}

2nd answer:
class StringListPrinter extends ListPrinter<String> { 
    public StringListPrinter(ArrayList<String> list) {  
        this.list = list;
    }
    @Override 
    public void print() {  
        for(String s: this.list){
            System.out.println(s);
        }
    }
}
3rd answer
class IntegerListPrinter extends ListPrinter<Integer> { 
    public IntegerListPrinter(ArrayList<Integer> list) { 
        this.list = list;
    }
    @Override 
    public void print() { 
        for(Integer i: this.list){
            System.out.println(i);
        }
    }
}
*/