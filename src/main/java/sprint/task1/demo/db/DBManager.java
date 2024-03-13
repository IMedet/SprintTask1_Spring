package sprint.task1.demo.db;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> students = new ArrayList<>();
    private static Long id=4L;
    static {
        students.add(new Student(1L,"Medet","Idrish",95,"A"));
        students.add(new Student(2L,"Zhansaya","Kulbaeva",99,"A"));
        students.add(new Student(3L,"Arman","Bakyt",80,"B"));
    }

    public static ArrayList<Student> getAllStudents(){
        return students;
    }

    public static void addStudent(Student student){
        student.setId(id);
        if(student.getExam()>=90){
            student.setMark("A");
        } else if (student.getExam()>=75 && student.getExam()<=89) {
            student.setMark("B");
        } else if (student.getExam()>=60 && student.getExam()<=74) {
            student.setMark("C");
        } else if (student.getExam()>=50 && student.getExam()<=59) {
            student.setMark("D");
        }else{
            student.setMark("F");
        }

        students.add(student);
        id++;
    }

    public static Student getStudent(Long id){
        Student student = new Student();
        for(Student student1 : students){
            if(student1.getId().equals(id)){
                student=student1;
            }
        }

        return student;
    }
}
