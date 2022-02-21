public class Main {

    public static void main(String[] args) {

        ListaCircular<String> listaCircular = new ListaCircular<>();

        listaCircular.add("0");
        System.out.println(listaCircular);

        listaCircular.remove(0);
        System.out.println(listaCircular);

        listaCircular.add("1");
        System.out.println(listaCircular);

        listaCircular.add("2");
        listaCircular.add("3");
        System.out.println(listaCircular);

        //Mostrando como é uma lista infinita
        System.out.println(listaCircular.get(0));
        System.out.println(listaCircular.get(1));
        System.out.println(listaCircular.get(2));
        System.out.println(listaCircular.get(3));
        System.out.println(listaCircular.get(4));
        System.out.println(listaCircular.get(5));








    }
}
