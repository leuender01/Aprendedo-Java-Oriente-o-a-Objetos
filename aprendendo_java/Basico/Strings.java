public class Strings{
    public static void main(String[] args) {
        String texto = "    AoLeeuLeeuPro Lauani   ";
        System.out.println(texto);
        System.out.println(texto.length());
        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());
        System.out.println(texto);
        System.out.println(texto.contains("Leeu"));
        System.out.println(texto.indexOf("Leeu"));
        System.out.println(texto.lastIndexOf("Leeu"));
        System.out.println(texto + "concatenada");
        System.out.println(texto.trim());
        System.out.println(texto.substring(8));
        System.out.println(texto.equals("    "));
    }
}

