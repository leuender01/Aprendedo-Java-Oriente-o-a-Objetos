import java.util.ArrayList;
import java.util.List;

public class ArraysDInamicos{
    public static void main(String[] args) {
        //String[] => Fixo
        //new ArrayList<String>() => DInamicos
        List<String> names = new ArrayList<String>();
        System.out.println(names.isEmpty());
        names.add("Leuender");
        names.add("Laboratorio");
        names.add("sistema");
        names.add("bagaça");
        System.out.println(names.isEmpty());
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
        names.clear();
        int index = names.indexOf("Laboratorio");
        System.out.println(index);
        System.out.println(names.contains("Leuender"));
        System.out.println(names.contains("Leuend"));
    }
}

