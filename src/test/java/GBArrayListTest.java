import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GBArrayListTest {
    @Test
    void addTest(){
        GBList<Double> dblList = new GBArrayList<>();
        dblList.add(2.3);
        Assertions.assertEquals(2.3, dblList.get(0));
    }

    @Test
    void addNegativeTest(){
        GBList<Double> dblList = new GBArrayList<>();
        dblList.add(2.3);
        Assertions.assertNotEquals(2.2, dblList.get(0));
    }


}