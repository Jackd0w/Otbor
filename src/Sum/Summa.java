package Sum;

import java.util.Scanner;

public class Summa {

    static int findSum(String str) {
        String temp = "";

        int sum = 0;

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                temp += ch;
            } else {
                sum += 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            System.out.println(findSum(str));
    }
}
