import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GBLinkedListTest {

    @Test
     void addTest() {
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.add(2.3);
        dblList.add(8.1);
        dblList.add(9.5);
        Assertions.assertEquals(9.5, dblList.get(0));
    }

    @Test
    void addNegativeTest() {
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.add(2.3);
        dblList.add(8.1);
        dblList.add(9.5);
        Assertions.assertNotEquals(2.3, dblList.get(0));
    }

    @Test
    void addEndTest() {
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        dblList.addEnd(8.1);
        dblList.addEnd(9.5);
        Assertions.assertEquals(9.5, dblList.get(2));
    }

    @Test
    void addEndNegativeTest() {
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        dblList.addEnd(8.1);
        dblList.addEnd(9.5);
        Assertions.assertNotEquals(2.3, dblList.get(2));
    }

    @Test
    void sizeTest() {
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        dblList.addEnd(8.1);
        dblList.addEnd(9.5);
        Assertions.assertEquals(3, dblList.size());
    }

    @Test
    void sizeNegativeTest() {
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        dblList.addEnd(8.1);
        dblList.addEnd(9.5);
        Assertions.assertNotEquals(4, dblList.size());
    }
    @Test
    void getTest(){
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        Assertions.assertEquals(2.3,dblList.get(0));
    }
    @Test
    void getNegativeTest(){
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        Assertions.assertNotEquals(2.9,dblList.get(0));
    }

    @Test
    void removeTest(){
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        dblList.addEnd(8.1);
        dblList.remove(1);
        Assertions.assertEquals(1, dblList.size());
        dblList.remove(0);
        Assertions.assertEquals(0, dblList.size());
    }
    @Test
    void removeNegativeTest(){
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(2.3);
        dblList.addEnd(8.1);
        dblList.remove(1);
        Assertions.assertNotEquals(2, dblList.size());
        dblList.remove(0);
        Assertions.assertNotEquals(1, dblList.size());
    }
    @Test
    void updateTest(){
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(8.1);
        dblList.update(0, 5.9);
        Assertions.assertEquals(5.9, dblList.get(0));
        dblList.addEnd(4.1);
        dblList.update(1, 5.9);
        Assertions.assertEquals(5.9, dblList.get(1));
    }
    @Test
    void updateNegativeTest(){
        GBList<Double> dblList = new GBLinkedList<>();
        dblList.addEnd(8.1);
        dblList.update(0, 5.9);
        Assertions.assertNotEquals(8.1, dblList.get(0));
        dblList.addEnd(4.1);
        dblList.update(1, 5.9);
        Assertions.assertNotEquals(4.1, dblList.get(1));
    }
}
