public class Student {
    String name;
    String department;
    double grade;

    public Student(String name, String department, double grade) {
        this.name = name;
        this.department = department;
        this.grade = grade;

    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name ;
    }
}
