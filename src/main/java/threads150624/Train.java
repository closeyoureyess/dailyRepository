package threads150624;

public class Train implements Runnable{

    public void method(){
        synchronized (this){
            System.out.println("It");
            System.out.println("Method");
        }
    }

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
            method();
    }
}
