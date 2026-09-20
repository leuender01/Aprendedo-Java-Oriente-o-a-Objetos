import java.util.Scanner;

public class Calculate {
    public class GlobalVariable
    {
        public static String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        public static Scanner sc = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.println("Seleceione uma operação: ");
            for (int i = 0; i <  GlobalVariable.operacoes.length; i++) {
                System.out.printf("[ %d ]:  %s\n",i + 1, GlobalVariable.operacoes[i]);
            }
            try{
                int texto = GlobalVariable.sc.nextInt();
                System.out.println("resultado: " + calculate(texto));
                GlobalVariable.sc.nextLine();
                Thread.sleep(2000);
            }catch (InterruptedException a){
                GlobalVariable.sc.close();
                break;
            }catch (Exception e){
                System.out.println("Digite um numero Valido! ");
                continue;
           }
        }
    }
    static int calculate(int operation) throws Exception
    {
        int[] resultado;
        switch (operation) {
            case 1:
                resultado = Lerdata(operation);
                if(resultado == null) throw new Exception("Error no Sintaxe dos numeros!"); 
                return  (resultado[0] + resultado[1]);
            case 2:
                resultado = Lerdata(operation);
                if(resultado == null) throw new Exception("Error no Sintaxe dos numeros!"); 
                return (resultado[0] - resultado[1]);
            case 3:
                resultado = Lerdata(operation);
                if(resultado == null) throw new Exception("Error no Sintaxe dos numeros!"); 
                return (resultado[0] * resultado[1]);
            case 4:
                resultado = Lerdata(operation);
                if(resultado == null) throw new Exception("Error no Sintaxe dos numeros!"); 
                return (resultado[0] / resultado[1]);
            default:
                throw new Exception("Error no Sintaxe dos numeros!"); 
        }
    }
    public static int[] Lerdata(int opc)
    {
        opc--;
        int[] resultado = new int[2];
        String[] opcaao = { "primeira" , "segunda"};
        if(opc > -1 &&  opc < (GlobalVariable.operacoes.length  ) ) 
        {
            for(int i = 0; i < 2; i++){
                System.out.printf("Digite o %s numero que deseja %s\n", opcaao[i], GlobalVariable.operacoes[opc]);
                resultado[i] = GlobalVariable.sc.nextInt();
            }
        }else{
            resultado = null;
        }
        return resultado;
    }
}
