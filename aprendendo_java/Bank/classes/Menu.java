package classes;

public class Menu{
    private final String[] options = {
        "[1] Sacar: ",
        "[2] Depositar:  ",
        "[3] Extrato: ",
        "[4] Info: ",
        "[5] Exit: "
    };
    public void getOptions() {
        for(String names : options){
            System.out.println(names);
        }
    }
}

