package classes;

import java.util.List;

public class Banck{
    private String ag;
    private static int lastAccount = 0;
    private List<Account> accounts;

    public Banck(String agencia){
        this.ag = agencia;
    }

    public Account loginAccount(String name){
        for(Account count : accounts){
            if(count.getName(name)){
                return count;
            }
        }
        return null;
    }

    public void generateAcount(String name){
        Account account = new Account(ag, lastAccount, name);
        accounts.add(account);
        lastAccount++;
    }

    public void getAccounts() {
        accounts.forEach(Acout -> System.out.println(Acout));
    }

    @Override
    public String toString() {
        return accounts.toString();
    }
}
