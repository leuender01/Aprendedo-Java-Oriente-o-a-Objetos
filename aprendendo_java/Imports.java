import classes.User;

public class Imports {
    public static void main(String[] args)
    {
// A palavra chave **final** declara uma constante        
        final double PI = 3.14 ;
        System.out.println(PI);
        User user = new User();
        user.name  = "Leuender";
        user.getName();
    }
}
