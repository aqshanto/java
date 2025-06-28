import java.util.ArrayList;

class Teacher{
    private String teacherName;
    private int teacherID;
    private ArrayList<Courses>assignedCourses;
    Teacher(String teacherName,int teacherID){
        this.teacherName=teacherName;
        this.teacherID=teacherID;
        assignedCourses = new ArrayList<>();
    }
    public String getTeacherName() {
        return teacherName;
    }
    public int getTeacherID() {
        return teacherID;
    }
    public void addCourses(Courses c){
        assignedCourses.add(c);
    }
    public void display(){
        System.out.println("\t- Teacher Name: " + getTeacherName() + " || Teacher ID: "+ getTeacherID());
    }
    public void displayall(){
        System.out.println("- Teacher Name: " + getTeacherName() + " || Teacher ID: "+ getTeacherID());
        for(Courses courses:assignedCourses){
            courses.display();
        }
    }
}

class Courses{
    private String courseCode,courseCredit;
    private final Teacher instructor;
    private ArrayList<Student>enrolledStudent;
    Courses(String courseCode, String couseCredit,Teacher instructor){
        this.courseCode=courseCode;
        this.courseCredit=couseCredit;
        this.instructor=instructor;
        enrolledStudent=new ArrayList<>();
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseCredit() {
        return courseCredit;
    }
    public Teacher getInstructor() {
        return instructor;
    }
    public void enrollStudent(Student s){
        enrolledStudent.add(s);
    }
    public void display(){
        System.out.println("\t- Course Code: " + getCourseCode() + " || Course Credit: "+ getCourseCode()+" || course instructor: "+ getInstructor().getTeacherName());
    }
    public void displayall(){
        System.out.println("- courses code: "+ getCourseCode()+" || course credit: "+ getCourseCredit() +" || course instructor: "+ getInstructor().getTeacherName());
        for(Student stu:enrolledStudent){
            stu.display();
        }
    }
}

class Student{
    private String studentName;
    private int studentID;
    private ArrayList<Courses>enrolledCourses;
    Student(String studentName,int studentID){
        this.studentName=studentName;
        this.studentID=studentID;
        enrolledCourses=new ArrayList<>();
    }
    public String getStudentName() {
        return studentName;
    }
    public int getStudentID() {
        return studentID;
    }
    public void enrollCourses(Courses ec){
        enrolledCourses.add(ec);
    }public void display(){
        System.out.println("Student Name: " + getStudentName() + " || Student ID: "+ getStudentID());
    }
    public void displayall(){
        System.out.println("Student Name: " + getStudentName() + " || Student ID: "+ getStudentID());
        for(Courses c:enrolledCourses){
            c.display();
        }
    }
}

class Department{
    private String deptName;
    private ArrayList<Courses>tcourses;


    private ArrayList<Student>tstudents;
    private ArrayList<Teacher>tteachers;
    Department(String deptName){
        this.deptName=deptName;
        tcourses = new ArrayList<>();
        tstudents = new ArrayList<>();
        tteachers = new ArrayList<>();
    }
    public String getDeptName() {
        return deptName;
    }
    public void addCourses(Courses c){
        tcourses.add(c);
    }
    public void addTeacher(Teacher t){
        tteachers.add(t);
    }
    public ArrayList<Courses> getTcourses() {
        return tcourses;
    }
    public ArrayList<Student> getTstudents() {
        return tstudents;
    }
    public ArrayList<Teacher> getTteachers() {
        return tteachers;
    }    public void addStudent(Student s){
        tstudents.add(s);
    }
}

class University{
    private String uniName;
    private ArrayList<Department> tdepartments;
    University(String uniName){
        this.uniName= uniName;
        tdepartments =new ArrayList<>();
    }
    public void addDepartment(Department d){
        tdepartments.add(d);
    }
    public void displayAllDetails(){
        System.out.println(this.uniName);
        System.out.println("=========================================");
        for (Department dept : tdepartments) {
            System.out.println("Department: " + dept.getDeptName());
            System.out.println("All Teachers Information: ");
            for(Teacher t: dept.getTteachers()){
                t.display();
            }
            System.out.println();
            System.out.println("All Courses Information: ");
            for(Courses c: dept.getTcourses()){
                c.display();
            }
            System.out.println();
            System.out.println("All Students Information: ");
            for(Student s: dept.getTstudents()){
                s.display();
            }

            System.out.println();
            System.out.println("Assinged Courses Information for teachers: ");
            for(Teacher t: dept.getTteachers()){
                t.displayall();
            }
            System.out.println();
            System.out.println("Assinged Courses Information for Students: ");
            for(Student s: dept.getTstudents()){
                s.displayall();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        University u1 = new University("   Daffodils International University");
        Department d1 = new Department("CSE");
        Teacher t1 = new Teacher("Jarjis",001);
        Teacher t2 = new Teacher("Shamim",002);
        Courses c1 = new Courses("CSE101", "3.0", t1);
        Courses c2 = new Courses("CSE102","3.0",t2);
        Courses c3 = new Courses("MATH101","3.0",t2);
        Student s1= new Student("ABAL-1",200501);
        Student s2= new Student("ABAL-2",200502);
        Student s3= new Student("ABAL-3",200503);
        Student s4= new Student("ABAL-4",200504);
        Student s5= new Student("ABAL-5",200505);
        Student s6= new Student("ABAL-6",200506);

        u1.addDepartment(d1);
        d1.addCourses(c1);
        d1.addCourses(c2);
        d1.addCourses(c3);
        d1.addTeacher(t1);
        d1.addTeacher(t2);
        d1.addStudent(s1);
        d1.addStudent(s2);
        d1.addStudent(s3);
        d1.addStudent(s4);
        d1.addStudent(s5);
        d1.addStudent(s6);

        t1.addCourses(c1);
        t2.addCourses(c2);
        t2.addCourses(c3);

        c1.enrollStudent(s1);
        c2.enrollStudent(s1);
        c3.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s2);
        c3.enrollStudent(s2);
        c1.enrollStudent(s3);
        c2.enrollStudent(s3);
        c3.enrollStudent(s3);
        c1.enrollStudent(s4);
        c2.enrollStudent(s4);
        c3.enrollStudent(s4);
        c1.enrollStudent(s5);
        c2.enrollStudent(s5);
        c3.enrollStudent(s5);
        c1.enrollStudent(s6);
        c2.enrollStudent(s6);
        c3.enrollStudent(s6);
        s1.enrollCourses(c1);
        s1.enrollCourses(c2);
        s1.enrollCourses(c3);
        s2.enrollCourses(c1);
        s2.enrollCourses(c2);
        s2.enrollCourses(c3);
        s3.enrollCourses(c1);
        s3.enrollCourses(c2);
        s3.enrollCourses(c3);
        s4.enrollCourses(c1);
        s4.enrollCourses(c2);
        s4.enrollCourses(c3);
        s5.enrollCourses(c1);
        s5.enrollCourses(c2);
        s5.enrollCourses(c3);
        s6.enrollCourses(c1);
        s6.enrollCourses(c2);
        s6.enrollCourses(c3);

        u1.displayAllDetails();
    }
}