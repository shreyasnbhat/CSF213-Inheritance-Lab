import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for BedRoom Class
 *
 * @author Kunal Dewan, Shreyas Bhat
 * @version 12/9/2018
 */
public class BedRoomTest {

    private BedRoom room;
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
        room = new BedRoom(length, width, height, FloorType.MARBLE);

        //test getBill() when initialized
        Assert.assertEquals(0, room.getBill());

        // test Room Volume
        Assert.assertEquals(length * width * height, room.getVolume());

        //test addBed() & sleep() & startAc()
        Assert.assertFalse(room.sleep());
        Assert.assertFalse(room.getSleepState());

        room.setBed(new Bed(length, width, Material.WOODEN));
        Assert.assertFalse(room.sleep());
        Assert.assertFalse(room.getSleepState());
        Assert.assertEquals(0, room.getBill());

        // Bed Added
        room.setBed(new Bed(length - 1, width - 1, Material.WOODEN));
        Assert.assertTrue(room.sleep());
        Assert.assertTrue(room.getSleepState());
        Assert.assertEquals(10 * room.getVolume(), room.getBill());

        Assert.assertTrue(room.sleep());
        Assert.assertFalse(room.getSleepState());

        Assert.assertTrue(room.sleep());
        Assert.assertTrue(room.getSleepState());
        Assert.assertEquals(15 * room.getVolume(), room.getBill());

        // Test Wakeup
        room.wakeUp();
        Assert.assertFalse(room.getSleepState());

        //test getCost
        Assert.assertEquals(room.getSurfaceArea() * 4 + 200, room.getCost());

    }
}
