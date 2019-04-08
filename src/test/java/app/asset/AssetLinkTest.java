package app.asset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetLinkTest {

    AssetLink assetLink = new AssetLink(10, "testLink", "someLinkPath");
    
    @Test
    public void testConstructor() {
        // Testing the constructor
        assertEquals(10, assetLink.getId());
        assertEquals("testLink", assetLink.getName());
        assertEquals("someLinkPath", assetLink.getLink());

    }

    @Test
    public void testSetters() {
        // Test set ID
        assetLink.setId(40);
        assertEquals(40, assetLink.getId());

        // Test set Name
        assetLink.setName("otherTestLink");
        assertEquals("otherTestLink", assetLink.getName());

        // Test set Path
        assetLink.setLink("secondLinkPath");
        assertEquals("secondLinkPath", assetLink.getLink());
    }
    
    @Test
    public void testDisplay() {
	// tests the display() method
	assetLink = new AssetLink(55, "web", "canvas");
	assertEquals(assetLink.display(), "<br><a href='canvas' target='_blank'>web</a><br>");
    }
		     
	
    
}
