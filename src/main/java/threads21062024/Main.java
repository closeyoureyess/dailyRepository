package threads21062024;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Student());
        Thread threadTwo = new Thread(new Student());
        Thread threadThree = new Thread(new Student());

        Student student = new Student();
        student.createStudent(100);
        threadOne.start();
        threadOne.join();
        threadTwo.start();
        threadTwo.join();
        threadThree.start();
        threadThree.join();
    }
}
