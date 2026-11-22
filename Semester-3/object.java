class Student {
    String name;
    int age;

    void study() {
        System.out.println(name + " is studying");
    }
}

class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        String name = s1.name = "Pratik";
        int age = s1.age = 20;

        System.out.println(name);
        System.out.println(age);

        s1.study();
    }
}

// Cnstructor

class Student {

    Student() {
        System.out.println("Student object created");
    }
}

class Main {

    public static void main(String[] args) {

        Student s = new Student();

    }
}

// Parameterized Constructor

class Student {
    
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println(name);
        System.out.println(age);
    }
}

class Main {
    public static void main(String[] args) {
        Student s = new Student("Pushkar", 20);

        s.display();
    }
}

// toString()    

class Student {
    
int rollNo = 101;
String name = "Rahul";

public String toString() {
    
return rollNo + " " + name;
}
}

public class object {
    
public static void main(String[] args) {
    
Student s = new Student();

System.out.println(s.toString());
}
}