/*abstract class Vehicle {
    abstract void start();
     void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with a key");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with a button");
    }
}

public class Student {
    public static void main(String[] args) {
        Car c = new Car();
        Bike b = new Bike();

        c.start();
        c.stop();

        b.start();
        b.stop();
    }
}*/

public class Student {

    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        System.out.println("Total memory: " + r.totalMemory());

        System.out.println("Free memory: " + r.freeMemory());

        System.out.println("Maximum memory: " + r.maxMemory());
    }
}