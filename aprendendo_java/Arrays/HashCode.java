import classes.Usuario;
public class HashCode{
    public static void main(String[] args) {
        Usuario userA = new Usuario("Leuender", "Oliveira",20);
        Usuario userC = new Usuario("Leuender", "Oliveira",20);
        Usuario userB = new Usuario("Lauani", "Souza",20);

        System.out.println(userA.hashCode());
        System.out.println(userB.hashCode());
        System.out.println(userC.hashCode());

        System.out.println(userA.equals(userC));
        System.out.println(userB.equals(userA));
        System.out.println(userC.equals(userB));
    }
}

