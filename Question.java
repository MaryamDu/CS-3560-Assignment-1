import java.util.*;
import java.util.Random;

public class Question extends Student {

    private int correct_ans = 0;
    private int wrong_ans = 0;

    public Question() {
        super();
    }

    public void MultipleChoice(String answer) {
        // choose a number between 1-4
        Random rand = new Random();
        int random = (rand.nextInt(4 - 1 + 1) + 1);
        if (random == 0) {
            wrong_ans += answer.length();
        } else if (random == 1) {
            correct_ans++;
            if (answer.length() > 1) {
                wrong_ans += answer.length() - 1;
            }
        } else if (random == 2) {
            correct_ans += 2;
            if (answer.length() > 2) {
                wrong_ans += answer.length() - 2;
            }
        } else if (random == 3) {
            correct_ans += 3;
            if (answer.length() > 3) {
                wrong_ans++;
            }
        } else if (random == 4) {
            correct_ans += 4;
        }
    }

    public void SingleChoice(String answer) {
        Random rand = new Random();
        int random = rand.nextInt(2);
        // 50/50 chance of it being correct or wrong
        if (random == 0) {
            wrong_ans++;
        } else {
            correct_ans++;
        }

    }

    public int getCorrect() {
        return correct_ans;
    }

    public int getWrong() {
        return wrong_ans;
    }
}
