// import java.ultil.Random;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // for (int i = 0; i < 20; i++) {
        //     tree.add(new Random().nextInt(50));
        // }

        tree.add(5);
        tree.add(9);
        tree.add(3);
        tree.add(4);
        tree.add(7);
        tree.add(6);


        tree.print();
    }
}
