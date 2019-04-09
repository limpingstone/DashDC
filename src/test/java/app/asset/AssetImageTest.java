package app.asset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetImageTest {

    int[] testSize = new int[]{300,500};
    int[] testPosition = new int[]{5, 10};

    AssetImage assetImage = new AssetImage(10, "testImage", "someImagePath", new int[] { 300, 500 },
            new int[] { 5, 10 });
    
    @Test
    public void testConstructor() {
        // Testing the constructor
        assertEquals(10, assetImage.getId());
        assertEquals("testImage", assetImage.getName());
        assertEquals("someImagePath", assetImage.getPath());

        
        assertEquals(300, assetImage.getSize()[0]);
        assertEquals(500, assetImage.getSize()[1]);
        
        assertEquals(5, assetImage.getPosition()[0]);
        assertEquals(10, assetImage.getPosition()[1]);
    }

    @Test
    public void testSetters() {
        // Test set ID
        assetImage.setId(40);
        assertEquals(40, assetImage.getId());

        // Test set Name
        assetImage.setName("otherTestImage");
        assertEquals("otherTestImage", assetImage.getName());

        // Test set Path
        assetImage.setPath("secondImagePath");
        assertEquals("secondImagePath", assetImage.getPath());

        // Test set Size
        assetImage.setSize(new int[] { 400, 200 });
        assertEquals(400, assetImage.getSize()[0]);
        assertEquals(200, assetImage.getSize()[1]);

        // Test set Position
        assetImage.setPosition(new int[] { 50, 100 });
        assertEquals(50, assetImage.getPosition()[0]);
        assertEquals(100, assetImage.getPosition()[1]);

        // To fail the test, uncomment this:
        /*
        assetImage.setPosition(new int[] { 50, 100 });
        assertEquals(100, assetImage.getPosition()[0]);
        assertEquals(50, assetImage.getPosition()[1]);
        */
    }
    @Test
    public void testDisplay() {
	// tests the display() method
	assetImage = new AssetImage(20, "image1", "link", new int[] {200, 210}, new int[] {2, 2});
	assertEquals(assetImage.display(), "<img src=\"link\" style=\"width:200; height: 210;\"><br>");
    }
		     
	
    
}
