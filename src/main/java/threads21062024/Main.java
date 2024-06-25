package threads21062024;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static int count;

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        List<Student> roster = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            student.setId(i);
            roster.add(new Student(student.getId()));
        }

        // Вывод от 0 до 99
        for (int i = 0; i < 100; i++) {
            System.out.println(roster.get(i).getId());
        }

        //Прибавление тремя потоками +1 к каждому числу коллекции
        Thread threadOne = new Thread(new Stream() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 33; i++) {
                    if (i <= (roster.size() - 1) / 3) {
                        System.out.println(roster.get(count).getId() + 1);
                        count++;
                    }
                }
            }
        });
        Thread threadTwo = new Thread(new Stream() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 33; i++) {
                    if (i <= (roster.size() - 1) / 3) {
                        System.out.println(roster.get(count).getId() + 1);
                        count++;
                    }
                }
            }
        });
        Thread threadThree = new Thread(new Stream() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i <= 33; i++) {
                    if (i <= (roster.size() - 1) / 3) {
                        System.out.println(roster.get(count).getId() + 1);
                        count++;
                    }
                }
            }
        });

        threadOne.start();
        threadOne.join();
        threadTwo.start();
        threadTwo.join();
        threadThree.start();
        threadThree.join();

    }
}
