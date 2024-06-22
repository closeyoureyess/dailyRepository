package threads21062024;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private static int count;
    private int id;
    private static List<Student> roster = new ArrayList<>();

    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    public void createStudent(int students) {
        for (int i = 0; i < students; i++) {
            setId(i);
            roster.add(new Student(getId()));
        }
        System.out.println(roster);
    }

    public static void modifyStudent() {
        synchronized (Student.class) {
            int i = 0;
            for (int k = count; k < roster.size(); k++) {
                if (i <= (roster.size() - 1) / 3) {
                    String a = String.valueOf(roster.get(k));
                    String b = a.substring(a.indexOf("=") + 1, a.length() - 1);
                    System.out.println(Integer.parseInt(b) + 1);
                    count = k + 1;
                    i++;
                } else {
                    break;
                }
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
        return "Student{" + "id=" + id + '}';
    }
}
