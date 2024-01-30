package Woche10;

public class Start {
    public static void main(String[] args) {
        LinkedNode<String> Stack1 = new LinkedNode<>();

        Stack1.add("0. auto");
        Stack1.add("1. haus");
        Stack1.add("2. brot");
        Stack1.add("3. pilz");
        System.out.println(Stack1.remove(1));
        Stack1.print();
    }
}
