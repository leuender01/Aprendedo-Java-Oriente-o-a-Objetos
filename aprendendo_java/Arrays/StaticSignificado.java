public class StaticSignificado{
    private static class MetodosGlobais{
        private static int count = 0;
        public static int sum(int a, int b){
           count += 1;
           return a + b;
       }

       public static int getCount(){
           return count;
       }
    }

    public static void main(String[] args) {
        //static
        System.out.println(MetodosGlobais.sum(2, 4));
        System.out.println(MetodosGlobais.getCount());
        System.out.println(MetodosGlobais.sum(2, 4));
        System.out.println(MetodosGlobais.getCount());
        System.out.println(MetodosGlobais.sum(2, 4));
        System.out.println(MetodosGlobais.getCount());
        System.out.println(MetodosGlobais.sum(2, 4));
        System.out.println(MetodosGlobais.getCount());
    }
}
