import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooTest2 {
    private Foo f;
    @BeforeEach
    public void init(){
        f = new Foo();
    }
    @Test
    public void testAdd() {
        f.setX(8);
        assertEquals(8, f.getX());
    }
    @Test
    public void newTest(){
        assertEquals(7, f.bar(5));
    }
    @Test
    public void testSqrt(){
        assertEquals(2, f.squareRt(4));
    }
    @Test
    public void testSquarer(){
        assertEquals(4, f.squarer(2));

    }

    @Test
    void calculateBMIScore() {
        assertEquals(24.4, f.calculateBMIScore(180,72));
    }
}

