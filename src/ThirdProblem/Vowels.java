package ThirdProblem;

import java.util.Arrays;
import java.util.Scanner;

public class Vowels {

    public void workWithTheUserString () {
        Scanner strInput = new Scanner(System.in);
        System.out.print("User string input: ");
        String userInput = strInput.nextLine();

        userInput = userInput.trim();
        userInput = userInput.toLowerCase();
        String userWords[] = userInput.split(" ");

        //    "индексы каждой буквы по словам:"
        String vowel = "аеёиоуыэюя";

        for (int i = 0; i < userWords.length; i++) {
            for (int j = 0; j < userWords[i].length(); j++) {
                int index = vowel.indexOf(userWords[i].charAt(j));
            }
        }

        int[] count = new int[userWords.length];

        for (int i = 0; i < userWords.length; i++) {
            for (int j = 0; j < userWords[i].length(); j++) {
                int index = vowel.indexOf(userWords[i].charAt(j));
                if (index >= 0) {
                    count[i] = count[i] + 1;
                }
            }
        }

        System.out.println("Number of vowels:");
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();

        //Сортировка выбором (Selection sort)
        for (int i = 0; i < count.length - 1; i++) {
            for (int j = i + 1; j < count.length; j++) {
                if (count[i] < count[j]) {

                    int bufer = count[i];
                    count[i] = count[j];
                    count[j] = bufer;

                    String strBufer = userWords[i]; //сортируем слова по тем же критериям что и числа в массиве count
                    userWords[i] = userWords[j];
                    userWords[j] = strBufer;
                }
            }
        }

        System.out.println();
        System.out.println("Sorted words:");
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(userWords));

        System.out.println();
        System.out.println("First vowel upper case: ");

        int index;
        int[] indexOfFirstVowelsInAWord = new int[userWords.length];
        for (int i = 0; i < userWords.length; i++) {
            for (int j = 0; j < userWords[i].length(); j++) {
                if ("АаЕеЁёИиОоУуЫыЭэЮюЯя".indexOf(userWords[i].charAt(j)) > -1) {
                    index = j;
                    indexOfFirstVowelsInAWord[i] = index;
                    break;
                }
            }
        }

        int[] indexOfFirstVowel = indexOfFirstVowelsInAWord;
        for (int i = 0; i < userWords.length; i++) {
            System.out.print(userWords[i].substring(0, indexOfFirstVowel[i]) +
                    userWords[i].substring(indexOfFirstVowel[i], indexOfFirstVowel[i] + 1).toUpperCase() +
                    userWords[i].substring(indexOfFirstVowel[i] + 1, userWords[i].length()) + " ");
        }
    }
    public static void main(String[] args) {

        Vowels litterCounter = new Vowels();
        litterCounter.workWithTheUserString();

    }
}