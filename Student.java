public class Student {

    private String ID;
    private String answer;

    public Student() {
    }

    public Student(String number, String answ) {
        this.ID = number;
        this.answer = answ;
    }

    public String getID() {
        return ID;
    }

    public void setID(String number) {
        this.ID = number;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answNew) {
        this.answer = answNew;
    }
}
