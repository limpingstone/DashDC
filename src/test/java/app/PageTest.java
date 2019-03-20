package app;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageTest {

    Page page;
    int[] size;
    int[] position;

    @Before
    public void setup() {
        page = new Page();
        size = new int[] {0, 0};
        position = new int[] {0, 0};
    }

    @Test
    public void testDefaultConstructor() {
        // Testing the default constructor
        page = new Page();

        // default values
        assertEquals("Default.", page.getName());
        assertEquals(0, page.getId());
    }

    @Test
    public void testOverloadedConstructor() {
        // Testing the overloaded constructor
        page = new Page(5, "name");
        assertEquals("name", page.getName());
        assertEquals(5, page.getId());
    }

    /* TESTS OF ACCESSOR METHODS */
    @Test
    public void testGetName() {
        page = new Page();
        assertEquals("Default.", page.getName());

        page = new Page(5, "test");
        assertEquals("test", page.getName());
    }

    @Test
    public void testGetId() {
        page = new Page();
        assertEquals(0, page.getId());

        page = new page(5, "testing");
        assertEquals(5, page.getId());
    }
}
