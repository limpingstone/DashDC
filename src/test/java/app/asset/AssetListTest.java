package app.asset;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetListTest {

    AssetList assetList = new AssetList(10, "testList", 'u');
    
    @Test
    public void testConstructor() {
        // Testing the constructor
        assertEquals(10, assetList.getId());
        assertEquals("testList", assetList.getName());
        assertEquals('u', assetList.getType());

    }

    @Test
    public void testGetType() {
	// Testing the getType() method
	assetList = new AssetList(44, "testList", 'u');
	assertEquals('u', assetList.getType());

	assetList.setType('o');
	assertEquals('o', assetList.getType());
    }

    @Test
    public void testSetType() {
	// Testing the setType() method
	assetList = new AssetList(33, "testing", 'o');
	assetList.setType('u');
	assertEquals('u', assetList.getType());
    }


    @Test
    public void testGetListContents() {
	// Testing hte getListContents() method
	assetList = new AssetList(22, "hello", 'u');
	assertEquals(0, assetList.getListContents().size());

	assetList.addListItem("bye");
	assetList.addListItem("moon");

	assertEquals(2, assetList.getListContents().size());
    }

    @Test
    public void testAddListItem() {
	// Testing both version of the addListItem() methods
	assetList = new AssetList(87, "list", 'o');
	assetList.addListItem("green");
	assetList.addListItem("blue");

	assertEquals("green", assetList.getListContents().get(0));
	assertEquals("blue", assetList.getListContents().get(1));

	assetList.addListItem("yellow", 1);
	assertEquals("yellow", assetList.getListContents().get(1));
	assertEquals("blue", assetList.getListContents().get(2));
    }

    @Test
    public void testContentEdit() {
	// Testing the contentEdit() method
	assetList = new AssetList(2, "fruits", 'u');
	assetList.addListItem("orange");
	assetList.addListItem("peach");

	assertEquals(assetList.contentEdit(), "*orange\n*peach\n");
    }

    @Test
    public void testUpdateContents() {
	// Testing the updateContents() method
	assetList = new AssetList(3, "vegetables", 'u');
	assetList.updateContents("*broccoli\n*squash\n");

	assertEquals("squash", assetList.getListContents().get(1));
	assertEquals("broccoli", assetList.getListContents().get(0));
    }
	
	
    @Test
    public void testDisplay() {
	// tests the display() method
	assetList = new AssetList(66, "deep", 'u');
	assetList.addListItem("trench");
	assetList.addListItem("sea");
	
	assertNotNull(assetList.display());
    }
		     
	
    
}
