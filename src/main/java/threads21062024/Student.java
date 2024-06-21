package threads21062024;

import java.util.ArrayList;
import java.util.List;

public class Student implements Runnable {

    private int id;

    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            List<Student> roster = new ArrayList<>();
            for (int i = getId() + 0; i <= 100; i++) {
                if (!roster.contains(new Student(i))) {
                    setId(i);
                    roster.add(i, new Student(getId()));
                } else if (getId() == 100) {
                    break;
                }
                System.out.println("This student have ID: " + roster.get(i));
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
