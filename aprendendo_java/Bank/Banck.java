import classes.Account;

public class Banck{
    public static void main(String[] args) {
        Account account = new Account("0129233", "234", "Seu Madruga");

        account.deposit(100);
        boolean sucess =  account.withDrawn(10.0);
        if(sucess){
            System.out.println("saque feito com sucesso");
        }else{
            System.out.println("Erro saque");
        }
        System.out.println(account.toString());
        System.out.println(account.getStatmentAccount());
    }
}

