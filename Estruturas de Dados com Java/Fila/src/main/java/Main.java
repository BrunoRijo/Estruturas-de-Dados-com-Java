public class Main {

    public static void main(String[] args) {

        Fila<String> minhaFila = new Fila<>();

        System.out.println("A fila é a seguinte:");
        minhaFila.enqueue("primeiro");
        minhaFila.enqueue("segundo");
        minhaFila.enqueue("terceiro");
        minhaFila.enqueue("quarto");
        minhaFila.enqueue("quinto");

        System.out.println(minhaFila);

        System.out.println("removendo o primeiro da fila");
       System.out.println(minhaFila.dequeue());

        System.out.println("A fila atual é:");
        System.out.println(minhaFila);

        System.out.println("O primeiro item da fila é:");
        System.out.println(minhaFila.first());

        System.out.println("inserindo um item na fila");
        minhaFila.enqueue("ultim da fila");

        System.out.println("Nova fila com dados inseridos:");
        System.out.println(minhaFila);

    }
}
