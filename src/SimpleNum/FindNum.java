package SimpleNum;

import java.util.Scanner;

public class FindNum {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 2;

        while (i <= Math.sqrt(n)) {
            if(n % i ==0){
                System.out.print(i);
                n = n / i;
                if(n>1) System.out.print(' ');
            } else i++;

        }
        if(n>1) {
            System.out.print(n);
        }

    }
}