package classes;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class StatmentAccount{
    private List <String> history = new ArrayList<String>();

    public void out(double value){
        String dataFormatada = getDate();
        this.history.add("Valor de " +  -value + " as [ " +  dataFormatada + " ]\n");
    }  
    public void in(double value){
        String dataFormatada = getDate();
        this.history.add("Valor de " +  value + " as [ " +  dataFormatada + " ]\n");
    }  
    public void error(double value){
        String dataFormatada = getDate();
        this.history.add("Valor negado de "+ value + "as [ " +  dataFormatada + " ]\n");
    }

    private String getDate(){
        LocalDateTime hoje = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return hoje.format(formatador);
    }
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        this.history.forEach(data -> resultado.append(data));
        return resultado.toString();
    }
}
