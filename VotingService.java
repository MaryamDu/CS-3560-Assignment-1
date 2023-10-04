import java.util.*;

public class VotingService extends Question {

    private int countA = 0;
    private int countB = 0;
    private int countC = 0;
    private int countD = 0;
    private int sum = 0;

    public void MultipleChoice(String answer) {
        super.MultipleChoice(answer);
        if (answer.contains("A")) {
            countA++;
            sum++;
        }
        if (answer.contains("B")) {
            countB++;
            sum++;
        }
        if (answer.contains("C")) {
            countC++;
            sum++;
        }
        if (answer.contains("D")) {
            countD++;
            sum++;
        }
    }

    public void SingleChoice(String answer) {
        super.SingleChoice(answer);
        if (answer.equals("A")) {
            countA++;
        } else if (answer.equals("B")) {
            countB++;
        } else if (answer.equals("C")) {
            countC++;
        } else if (answer.equals("D")) {
            countD++;
        }
        sum++;
    }

    public int getSum() {
        return sum;
    }

    public int getA() {
        return countA;
    }

    public int getB() {
        return countB;
    }

    public int getC() {
        return countC;
    }

    public int getD() {
        return countD;
    }

    public void setAnswer(String answNew) {
        String answerCheck = super.getAnswer();
        if (answerCheck.contains('A')) {
            countA--;
        }
        if (answerCheck.contains('B')) {
            countB--;
        }
        if (answerCheck.contains('C')) {
            countC--;
        }
        if (answerCheck.contains('D')) {
            countD--;
        }
        super.setAnswer(answNew);
    }

}
