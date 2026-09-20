import java.util.Random;

public class GeradorNumeros{
    public static void main(String[] args) {
        Random aleatorio = new Random();
        String caracters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
        int sizeCaracters = caracters.length();
        int sizeString;
        StringBuilder result = new StringBuilder();
        
        if(args.length > 0){
            System.out.println(args[0]);
            sizeString  = Integer.parseInt(args[0]);
        }else{
            sizeString = 18;
        }

        for(int i = 0; i < sizeString; i++){
            int randomNumber = aleatorio.nextInt(sizeCaracters);
            result.append(caracters.charAt(randomNumber));
        }
        System.out.println(result);
    }
}
