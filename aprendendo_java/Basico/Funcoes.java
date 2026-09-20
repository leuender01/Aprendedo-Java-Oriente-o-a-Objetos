import java.util.Random;

public class Funcoes {
    public static void main(String[] args){
        Random number = new Random();
        int num1 = number.nextInt(100);
        int num2 = number.nextInt(100);
        System.out.println(sum(num1, num2));
        for(int i = 0; i < args.length ; i++){
            System.out.println(args[i]);
        }
    }
    
    static double sum(double i, double x){
        return i + x;
    }
    
    //Syntax <valor de retorno > <nome da função> (<parametros>) { <corpo da função}>
}
