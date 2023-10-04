import java.util.*;

public class SimulationDriver {

    public static String randomAnswer() {
        String answer = "";
        String answers_p = "ABCD";
        // Choose a random between 1-4 i.e. 1-4 possible answers
        Random rand = new Random();
        int random = (rand.nextInt(4 - 1 + 1) + 1);
        // for 2 and 3 answers, pick different answers
        int randomSec = rand.nextInt(4);
        int randomThird = rand.nextInt(4);
        // Choose a random question, 0 for multiple choice, 1 for single choice
        int questionNum = rand.nextInt(2);

        // If Multiple choice
        if (questionNum == 0) {
            if (random == 1) {
                random = rand.nextInt(4);
                answer += answers_p.charAt(random);
            } else if (random == 2) {
                random = rand.nextInt(4);
                answer += answers_p.charAt(random);
                // Keep rerolling until getting a new number
                while (randomSec == random) {
                    randomSec = rand.nextInt(4);
                }
                answer += answers_p.charAt(randomSec);
            } else if (random == 3) {
                random = rand.nextInt(4);
                answer += answers_p.charAt(random);
                // Keep rerolling until getting a new number
                while (randomSec == random) {
                    randomSec = rand.nextInt(4);
                }
                while (randomThird == random || randomThird == randomSec) {
                    randomThird = rand.nextInt(4);
                }
                answer += answers_p.charAt(randomSec);
                answer += answers_p.charAt(randomThird);
            } else if (random == 4) {
                answer = answers_p;
            }

            // Else, then single choice
        } else {
            random = rand.nextInt(4);
            answer += answers_p.charAt(random);
        }

        return answer;
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int rand_NumStud = rand.nextInt(100);
        Student[] students = new Student[rand_NumStud];
        VotingService poll = new VotingService();
        String answer = "";
        int randomID = 0;
        int questionNum = rand.nextInt(2);
        List<Integer> IDs = new ArrayList<>();

        // For however many students there are, make a student object and give them a
        // random ID and answer, if there's only one answer then randomly choose
        // between it being multiple choice and single choice
        // IDs arraylist keeps track of IDs to know when one is submitting a new answer
        for (int i = rand_NumStud - 1; i > 0; i--) {
            randomID = rand.nextInt(100);
            answer = randomAnswer();
            questionNum = rand.nextInt(2);
            if (!IDs.contains(randomID)) {
                IDs.add(randomID);
                students[i] = new Student(Integer.toString(randomID), answer);
            } else {
                for (int j = rand_NumStud - 1; j > 0; j--) {
                    if (students[i] != null) {
                        if (students[i].getID().equals(Integer.toString(randomID))) {
                            poll.setAnswer(answer);
                        }
                    }
                }
            }

            students[i] = new Student(Integer.toString(randomID), answer);
            // if the answer
            if (answer.length() == 1) {
                if (questionNum == 0) {
                    poll.MultipleChoice(answer);
                } else {
                    poll.SingleChoice(answer);
                }
            } else if (answer.length() > 1) {
                poll.MultipleChoice(answer);
            }
        }

        System.out.println("A: " + poll.getA());
        System.out.println("B: " + poll.getB());
        System.out.println("C: " + poll.getC());
        System.out.println("D: " + poll.getD());
        System.out.println("Number of Students: " + rand_NumStud);
        System.out.println("Sum of Answers: " + poll.getSum());

    }

}
