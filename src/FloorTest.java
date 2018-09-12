import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Floor class's Constructor & addRoom()
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class FloorTest {

	private Building building;
	private Random rand;
	private Room room;
	private Washroom washroom;

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
		room = null;
		washroom = null;
	}
	// Tests constructor for the Floor class.
	@Test
	public void constructorFloorTest() {

		// test getFloorHeight.
		int floorheight = rand.nextInt();
		Building.Floor floor = building.new Floor(floorheight);
		Assert.assertEquals(floorheight, floor.getFloorHeight());
	}

	@Test
	public void testAddRoom() {

		// test addRoom()
		int floorheight = rand.nextInt();
		building = new Building(100, 100);
		Building.Floor floor = building.new Floor(floorheight);
		room = new Room(1,1,1,FloorType.VINYL) {

			@Override
			public int getBill() {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		//check addRoom() max cap 10.
		for(int i=0 ; i<10 ; i++) {
			Assert.assertTrue(floor.addRoom(room));
		}
		Assert.assertFalse(floor.addRoom(room));
		
		//check addRoom() when all rooms don't fit
		floor = building.new Floor(floorheight);
		washroom = new Washroom(11,1,1,FloorType.MARBLE);
		for(int i=0 ; i<9 ; i++) {
			Assert.assertTrue(floor.addRoom(washroom));
		}
		Assert.assertFalse(floor.addRoom(washroom));

	}


}
