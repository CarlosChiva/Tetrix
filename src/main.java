public class main {
    public static void main(String[] args) {
        Table table=new Table();
        table.printTable();

        System.out.println("-------------------------");
        table.movedPoint('s');
        table.printTable();
        System.out.println("-------------------------");
        table.movedPoint('a');
        table.printTable();

        System.out.println("-------------------------");
        table.movedPoint('d');
        table.printTable();

    }
}
