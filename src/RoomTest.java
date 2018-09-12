import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for Room Class
 *
 * @author Shreyas Bhat
 * @version 3/9/2018
 */
public class RoomTest {

    private Room room;
    private Random rand;

    @Before
    public void before() {
        rand = new Random();
    }


    @After
    public void tearDown() {
        room = null;
    }


    public void generateRoom(FloorType type) {
        int length = rand.nextInt();
        int width = rand.nextInt();
        int height = rand.nextInt();


        room = new Room(length, width, height, type) {

            @Override
            public int getBill() {
                return 10;
            }
        };

    }


    /**
     * Tests Getters of the Room
     */
    @Test
    public void testBedGetters() {

        int length = rand.nextInt();
        int width = rand.nextInt();
        int height = rand.nextInt();

        room = new Room(length, width, height, FloorType.MARBLE) {

            @Override
            public int getBill() {
                return 10;
            }
        };

        Assert.assertEquals(height * length * width, room.getVolume());

        int sa = 2 * height * (length + width) + 2 * length * width;
        Assert.assertEquals(sa, room.getSurfaceArea());

        Assert.assertEquals(length, room.getRoomLength());

        Assert.assertEquals(10, room.getBill());
    }

    @Test
    public void testRoomCost() {

        generateRoom(FloorType.MARBLE);
        Assert.assertEquals(room.getSurfaceArea() * 4, room.getCost());

        generateRoom(FloorType.WOODEN);
        Assert.assertEquals(room.getSurfaceArea() * 3, room.getCost());

        generateRoom(FloorType.VINYL);
        Assert.assertEquals(room.getSurfaceArea() * 2, room.getCost());

        int length = rand.nextInt();
        int width = rand.nextInt();
        int height = rand.nextInt();

        room = new Room(length, width, height, FloorType.VINYL) {

            @Override
            public int getBill() {
                return 20;
            }
        };

        int sa = 2 * height * (length + width) + 2 * length * width;
        Assert.assertEquals(sa * 2, room.getCost());

    }


}
