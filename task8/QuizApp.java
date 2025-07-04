package task8;

import java.util.*;

public class QuizApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            List<Question> questions = loadQuestions();
            int score = 0;

            System.out.println("==== Welcome to the Online Quiz App ====\n");

            int questionNumber = 1;
            for (Question q : questions) {
                System.out.println("Question " + questionNumber + ":");
                q.displayQuestion();

                char userAnswer = getValidAnswer(sc);

                if (q.isCorrect(userAnswer)) {
                    System.out.println("✅ Correct!\n");
                    score++;
                } else {
                    System.out.println("❌ Wrong! Correct answer: " + q.correctAnswer + "\n");
                }
                questionNumber++;
            }

            System.out.println("==== Quiz Completed! ====");
            System.out.println("Your Final Score: " + score + "/" + questions.size());

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();
            playAgain = choice.equals("yes");

        } while (playAgain);

        System.out.println("\nThank you for playing the Quiz App!");
        sc.close();
    }

    // Method to load questions
    public static List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?", new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 'B'));
        questions.add(new Question("Who developed Java?", new String[]{"James Gosling", "Dennis Ritchie", "Guido van Rossum", "Bjarne Stroustrup"}, 'A'));
        questions.add(new Question("Which company owns Android?", new String[]{"Apple", "Microsoft", "Google", "IBM"}, 'C'));
        questions.add(new Question("What is the full form of OOP?", new String[]{"Object Oriented Programming", "Open Operational Protocol", "Object Optimized Programming", "None"}, 'A'));
        return questions;
    }

    // Method to get validated user input
    public static char getValidAnswer(Scanner sc) {
        char answer;
        while (true) {
            System.out.print("Your answer (A/B/C/D): ");
            String input = sc.next().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'D') {
                answer = input.charAt(0);
                break;
            } else {
                System.out.println("⚠️ Invalid input. Please enter A, B, C, or D.");
            }
        }
        return answer;
    }
}
