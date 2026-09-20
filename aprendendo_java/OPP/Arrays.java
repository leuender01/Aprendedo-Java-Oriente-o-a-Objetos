import classes.Usuario;

public class Arrays{
    public static void main(String[] args) {
        Usuario[] users = new Usuario[]{
            new Usuario("Leuender", "Oliveira", 20),
            new Usuario("Lauani", "Souza", 11),
            new Usuario()
        };
        
        for(int i = 0; i < users.length; i++){
            users[i].getInfo();
        }

    }
}
