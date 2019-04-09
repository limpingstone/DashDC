package app.asset;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssetNoteTest {

    AssetNote assetNote = new AssetNote(10, "testNote");
    
    @Test
    public void testConstructor() {
        // Testing the constructor
        assertEquals(10, assetNote.getId());
        assertEquals("testNote", assetNote.getName());
        assertEquals("new note", assetNote.getContents());

    }

    @Test
    public void testGetContents() {
	assetNote = new AssetNote(22, "hello");
	assertEquals("new note", assetNote.getContents());
    }
    
    @Test
    public void testSetContents() {
        // Test set ID
	assetNote = new AssetNote(34, "bye");
	assetNote.setContents("homework");
	assertEquals("homework", assetNote.getContents());
    }
    
    @Test
    public void testDisplay() {
	// tests the display() method
	assetNote = new AssetNote(66, "thoughts");
	assertNotNull(assetNote.display());
    }
		     
	
    
}
