import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for getSurfaceArea for rooms, floor & building.
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class GetSurfaceAreaTest {

	private Building building;
	private Random rand;
	private Room room;
	private Washroom washroom;
	private Bedroom bedroom;
	private Livingroom livingroom;


	@Before
	public void before() {
		rand = new Random();
	}

	@After
	public void tearDown() {
		building = null;
		room = null;
		washroom = null;
		bedroom = null;
		livingroom = null;

	}
	// Tests getSurfaceArea()
	@Test
	public void getSurfaceAreaTest() {

		//create building
		int buildingWidth = rand.nextInt();
		int buildingLength = 100;
		building = new Building(buildingLength, buildingWidth);

		int roomLength = rand.nextInt(50);
		int roomWidth = rand.nextInt(50);
		int roomHeight = rand.nextInt(50);

		room = new Room(roomLength, roomWidth, roomHeight, FloorType.WOODEN ) {

			@Override
			public int getBill() {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		//test surface area for an abstract room.
		int sa = 2 * roomHeight * (roomLength + roomWidth) + 2 * roomLength * roomWidth;
		Assert.assertEquals(sa, room.getSurfaceArea());

		//for different types of rooms.
		washroom = new Washroom(roomLength, roomWidth, roomHeight, FloorType.MARBLE);
		Assert.assertEquals(sa, washroom.getSurfaceArea());

		livingroom = new Livingroom(roomLength, roomWidth, roomHeight, FloorType.VINYL);
		Assert.assertEquals(sa, livingroom.getSurfaceArea());

		bedroom = new Bedroom(roomLength, roomWidth, roomHeight, FloorType.WOODEN);
		Assert.assertEquals(sa, bedroom.getSurfaceArea());

		//test surface area for a floor.

		int floorHeight = rand.nextInt(20);
		Building.Floor floor = building.new Floor(floorHeight);

		Assert.assertEquals(floor.getSurfaceArea(), 2 * floorHeight * (buildingLength + buildingWidth) + 2 * buildingLength * buildingWidth);

		// test surface area for a building
		for(int i=0 ; i<5 ; i++)
			building.addFloor(floor);

		Assert.assertEquals(building.getSurfaceArea(), 2* building.getFloorCount()*floorHeight * (buildingLength +buildingWidth ) + 2 * buildingLength * buildingWidth);
	}

}
