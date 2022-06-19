public class Main {
    public static void main(String[] args) {


        MyHashMap<Integer, String> s = new MyHashMap<Integer, String>();
        s.put(1, "111");
        s.put(1, "333");
        System.out.println(s.size());
        s.put(2, "111");
        s.put(4, "111");
        System.out.println(s.size());

        s.remove(4);

        System.out.println(s.size());

        System.out.println(s.get(4));


    }
}
