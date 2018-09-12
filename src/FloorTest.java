import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for Floor class's Constructor & addRoom()
 *
 * @author Kunal Dewan, Shreyas Bhat
 * @version 12/9/2018
 */
public class FloorTest {

    private Building building;
    private Random rand;
    private Room room;
    private WashRoom washroom;

    @Before
    public void before() {
        rand = new Random();

        room = new Room(1, 1, 1, FloorType.VINYL) {

            @Override
            public int getBill() {
                // TODO Auto-generated method stub
                return 0;
            }
        };
    }

    @After
    public void tearDown() {
        building = null;
        room = null;
        washroom = null;
    }

    // Tests constructor for the Floor class.
    @Test
    public void floorConstructorAndGetterTest() {

        int length = rand.nextInt(1000);
        int width = rand.nextInt(1000);
        building = new Building(length, width);

        // test getFloorHeight.int length = rand.nextInt();
        building = new Building(length, width);
        int floorHeight = rand.nextInt(1000);
        Building.Floor floor = building.new Floor(floorHeight);
        Assert.assertEquals(floorHeight, floor.getFloorHeight());
        Assert.assertEquals(length, floor.getFloorLength());
        Assert.assertEquals(floorHeight, floor.getFloorHeight());

        int sa = 2 * floorHeight * (length + width) + 2 * width * length;
        Assert.assertEquals(sa, floor.getSurfaceArea());

    }

    @Test
    public void testAddRoom() {

        // test addRoom()
        building = new Building(100, 100);
        Building.Floor floor = building.new Floor(100);

        // check addRoom() max cap 10.
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(floor.addRoom(room));
        }
        Assert.assertFalse(floor.addRoom(room));

        // check addRoom() when all rooms don't fit
        floor = building.new Floor(100);
        washroom = new WashRoom(11, 1, 1, FloorType.MARBLE);
        for (int i = 0; i < 9; i++) {
            Assert.assertTrue(floor.addRoom(washroom));
        }
        Assert.assertFalse(floor.addRoom(washroom));

        // Check if rooms are smaller than floor dimensions
        floor = building.new Floor(100);
        washroom = new WashRoom(11, 120, 1, FloorType.MARBLE);
        Assert.assertFalse(floor.addRoom(washroom));

        floor = building.new Floor(100);
        washroom = new WashRoom(11, 99, 120, FloorType.MARBLE);
        Assert.assertFalse(floor.addRoom(washroom));

        floor = building.new Floor(100);
        washroom = new WashRoom(11, 120, 120, FloorType.MARBLE);
        Assert.assertFalse(floor.addRoom(washroom));

    }


}
