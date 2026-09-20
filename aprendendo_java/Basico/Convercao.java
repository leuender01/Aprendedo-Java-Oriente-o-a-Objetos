import java.util.Scanner;

public class Convercao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double dd = 10.80;
        short ss = 2;
        float x =  (float) dd / ss;
        System.out.println(x);

        float resposta = (float) sc.nextDouble();
        System.out.println(resposta);
        sc.close();
    }
}
