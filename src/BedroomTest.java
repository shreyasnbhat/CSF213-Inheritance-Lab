import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Bedroom Class
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class BedroomTest {

    private Bedroom room;
    private Random rand;
	

    @Before
    public void before() {
        rand = new Random();
    }

    @After
    public void tearDown() {
        room = null;
    }

    @Test
    public void testBedroomGetters() {
    	
        int length = rand.nextInt(100);
        int width = rand.nextInt(100);
        int height = rand.nextInt(100);
        room = new Bedroom(length, width, height, FloorType.MARBLE);
        //test getBill() when initialized
        Assert.assertEquals(0, room.getBill());
        
        
        //test addBed() & sleep()
        Assert.assertFalse(room.sleep());
        room.addBed(new Bed(length, width, Material.WOODEN));
        Assert.assertFalse(room.sleep());
        room.addBed(new Bed(length-1, width-1, Material.WOODEN));
        Assert.assertTrue(room.sleep());
        
        //test startAC()
        Assert.assertEquals(room.getBill(), 10*room.getVolume());
        room.startAC();
        Assert.assertEquals(room.getBill(), 15*room.getVolume());
        room.startAC();
        Assert.assertEquals(room.getBill(), 20*room.getVolume());

        
        //test getCost
       Assert.assertEquals(room.getSurfaceArea()*4 + 200, room.getCost());

    }
}
