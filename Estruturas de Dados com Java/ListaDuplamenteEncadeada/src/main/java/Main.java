public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> minhaListaD =
                new ListaDuplamenteEncadeada();

        minhaListaD.add("c1");
        minhaListaD.add("c2");
        minhaListaD.add("c3");
        minhaListaD.add("c4");
        minhaListaD.add("c5");
        minhaListaD.add("c6");
        minhaListaD.add("c7");

        System.out.println(minhaListaD);

        System.out.println(minhaListaD.get(1));

        System.out.println("substituindo o item 1 por 99");
        minhaListaD.remove(1);
        minhaListaD.addIndice(1,"99");

        System.out.println(minhaListaD.get(1));

    }
}
