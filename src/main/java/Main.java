public class Main {
    public static void main(String[] args) {
        GBList<Integer> list = new GBArrayList<>();
        System.out.println(list.size());
        list.add(12);
        list.add(65);
        list.add(846);
        System.out.println(list.size());
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.update(2, 43);
        System.out.println(list.get(2));
        list.add(33);
        System.out.println(list);
        System.out.println();
        list.remove(2);
        System.out.println(list);
        System.out.println(list.size());

    }
}
