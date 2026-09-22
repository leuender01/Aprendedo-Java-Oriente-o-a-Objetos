package classes;

public class Account{

    private String agencia;
    private String cc;
    private String name;
    
    public Account(String ag, String cc, String name){
        this.agencia = ag;
        this.cc = cc;
        this.name = name;
    }
    @Override 
    public String toString() {
        return "name: " + name + "\n\rcc: " + cc + "\n\ragencia: " + agencia; 
    }
}
