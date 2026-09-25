import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class CriarArquivos{
    public static void main(String[] args) {
        List<String> list = List.of("Welcome");
        try{
            Files.write(Paths.get("arquivo.txt"), list,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
                    );
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

