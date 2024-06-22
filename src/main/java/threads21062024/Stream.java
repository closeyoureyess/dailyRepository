package threads21062024;

public class Stream implements Runnable{
    @Override
    public void run() {
        Student.modifyStudent();
        System.out.println("End of the thread: " + Thread.currentThread().getName());
    }
}
