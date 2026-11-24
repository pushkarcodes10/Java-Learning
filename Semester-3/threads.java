class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class threads {
    public static void main(String[] args) {
        // Thread t = Thread.currentThread();

        // System.out.println("Current thread: " + t.getName());
        // System.out.println("Thread Priority: " + t.getPriority());
        MyThread t = new MyThread();
        t.start();
    }
}

// runnable

class MyTask implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running");
    }
}

public class threads {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task);
        t.start();
    }
}