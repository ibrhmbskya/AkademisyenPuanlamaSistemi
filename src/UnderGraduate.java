public class UnderGraduate extends Student {
    public String track;

    public UnderGraduate() {
    }

    public UnderGraduate(int studentID, String Name, String Surname, String track) {
        super(studentID, Name, Surname);
        this.track = track;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "studentID=" +studentID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", track='" + track + '\'';
    }
}