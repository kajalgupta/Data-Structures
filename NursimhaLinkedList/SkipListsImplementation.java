package NursimhaLinkedList;

public class SkipListsImplementation {
    public static void main(String[] args) {
        SkipList s = new SkipList();
        s.add(1, 100);
        s.add(2, 200);
        s.add(3, 300);
        System.out.println(s.get(1));
        System.out.println(s.get(100));
        System.out.println(s.containsKey(3));
    }

}