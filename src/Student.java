public class Student {
    public int studentID;
    public String Name;
    public String Surname;

    public Student(){

    }
    public Student(int studentID, String Name, String Surname){
        this.studentID=studentID;
        this.Name=Name;
        this.Surname=Surname;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }


}
