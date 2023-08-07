import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        GBList<Integer> list = new GBArrayList<>();
//        System.out.println(list.size());
//        list.add(12);
//        list.add(65);
//        list.add(846);
//        System.out.println(list.size());
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        list.update(2, 43);
//        System.out.println(list.get(2));
//        list.add(33);
//        System.out.println(list);
//        System.out.println();
//        list.remove(2);
//        System.out.println(list);
//        System.out.println(list.size());


        GBLinkedList<Integer> linList = new GBLinkedList<>();
        System.out.println(linList.size());
        System.out.println(linList);
        linList.add(145);

        System.out.println(linList.size());
        System.out.println(linList);
        linList.remove(0);
        System.out.println(linList.size());
        System.out.println(linList);
        linList.add(548);
        linList.add(79);
        linList.add(4361);
        linList.add(25);
        linList.add(8);
        System.out.println(linList.size());
        System.out.println(linList);

        linList.remove(0);
        linList.remove(3);
        linList.remove(1);
        System.out.println(linList.size());
        System.out.println(linList);
        linList.addEnd(785);
        linList.addEnd(365);
        linList.addEnd(85);
        System.out.println(linList);
        System.out.println(linList.get(3));
        linList.update(3,8569);
        System.out.println(linList.get(3));
        System.out.println(linList);

    }
}
