import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for LivingRoom Class
 *
 * @author Kunal Dewan, Shreyas Bhat
 * @version 12/9/2018
 */
public class LivingRoomTest {

    private LivingRoom room;
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
    public void testLivingRoomGetters() {

        int length = rand.nextInt();
        int width = rand.nextInt();
        int height = rand.nextInt();
        room = new LivingRoom(length, width, height, FloorType.MARBLE);

        //test getBill() when initialized
        Assert.assertEquals(0, room.getBill());
        Assert.assertFalse(room.getTvState());

        room.watchTV();

        Assert.assertTrue(room.getTvState());
        Assert.assertEquals(10, room.getBill());

        room.watchTV();
        Assert.assertTrue(room.getTvState());

        Assert.assertEquals(15, room.getBill());

        room.watchTV();
        Assert.assertTrue(room.getTvState());

        Assert.assertEquals(20, room.getBill());


    }
}
