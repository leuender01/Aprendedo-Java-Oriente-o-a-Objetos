import java.util.ArrayList;
import java.util.List;
import classes.Usuario;

public class ColecaoListaArraylist{
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        int i  = 0;
        while (i < 10) {
            Usuario actual = new Usuario("Leuender", "Oliveira", 20);
            lista.add(actual);
            i++;
        }

        for(int j = 0; j < lista.size(); j++){
            lista.get(j).getInfo();
        }

    }
}

