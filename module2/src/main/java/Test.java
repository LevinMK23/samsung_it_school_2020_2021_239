public class Test {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i + 1);
        }
        for (int i = 15; i < 25; i++) {
            list.add(0, i + 1);
        }
        System.out.println(list);
        list.remove(new Integer(17));
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
