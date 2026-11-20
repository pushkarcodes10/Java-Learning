class Person {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    int rollNo;
    float marks;

    void display() {
        super.display();

        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }
}

class Teacher extends Person {
    float salary;
    String subject;

    void display() {
        super.display();

        System.out.println("Salary: " + salary);
        System.out.println("Subject: " + subject);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.name = "Pushkar";
        s1.age = 20;
        s1.rollNo = 36;
        s1.marks = 8.5f;

        s1.display();

        System.out.println("----------------");

        Teacher t1 = new Teacher();
        t1.name = "Ramesh";
        t1.age = 50;
        t1.salary = 250000f;
        t1.subject = "Java";

        t1.display();
    }
}

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override 
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override 
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();

        d.sound();
        c.sound();
    }
}