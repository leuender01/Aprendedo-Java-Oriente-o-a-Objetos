package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banck{
    private String ag;
    private static int lastAccount = 1;
    private List<Account> accounts;
    private Log log = new Log();

    public Banck(String agencia){
        this.accounts = new ArrayList<Account>();
        this.ag = agencia;
    }

    private Account loginAccount(String name){
        for(var count : accounts){
            if(count.getName(name)){
                return count;
            }
        }
        return null;
    }
    public boolean sessionAccount(String name){
       var count = loginAccount(name);
       Scanner sc = new Scanner(System.in);
       if(count == null ) return false;
       Menu menu = new Menu();
       this.log.out("Login feito");
        boolean opiton = true;
        while (opiton) {
            System.out.print("\033[H\033[2J");
            System.out.println("Saldo atual: " + count.getValue());
            menu.getOptionsAccount();
            double value = 0;
            switch( sc.nextInt()) {
                case 1:
                    System.out.println("Digite o valor que deseja sacar");
                    value = sc.nextDouble(); 
                    boolean sucess =  count.withDrawn(Double.valueOf(value));
                    String resultado = (sucess) ? "Sucesso!" : "Negado!";
                    System.out.println(resultado);
                    menu.aguardar(2500);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar");
                    value = sc.nextDouble(); 
                    count.deposit(Double.valueOf(value));
                    break;
                case 3:
                    System.out.println(count.getStatmentAccount());
                    menu.aguardar(3000);
                    break;
                case 4:
                    System.out.println(count);
                    menu.aguardar(3000);
                    break;
                case 5:
                    opiton = false;
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Digite um opção valida!");
                    break;
            }
        }
       return true;
    }

    public boolean generateAcount(String name){
        Account account = new Account(ag, lastAccount, name);
        this.accounts.add(account);
        lastAccount++;
        return true;
    }

    public void getAccounts() {
        accounts.forEach(Acout -> System.out.println(Acout));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }
    
    public double getValueBanck(){
        double totalValue = 0;
        for(var valor : this.accounts){
            if(valor != null) totalValue += valor.getValue(); 
        }
        return totalValue;
    }

    @Override
    public String toString() {
        return accounts.toString();
    }
}
