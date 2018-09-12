import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Washroom Class
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class WashroomTest {

    private Washroom room;
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
    public void testWashroomGetters() {
    	
        int length = rand.nextInt();
        int width = rand.nextInt();
        int height = rand.nextInt();
        room = new Washroom(length, width, height, FloorType.MARBLE);
        //test getBill() when initialized
        Assert.assertEquals(0, room.getBill());
        
        //test getCost
        Assert.assertEquals(20, room.getCost());
        room = new Washroom(length, width, height, FloorType.VINYL);
        Assert.assertEquals(10, room.getCost());
        
        //test getBill()
        room.brushTeeth();
        Assert.assertEquals(4, room.getBill());
        room.handWash();
        Assert.assertEquals(6, room.getBill());
        room.flush();
        Assert.assertEquals(18, room.getBill());
        
        
        

    }
}
