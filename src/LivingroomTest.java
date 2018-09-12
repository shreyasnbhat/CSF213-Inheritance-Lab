import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Livingroom Class
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class LivingroomTest {

    private Livingroom room;
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
    public void testLivingroomGetters() {
    	
        int length = rand.nextInt();
        int width = rand.nextInt();
        int height = rand.nextInt();
        room = new Livingroom(length, width, height, FloorType.MARBLE);
        
        //test getBill() when initialized
        Assert.assertEquals(0, room.getBill());
        
        room.watchTV();
        
        Assert.assertEquals(10, room.getBill());
        room.watchTV();
        Assert.assertEquals(15, room.getBill());
        room.watchTV();
        Assert.assertEquals(20, room.getBill());


    }
}
