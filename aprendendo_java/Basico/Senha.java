import java.util.Scanner;

public class Senha {

    public static void main(String[] args) {
        final String pass  = "12345";
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        System.out.println(password == pass);
        System.out.println(password.equals(pass));
        sc.close();
    }
}
