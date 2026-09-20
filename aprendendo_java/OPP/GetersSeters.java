import classes.*;

public class GetersSeters{
    public static void main(String[] args) {
       Usuario user = new Usuario();
       user.setFirstName("Leuender");
       user.setSecondName("Oliveira");
       user.setIdade(20);
       user.setEmail("anonymus@gmail.com");
       user.setCpf("00000000000");
       user.getInfo();
       user.getFullName();
       System.out.println(user.getFullName());
    }
}
