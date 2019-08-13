import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

class Random5 implements MyRandom {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class SpyRandom implements MyRandom {
    private boolean called;

    public void verify() {
        if(!called) {
            fail("Method nextInt() not call");
        }
    }

    @Override
    public int nextInt(int bound) {
        this.called = true;
        
        return 60000;
    }
}

public class NumberServiceTest {

    @Test
    public void called_nextInt() {
        SpyRandom spyRandom = new SpyRandom();
        NumberService service = new NumberService();
        service.setRandom(spyRandom);
        // Act
        service.generate();
        // Assert
        spyRandom.verify();
    }

    @Test
    public void generate_5() {
        MyRandom stubRandom = new Random5();
        // Constructor injection
        NumberService service = new NumberService();
        // Setter/field/property injection
        service.setRandom(stubRandom);
        // Method injection
        int actualResult = service.generate();
        assertEquals(5, actualResult);
    }
}