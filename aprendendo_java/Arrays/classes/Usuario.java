package classes;

import java.util.Objects;

public class Usuario {
    private String firstName;
    private String secondName;
    private String email;
    private String cpf;
    private int    idade;

    public Usuario(){
        this.firstName = " ";
        this.secondName = " ";
        this.idade = 0;
        setEmailCpf();
    }
    public Usuario(int idade){
        this.firstName = " ";
        this.secondName = " ";
        this.idade = idade;
        setEmailCpf();
    }

    public Usuario(String firstName){
        this.firstName = firstName;
        this.secondName = " ";
        this.idade = 0;
        setEmailCpf();
    }

    public Usuario(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.idade = 0;
        setEmailCpf();
    }

    public Usuario(String firstName, String secondName, int idade){
        this.firstName = firstName;
        this.secondName = secondName;
        this.idade = idade;
        setEmailCpf();
    }
    
    public String toString(){
        return "{firstName=" + firstName + " , " + "secondName=" + secondName + " , " + "idade=" + idade + "}";
    }

    private void setEmailCpf(){
        this.cpf = "00000000000";
        this.email = "anonymus@gmail.com";
    }

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

    @Override
    public int hashCode(){
        return Objects.hash(firstName, secondName);
    } 

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Usuario user = (Usuario) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName);
    }

    public void getInfo(){
        System.out.println("Nome: " + (String)(this.firstName + " " + this.secondName).toUpperCase());
        System.out.println("Email: " + this.email);
        System.out.println("Cpf: " + this.cpf);
        System.out.println("Idade: " + this.idade);
    }
}
