package threads21062024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student implements Runnable {

    private int id;

    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    private static List<Student> roster = new ArrayList<>();

    @Override
    public void run() {
        for (int k = 0; k < roster.size(); k++){
            String a = String.valueOf(roster.get(k));
            String b = a.substring(a.indexOf("=") + 1, a.length() - 1);
            System.out.println(Integer.parseInt(b) + 1);
        }
    }

    public void createStudent(int students){
        for( int i = 0; i < students; i++){
            roster.add(new Student(i));
        }
        System.out.println(roster);
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

/*if(roster.size() < 32){
                    setId(i);
                    roster.add(getId(), new Student(getId()));
                } else if (!roster.contains(new Student(i))) {
                    i = getId();
                    if (!roster.contains(new Student(i))){
                        setId(i);
                        roster.add(getId(), new Student(getId()));
                        System.out.println("Элемента нет" + i);
                    } else {
                        System.out.println("Элемент есть " + i);
                    }
                    //System.out.println("GI " + getId());
                } else if (getId() == 33) {
                    System.out.println("final");
                    break;
                }
                System.out.println("This student have ID: " + roster.get(i) + " Size " + roster.size());*/
