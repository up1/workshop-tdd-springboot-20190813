import org.junit.Test;

import static org.junit.Assert.*;

public class MyRangeTesting {

    @Test public void
    case_01() {
        MyRange range = new MyRange("[1,5]");
        String actualResult = range.generate();
        assertEquals("12345", actualResult);
    }

    @Test public void
    start_number_with_exclude() {
        MyRange range = new MyRange("(1,5]");
        int actualResult = range.getStart();
        assertEquals(2, actualResult);
    }

    @Test public void
    start_number_with_include() {
        MyRange range = new MyRange("[1,5]");
        int actualResult = range.getStart();
        assertEquals(1, actualResult);
    }

    @Test public void
    check_input_ตัวสุดท้าย_ต้องเป็น_exclude() {
        MyRange range = new MyRange("[1,5)");
        boolean actualResult = range.isEndInputWithInclude();
        assertFalse(actualResult);
    }

    @Test public void
    check_input_ตัวสุดท้าย_ต้องเป็น_include() {
        MyRange range = new MyRange("[1,5]");
        boolean actualResult = range.isEndInputWithInclude();
        assertTrue(actualResult);
    }

    @Test public void
    check_input_ตัวแรก_ต้องเป็น_exclude() {
        MyRange range = new MyRange("(1,5]");
        boolean actualResult = range.isStartInputWithInclude();
        assertFalse("ต้องเริ่มต้นด้วย (", actualResult);
    }

    @Test public void
    check_input_ตัวแรก_ต้องเป็น_include() {
        // Arrange
        MyRange range = new MyRange("[1,5]");

        // Act
        boolean actualResult = range.isStartInputWithInclude();

        // Assert
        assertTrue("ต้องเริ่มต้นด้วย [", actualResult);
    }

}
