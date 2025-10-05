import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;



class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }
    
    public String printPerson(){
        return this.firstName + this.lastName + this.birthYear;
    }
    public static void printAll(List<Person> p){
        System.out.println("These are all the people in Person: ");
        int j = 1;
        for(Person i: p){
            System.out.println(j++ +" " + i.printPerson());
        }
    }
}



public class PersonMain
{
	public static void main(String[] args) {
	    //how many persons beginning with the letter a as a first name?
	    List<Person> personList = new ArrayList<>();
	    
	    Person p1 = new Person("Aron", "Paul", 1945);
	    personList.add(p1);
	    Person p2 = new Person("Misty", "Paul", 1989);
	    personList.add(p2);
	    Person p3 = new Person("Randy", "Ort", 1975);
	    personList.add(p3);
	    Person p4 = new Person("Randy", "Aust", 1980);
	    personList.add(p4);
	    Person p5 = new Person("Aron", "Square", 1940);
	    personList.add(p5);
	    Person p6 = new Person("Adam", "Heyes", 1950);
	    personList.add(p6);
	    Person p7 = new Person("Garfield", "Skye", 1950);
	    personList.add(p7);
	    Person p8 = new Person("Arnold", "Shwarz", 1960);
	    personList.add(p8);
	    Person p9 = new Person("Arnold", "Arnoldstrong", 1970);
	    personList.add(p9);
	    Person.printAll(personList);
	    
	    //print persons born before 1970 use streams
        List<Person> before1970 = new ArrayList<>();
        //SMASHED IT
        before1970 = personList.stream()
        .filter(p -> p.getBirthYear() < 1970)
        .collect(Collectors.toCollection(ArrayList::new));
        Person.printAll(before1970);

        List<Person> startsWithA = personList.stream()
        .filter(p -> p.getFirstName()
        .startsWith("A"))
        .collect(Collectors.toList());
        Person.printAll(startsWithA);
        startsWithA.stream().forEach(s -> System.out.println(s.getFirstName()));

        //You'll receive a list of persons. Print the number of unique first names in alphabetical order
        System.out.println("unique: ");
        personList.stream()
        .map(s -> s.getFirstName())
        .distinct()
        .sorted()
        .forEach(s -> System.out.println(s));

        
	}
}