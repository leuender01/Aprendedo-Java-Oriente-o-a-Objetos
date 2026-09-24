package classes;

public class Menu{
    private final String[] optionsAccount = {
        "[1] Sacar: ",
        "[2] Depositar:  ",
        "[3] Extrato: ",
        "[4] Info: ",
        "[5] Exit: "
    };
    private final String[] optionsBanck = {
        "[1] Criar: ",
        "[2] Login:  ",
        "[3] Listar: ",
        "[4] Info: ",
        "[5] Exit: "
    };
    public void getOptionsBanck() {
        System.out.println("Selecione uma opção!");
        for(var names : optionsBanck){
            System.out.println(names);
        }
    }
    public void getOptionsAccount() {
        System.out.println("Selecione uma opção!");
        for(var names : optionsAccount){
            System.out.println(names);
        }
    }
    public void aguardar(int ms){
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
            }
    }
}

