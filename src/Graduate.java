public class Graduate extends Student {
    public String subject;
    public String advisor;

    public Graduate() {
    }

    public Graduate(int studentID, String Name, String Surname, String subject, String advisor) {
        super(studentID, Name, Surname);
        this.subject = subject;
        this.advisor=advisor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    @Override
    public String toString() {
        return "studentID=" +studentID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", subject='" + subject + '\'' +
                ", advisor='" + advisor + '\'' ;
    }
}
