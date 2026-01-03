import models.*;
import java.util.*;
import java.io.*;

public class MyApplication {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        try {
            readEmployees(people, "src/Employee source");
            readStudents(people, "src/Person source");
        } catch (FileNotFoundException e) {
            System.out.println("Source files not found! Make sure they are in the src folder.");
        }

        Collections.sort(people);
        printData(people);
    }

    public static void readEmployees(ArrayList<Person> list, String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()) {
            String name = sc.next();
            String surname = sc.next();
            String pos = sc.next();
            double salary = sc.nextDouble();
            list.add(new Employee(name, surname, pos, salary));
        }
        sc.close();
    }

    public static void readStudents(ArrayList<Person> list, String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()) {
            String name = sc.next();
            String surname = sc.next();
            double gpa = sc.nextDouble();
            list.add(new Student(name, surname, gpa));
        }
        sc.close();
    }

    public static void printData(Iterable<Person> people) {
        for (Person p : people) {
            System.out.printf("%s earns %.2f tenge%n", p.toString(), p.getPaymentAmount());
        }
    }
}