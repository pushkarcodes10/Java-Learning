// Encapsulation

class Student {
    private int marks;

    public void setMarks(int m) {
        marks = m;
    }

    public int getMarks() {
        return marks;
    }
}

class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setMarks(90);

        System.out.println(s.getMarks());
    }
}


// Abstraction

abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car Starts with a key");
    }
}

class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
    }
}

// Inheritance


class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog Barks");
    }
}

class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}

// Polymorphism
