package threads21062024;

public class Main {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Student());
        Thread threadTwo = new Thread(new Student());
        Thread threadThree = new Thread(new Student());

        try {
            threadOne.start();
            threadOne.join();
            //
            threadTwo.start();
            threadTwo.join();
            //
            threadThree.start();
            threadThree.join();
        } catch (InterruptedException e) {
            System.out.println("Error " + e);
        }
    }
}
