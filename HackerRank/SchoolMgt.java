package HackerRank;

import java.util.*;

public class SchoolMgt {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
class Student{
    int id;
    String name;
    double cgpa;
    Student(String name, double cgpa, int id){
        this.id =  id;
        this.name = name;
        this.cgpa = cgpa;
    }
    int getId(){
        return id;
    }
    String  getName(){
        return name;
    }
    double getCgpa(){
        return cgpa;
    }
}

class Priorities{
    List<Student> queue = new ArrayList<>();
    List<Student> getStudents(List<String> events){

       for(int i=0; i< events.size(); i++){
           String[] str = events.get(i).split(" ");
           if(str[0].equals("ENTER"))
               queue.add(new Student(str[1], Double.valueOf(str[2]), Integer.valueOf(str[3])));
           else if(str[0].equals("SERVED"))
               if(queue.size()==0)
                   continue;
               else
                   queue.remove(0);
           Collections.sort(queue, new StudentComparator());
       }
       return queue;
    }
}
class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student a, Student b) {
        if(a.getCgpa()-(b.getCgpa()) < 0)
            return 1;
        else if(a.getCgpa()-b.getCgpa() >0)
            return -1;
        else if(a.getCgpa()-b.getCgpa() ==0) {
            if (a.getName().compareTo(b.getName()) < 0)
                return -1;
            else if (a.getName().compareTo(b.getName()) > 0)
                return 1;
            else
                return b.id - a.id;
        }
        return 0;
    }
}
