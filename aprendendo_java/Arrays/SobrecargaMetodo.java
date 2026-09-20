import classes.Usuario;
public class SobrecargaMetodo{
    public static void main(String[] args) {
        Usuario[] user =  new Usuario[]{
            new Usuario("Leuender", "Oliveira", 20),
            new Usuario("BOla", "GAto", 3232),
            new Usuario("Leuender", "Oliveira"),
            new Usuario("Leuender"),
            new Usuario(20)
        };
        
        for(Usuario use : user){
            use.getInfo();
            System.out.println(use.toString());
        }
    }
}
