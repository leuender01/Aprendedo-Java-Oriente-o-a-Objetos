import java.util.Scanner;

import classes.Banck;
import classes.Menu;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banck santander = new Banck("0001");
        Menu menu = new Menu();
        boolean rodando = true;
        while (rodando) {
            String nameAcout;
            boolean resultado = false;
            System.out.print("\033[H\033[2J");
            System.out.println("Valor total Banco: " + santander.getValueBanck());
            menu.getOptionsBanck();
            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome da conta");
                    nameAcout = sc.nextLine();
                    resultado = santander.generateAcount(nameAcout);
                    System.out.println(resultado ?  "Conta Criada com Sucesso!" : "Erro ao criar Conta");
                    menu.aguardar(2000);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Digite o nome da conta");
                    nameAcout = sc.nextLine();
                    santander.sessionAccount(nameAcout);
                    break;
                case 3:
                    santander.getAccounts();;
                    menu.aguardar(2000);
                    break;
                case 4:
                    santander.getAccounts();;
                    menu.aguardar(2000);
                    break;
                case 5:
                    rodando = false;
                    break;
                default:
                    System.out.println("Digite uma opção valida!");
                    menu.aguardar(1000);
                    break;
            }
        }
        sc.close();
    }
}

