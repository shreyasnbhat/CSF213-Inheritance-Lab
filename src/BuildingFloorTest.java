import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for Building Class's addFloor() & getFloorCount().
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class BuildingFloorTest {

    private Building building;
    private Random rand;


    @Before
    public void before() {
        rand = new Random();
        int length = rand.nextInt();
        int width = rand.nextInt();
        building = new Building(length, width);
    }

    @After
    public void tearDown() {
        building = null;
    }

    // Tests getFloorCount()
    @Test
    public void getFloorCountTest() {

        for (int i = 0; i < 5; i++) {
            building.addFloor(building.new Floor(1));
            Assert.assertEquals(i + 1, building.getFloorCount());
        }
        Assert.assertEquals(5, building.getFloorCount());
    }

    @Test
    public void addFloorMaxTest() {
        for (int i = 0; i < 15; i++)
            building.addFloor(building.new Floor(1));
        Assert.assertEquals(10, building.getFloorCount());
    }
}
