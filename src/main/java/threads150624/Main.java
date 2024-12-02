package threads150624;

public class Main {
    public static void main(String[] args){
        Thread thread1 = new Thread(new Train());
        Thread thread2 = new Thread(new Train());

        thread1.start();

        try{
            thread1.join();
        } catch (InterruptedException e){
            System.out.println("InterruptedException 1");
        }

        thread2.start();
        try{
            thread2.join();
        } catch (InterruptedException e){
            System.out.println("InterruptedException 2");
        }

        System.out.println("Usual stream");

    }
}
