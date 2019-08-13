import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test public void
    sayHi_With_pui_Should_return_hello_pui() {
        // Arrange
        HelloWorld1 helloWorld = new HelloWorld1();

        // Act
        String actualResult = helloWorld.sayHi("pui");

        // Assert
        assertEquals("Hello, pui", actualResult);
    }

    @Test public void
    sayHi_With_somkiat_Should_return_hello_somkiat() {
        // Arrange
        HelloWorld1 helloWorld = new HelloWorld1();

        // Act
        String actualResult = helloWorld.sayHi("somkiat");

        // Assert
        assertEquals("Hello, somkiat", actualResult);
    }

}
