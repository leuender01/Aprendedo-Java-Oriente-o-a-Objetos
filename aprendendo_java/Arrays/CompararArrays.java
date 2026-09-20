import java.util.Arrays;

public class CompararArrays{
    public static void main(String[] args) {
        int[] numberB = {1,2,3};
        int[] numberA = {1,2,3};
        System.out.println(Arrays.equals(numberB, numberA));
        String[] desconhecido = new String[10];
        System.out.println(Arrays.toString(desconhecido));
        Arrays.fill(desconhecido, "Leuender");
        System.out.println(Arrays.toString(desconhecido));
    }
}
