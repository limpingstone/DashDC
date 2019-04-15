package app.dashboard;

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

    @Test
    public void testAddTile() {
	// testing the addTile() method
	page = new Page();
	page.addTile(3, "calvin");
	page.addTile(2, "lollipop");
	assertArrayEquals(new String[] {"calvin", "lollipop"}, page.getTileNames().toArray());
    }

    @Test
    public void testDeleteTile() {
	// testing the deleteTile() method
	page = new Page();
	page.addTile(1, "one");
	page.addTile(2, "two");
	page.addTile(3, "three");

	page.deleteTile(2);
	assertEquals(2, page.getTiles().size()); // two tiles left

	page.deleteTile(3);
	assertArrayEquals(new String[] {"one"}, page.getTileNames().toArray());

	page.deleteTile(1);
	assertEquals(0, page.getTiles().size());
    }
    
    @Test
    public void testGetTile() {
	// testing the getTile() method
	page = new Page();
	page.addTile(10, "chi");

	assertEquals(page.getTile(10).getName(), "chi");
	assertNull(page.getTile(1));
    }

    @Test
    public void testGetTiles() {
	// testing the getTiles() method
	page = new Page();
	page.addTile(3, "calvin");
	page.addTile(2, "lollipop");
	
	assertNotNull(page.getTiles());
	assertEquals(2, page.getTiles().size());
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

        page = new Page(5, "testing");
        assertEquals(5, page.getId());
    }
}
