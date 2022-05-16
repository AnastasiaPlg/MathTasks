import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathTasks {
    public static void main(String[] args) {

        int number1, number2, answerSum, answerMlp;

        String answerSymbol;
        String mlpSymbol;
        String numSymbol;
        String[] easyTasks = new String[6];
        String[] hardTasks = new String[6];
        List<String> mathTasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            number1 = (int) (10 * Math.random() + 1);
            number2 = (int) (10 * Math.random() + 1);
            answerSum = number1 + number2;
            answerMlp = number1 * number2;
            if (answerSum > 9) {
                answerSymbol = "??";
            } else answerSymbol = "?";
            if (answerMlp == 100) {
                mlpSymbol = "???";
            } else if (answerMlp > 9 && answerMlp < 100) {
                mlpSymbol = "??";
            } else mlpSymbol = "?";
            while (true) {
                int randAnswerSum = (int) (21 * Math.random());
                if ((randAnswerSum - number1) > 9) {
                    numSymbol = "??";
                } else numSymbol = "?";
                if (randAnswerSum >= number1 && randAnswerSum - number1 <= 10) {
                    easyTasks[0] = numSymbol + " + " + number1 + " = " + randAnswerSum;
                    easyTasks[1] = number1 + " + " + numSymbol + " = " + randAnswerSum;
                    easyTasks[2] = number1 + " + " + number2 + " = " + answerSymbol;
                    easyTasks[3] = randAnswerSum + " - " + numSymbol + " = " + number1;
                    easyTasks[4] = randAnswerSum + " - " + number1 + " = " + numSymbol;
                    easyTasks[5] = answerSymbol + " - " + number1 + " = " + number2;
                    break;
                }
            }
            while (true) {
                int randAnswerMlp = (int) (101 * Math.random());
                if ((randAnswerMlp / number1) > 9) {
                    numSymbol = "??";
                } else numSymbol = "?";
                if (randAnswerMlp >= number1 && randAnswerMlp % number1 == 0 && randAnswerMlp / number1 <= 10) {
                    hardTasks[0] = numSymbol + " * " + number1 + " = " + randAnswerMlp;
                    hardTasks[1] = number1 + " * " + numSymbol + " = " + randAnswerMlp;
                    hardTasks[2] = number1 + " * " + number2 + " = " + mlpSymbol;
                    hardTasks[3] = randAnswerMlp + " : " + numSymbol + " = " + number1;
                    hardTasks[4] = randAnswerMlp + " : " + number1 + " = " + numSymbol;
                    hardTasks[5] = mlpSymbol + " : " + number1 + " = " + number2;
                    break;
                }
            }
            if (i % 2 == 0) {
                mathTasks.add(easyTasks[(int) (6 * Math.random())] + "\n");
            } else mathTasks.add(hardTasks[(int) (6 * Math.random())] + "\n");

            try (Scanner scanner = new Scanner(System.in);
                 BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("MathTasks.doc"))) {

                for (String mathTask : mathTasks) {
                    bufferedWriter.write(mathTask);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
