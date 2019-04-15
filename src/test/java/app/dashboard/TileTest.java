package app.dashboard;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

import app.asset.*;
import app.dashboard.*;

@SpringBootTest
public class TileTest {

    Tile tile;
    int[] size;
    int[] position;

    @Before
    public void setup() {
	tile = new Tile();
	size = new int[] {0, 0};
	position = new int[] {0, 0};
    }
    
    @Test
    public void testDefaultConstructor() {
        // Testing the default constructor
	tile = new Tile();

	// default values
	assertEquals("Default.", tile.getName());
	assertEquals(0, tile.getId());
	assertEquals(0, tile.getAssets().size());
    }

    @Test
    public void testOverloadedConstructor() {
	// Testing the overloaded constructor
	tile = new Tile(5, "name");
	assertEquals("name", tile.getName());
	assertEquals(5, tile.getId());
	assertEquals(0, tile.getAssets().size());
    }

    @Test
    public void testGetAssets() {
	tile = new Tile();
	// tile w/ no assets
	assertEquals(0, tile.getAssets().size());

	// tile w/ 1 asset only
	tile.addAssetImage(10, "image1", "path1", size, position);
	assertEquals(1, tile.getAssets().size());

	// tile w/ 3 assets
	tile.addAssetImage(11, "image2", "path2", size, position);
	tile.addAssetImage(12, "image3", "path3", size, position);
	assertEquals(3, tile.getAssets().size());

	// test a list of asset objects returned
	for ( int i = 0; i < tile.getAssets().size(); i++ )
	    assertTrue(tile.getAssets().get(i) instanceof DashboardAsset);
    }

    @Test
    public void testGetAssetNames() {
	tile = new Tile();
	// tile w/ no assets
	assertEquals(0, tile.getAssetNames().size());
	
	// tile w/ 1 asset only
	tile.addAssetImage(10, "image1", "path1", size, position);
	assertArrayEquals(new String[] {"image1"}, tile.getAssetNames().toArray());

	// tile w/ 3 assets
	tile.addAssetImage(11, "image2", "path2", size, position);
	tile.addAssetImage(12, "image3", "path3", size, position);
	assertArrayEquals(new String[] {"image1", "image2", "image3"}, tile.getAssetNames().toArray());

    }

    @Test
    public void testGetAsset() {
	tile = new Tile();
	// tile w/ no assets
	assertNull(tile.getAsset(0));

	tile.addAssetImage(10, "image1", "path1", size, position);
	assertEquals("image1", tile.getAsset(10).getName());

	// tile w/ 3 assets
	tile.addAssetImage(11, "image2", "path2", size, position);
	tile.addAssetImage(12, "image3", "path3", size, position);
	assertEquals("image3", tile.getAsset(12).getName());

	// no such tile w/ id 5
	assertNull(tile.getAsset(5));
    }

    @Test
    public void testDeleteAsset() {
	tile = new Tile();
	tile.addAssetImage(1, "image", "path", size, position);
	tile.addAssetLink(2, "link", "path");
	tile.addAssetNote(3, "note");

	tile.deleteAsset(1);
	assertEquals(2, tile.getAssets().size()); // 2 assets left

	tile.deleteAsset(3);
	assertArrayEquals(new String[] {"link"}, tile.getAssetNames().toArray());

	tile.deleteAsset(2); 
	assertEquals(0, tile.getAssets().size()); // no assets left
    }
    
	
    @Test
    public void testAddAssetImage() {
	tile = new Tile();

	// add 1 asset to tile
	tile.addAssetImage(1, "image1", "path1", size, position);
	assertArrayEquals(new String[] {"image1"}, tile.getAssetNames().toArray());

	// add 2 more assets to tile
	tile.addAssetImage(2, "image2", "path2", size, position);
	tile.addAssetImage(3, "image3", "path3", size, position);
	assertArrayEquals(new String[] {"image1", "image2", "image3"}, tile.getAssetNames().toArray());
    }

    @Test
    public void testAddAssetLink() {
	tile = new Tile();

	// add 1 asset to tile
	tile.addAssetLink(1, "link1", "path1");
	assertArrayEquals(new String[] {"link1"}, tile.getAssetNames().toArray());

	// add 2 more assets to tile
	tile.addAssetLink(2, "link2", "path2");
	tile.addAssetLink(3, "link3", "path3");
	assertArrayEquals(new String[] {"link1", "link2", "link3"}, tile.getAssetNames().toArray());
    }


    @Test
    public void addAssetList() {
	tile = new Tile();

	// add 1 asset to tile
	tile.addAssetList(1, "list1", "ordered");
	assertArrayEquals(new String[] {"list1"}, tile.getAssetNames().toArray());

	// add 2 more assets to tile
	tile.addAssetList(2, "list2", "ordered");
	tile.addAssetList(3, "list3",  "unordered");
	assertArrayEquals(new String[] {"list1", "list2", "list3"}, tile.getAssetNames().toArray());

	// check list types
	assertEquals(((AssetList)tile.getAsset(1)).getType(), 'o');
	assertEquals(((AssetList)tile.getAsset(3)).getType(), 'u');
    }

    @Test
    public void addAssetNote() {
	tile = new Tile();

	// add 1 asset to tile
	tile.addAssetNote(1, "note1");
	assertArrayEquals(new String[] {"note1"}, tile.getAssetNames().toArray());

	// add 2 more assets to tile
	tile.addAssetNote(2, "note2");
	tile.addAssetNote(3, "note3");
	assertArrayEquals(new String[] {"note1", "note2", "note3"}, tile.getAssetNames().toArray());

	assertEquals(((AssetNote)tile.getAsset(2)).getContents(), "new note");

    }

    @Test
    public void testDisplay() {
	tile = new Tile();

	// add assets to tile
	tile.addAssetNote(1, "note1");
	tile.addAssetList(2, "list1", "ordered");

	assertNotNull(tile.display());
    }
    
	    
    /* TESTS OF ACCESSOR METHODS */
    @Test
    public void testGetName() {
	tile = new Tile();
	assertEquals("Default.", tile.getName());

	tile = new Tile(5, "hello");
	assertEquals("hello", tile.getName());
    }

    @Test
    public void testGetId() {
	tile = new Tile();
	assertEquals(0, tile.getId());

	tile = new Tile(5, "hello");
	assertEquals(5, tile.getId());
    }
}
