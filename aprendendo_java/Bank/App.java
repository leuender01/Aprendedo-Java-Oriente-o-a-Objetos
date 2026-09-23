import java.util.Scanner;

import classes.Account;
import classes.Menu;

public class App{
    public static void main(String[] args) {
        Menu menu = new Menu();
        Account account = new Account("0129233", 1, "Seu Madruga");
        Scanner sc = new Scanner(System.in);
        boolean opiton = true;
        while (opiton) {
            System.out.print("\033[H\033[2J");
            menu.getOptions();
            double value = 0;
            switch( sc.nextInt()) {
                case 1:
                    System.out.println("Digite o valor que deseja sacar");
                    value = sc.nextDouble(); 
                    boolean sucess =  account.withDrawn(Double.valueOf(value));
                    String resultado = (sucess) ? "Sucesso!" : "Negado!";
                    System.out.println(resultado);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar");
                    value = sc.nextDouble(); 
                    account.deposit(Double.valueOf(value));
                    break;
                case 3:
                    System.out.println(account.getStatmentAccount());
                    break;
                case 4:
                    System.out.println(account);
                    break;
                case 5:
                    opiton = false;
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Digite um opção valida!");
                    break;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
        }
        sc.close();
    }
}

