import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoObjetos{
    public static void main(String[] args) {
        List <String> names = new ArrayList<String>();
        
        names.add("Leuender");
        names.add("Bola");
        names.add("Cachorro");
        for(String name : names){
            System.out.println(name);
        }

        //Ordenando A lista
        Collections.sort(names);

        for(String name : names){
            System.out.println(name);
        }
    }
}

