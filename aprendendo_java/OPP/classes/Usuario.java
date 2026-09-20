package classes;

public class Usuario {
    private String firstName;
    private String secondName;
    private String email;
    private String cpf;
    private int    idade;

    public void setFirstName(String name){
        this.firstName = name; 
    }

    public void setSecondName(String name){
        this.secondName = name; 
    }

    public void setEmail(String email){
        this.email = email; 
    }

    public void setCpf(String Cpf){
        this.cpf = Cpf; 
    }
    public void setIdade(int idade){
        this.idade = idade; 
    }
    public String getFullName(){
        return firstName + " " + secondName;
    }

    public void getInfo(){
        System.out.println("Nome: " + (String)(this.firstName + " " + this.secondName).toUpperCase());
        System.out.println("Nome: " + this.email);
        System.out.println("Nome: " + this.cpf);
        System.out.println("Nome: " + this.idade);
    }
}
