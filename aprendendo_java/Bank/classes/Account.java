package classes;

public class Account{
    private static final int MAX_SIZE = 12;

    private String agencia;
    private int cc;
    private String name;
    private double balance = 0;

    Log logger = new Log();
    StatmentAccount statmentAccount = new StatmentAccount();
    
    public Account(String ag, int cc, String name){
        this.agencia = ag;
        this.cc = cc;
        setName(name);
    }
    public boolean getName(String name){
        String nameAccoutString = this.name.toLowerCase();
        String nameSearch = name.toLowerCase();
        return nameAccoutString.equals(nameSearch);
    }

    public boolean withDrawn(double value){
        if(value > this.balance){
            logger.out("Saldo atual e de R$ " + balance);
            statmentAccount.error(value);
            return false;
        }
        balance -= value;
        logger.out("Saldo atual e de R$ " + balance);
        statmentAccount.out(value);
        return true;
    }

    public boolean deposit(double value){
        balance += value;
        logger.out("Saldo atual e de R$ " + balance);
        statmentAccount.in(value);
        return true;
    }
    public String getStatmentAccount(){
        return statmentAccount.toString();

    }

    private void setName(String name){
        if(name.length() > MAX_SIZE){
            this.name = name.substring(0, MAX_SIZE);
        }else{
            this.name = name;
        } 
    }
    
    public double getValue(){
        return this.balance;
    }

    @Override
    public String toString(){
        return "Conta: " + cc + "\n\rAgencia: " + agencia + "\n\rName: " + name;
    }
}
