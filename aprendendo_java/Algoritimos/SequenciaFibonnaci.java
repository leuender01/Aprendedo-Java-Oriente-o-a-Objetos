import java.util.Scanner;

public class SequenciaFibonnaci{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f1 = 0;
        int f2 = 1;
        int limit = sc.nextInt();
        while (f2 < limit) {
            int fn = f1 + f2;
            if(fn > limit) break;
            System.out.println(fn);
            f1 = f2;
            f2 = fn;
        }
        sc.close();
    }
}

