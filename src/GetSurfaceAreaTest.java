import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for getSurfaceArea for rooms, floor & building.
 *
 * @author Kunal Dewan, Shreyas Bhat
 * @version 12/9/2018
 */
public class GetSurfaceAreaTest {

    private Building building;
    private Random rand;


    @Before
    public void before() {
        rand = new Random();
    }

    @After
    public void tearDown() {
        building = null;
    }

    // Tests getSurfaceArea()
    @Test
    public void getSurfaceAreaTest() {

        //create building
        int buildingWidth = rand.nextInt(100) + 5;
        int buildingLength = rand.nextInt(100) + 5;
        building = new Building(buildingLength, buildingWidth);

        //test surface area for a floor.

        int floorHeight = rand.nextInt(20) + 5;
        Building.Floor floor = building.new Floor(floorHeight);

        Assert.assertEquals(2 * floorHeight * (buildingLength + buildingWidth) + 2 * buildingLength * buildingWidth, floor.getSurfaceArea());

        // test surface area for a building
        for (int i = 0; i < 5; i++)
            building.addFloor(floor);

        Assert.assertEquals(2 * building.getFloorCount() * floorHeight * (buildingLength + buildingWidth) + 2 * buildingLength * buildingWidth, building.getSurfaceArea());
    }

}
