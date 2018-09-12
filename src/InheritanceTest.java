import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * Unit tests for 'Inheritance' Lab Question.
 * @author Kunal Dewan
 * @version 3/9/2018
 *
 */
public class InheritanceTest {

	private Building building;
	private int buildingLength = 100, buildingWidth = 100;
	private BedRoom bedroom;
	private Washroom washroom;
	private LivingRoom livingroom;

	@Before
	public void init() { 
		building = new Building(buildingLength, buildingWidth);
	}

	@After
	public void tearDown() {
		building = null;
		bedroom = null;
		washroom = null;
		livingroom = null;
	}



	/** 
	 * Tests getFloorCount Method for a building.
	 */
	@Test
	public void getFloorCountTest() {
		for (int i = 0; i < 5; i++) {
			building.addFloor(building.new Floor(100));
            Assert.assertEquals(i+1, building.getFloorCount());
        }
		Assert.assertEquals(5, building.getFloorCount());
	}

	/** 
	 * Tests max bound on addFloor Method for a building.
	 */
	@Test
	public void addFloorMaxTest() {
		for (int i = 0; i < 15 ; i++) 
			building.addFloor(building.new Floor(100));
		Assert.assertEquals(10, building.getFloorCount());
	}
	/**
	 * Tests addRoom Method for a floor .
	 */
	@Test 
	public void addRoomTest() {
		Building.Floor floor = building.new Floor(50);
		// attempt over max bound.
		Room room = new Room(1,1,1,FloorType.MARBLE) {
			@Override
			public int getBill() {
				return 0;
			}
		};
		Assert.assertTrue(floor.addRoom(room));
		for(int i=0 ; i<15 ; i++) {
			floor.addRoom(room);
		}
		Assert.assertFalse(floor.addRoom(room));
	}

	/**
	 * Tests getters of Floor and Building.
	 * 
	 */
	@Test
	public void buildingGettersTest() {
		Building.Floor floor1 = building.new Floor(10);
		Building.Floor floor2 = building.new Floor(20);

		//getFloorCount
		Assert.assertEquals(building.getFloorCount(), 0);
		building.addFloor(floor1);
		building.addFloor(floor2);
		Assert.assertEquals(building.getFloorCount(), 2);

		//getFloorHeight
		Assert.assertEquals(floor2.getFloorHeight(), 20);

		//getSurfaceArea
		Assert.assertEquals(floor1.getSurfaceArea(), 24000);
	}

	/**
	 * Tests getters for Room.
	 * 
	 */
	@Test
	public void roomGettersTest() {
		livingroom = new LivingRoom(5, 10, 1, FloorType.WOODEN);
		bedroom = new BedRoom(5,10,1, FloorType.MARBLE);
		washroom = new Washroom(5,10,1, FloorType.VINYL);
		//getSurfaceArea
		Assert.assertEquals(livingroom.getSurfaceArea(), 130);
		//getVolume
		Assert.assertEquals(bedroom.getVolume(), 50);
		//getRoomLength
		Assert.assertEquals(washroom.getRoomLength(), 5);
	}
	/**
	 * Tests getCost method for a building.
	 * 
	 */
	@Test
	public void getCostBuildingTest() {
		Building.Floor floor1 = building.new Floor(10);
		Building.Floor floor2 = building.new Floor(10);

		//add rooms to each floor.
		livingroom = new LivingRoom(10, 10, 10, FloorType.WOODEN);
		bedroom = new BedRoom(10,10,10, FloorType.MARBLE);
		washroom = new Washroom(10,10,10, FloorType.VINYL);

		bedroom.addBed(new Bed(1, 1, Material.STEEL));
		floor1.addRoom(washroom);
		floor2.addRoom(livingroom);
		floor2.addRoom(bedroom);

		//add floors to the building.
		building.addFloor(floor1);
		building.addFloor(floor2);

		//verify getCost.	
		Assert.assertEquals(building.getCost(), 4510);
	}

	/**
	 * Tests getOperatingCost method for a building.
	 * 
	 */
	@Test
	public void getOperatingCostTest() {
		Building.Floor floor1 = building.new Floor(10);
		Building.Floor floor2 = building.new Floor(10);

		//add rooms to each floor.
		livingroom = new LivingRoom(10, 10, 10, FloorType.WOODEN);
		bedroom = new BedRoom(10,10,10, FloorType.MARBLE);
		washroom = new Washroom(10,10,10, FloorType.VINYL);

		bedroom.addBed(new Bed(1, 1, Material.STEEL));


		floor1.addRoom(washroom);
		floor2.addRoom(livingroom);
		floor2.addRoom(bedroom);

		bedroom.sleep();
		bedroom.wakeUp();
		bedroom.sleep();
		livingroom.watchTV();
		livingroom.watchTV();
		washroom.brushTeeth();
		washroom.flush();
		washroom.handWash();
		//add floors to the building.
		building.addFloor(floor1);
		building.addFloor(floor2);


		//verify operatingCost
		Assert.assertEquals(building.getOperatingCosts(), 15033);
	}

	/**
	 * Tests getOperatingCost method for a building.
	 * 
	 */
	@Test
	public void bedroomSleepTest() {
		Building.Floor floor1 = building.new Floor(10);
		bedroom = new BedRoom(10,10,10, FloorType.MARBLE);

		floor1.addRoom(bedroom);

		//sleep without bed
		Assert.assertFalse(bedroom.sleep());

		bedroom.addBed(new Bed(1, 1, Material.STEEL));
		Assert.assertTrue(bedroom.sleep());

	}
	
	/**
	 * Tests addBed Method for a bedroom.
	 * 
	 */
	@Test
	public void addBedTest() {
		bedroom = new BedRoom(10,10,10, FloorType.MARBLE);
		
		//bed dimensions test.
		Assert.assertFalse(bedroom.addBed(new Bed(10, 10, Material.WOODEN)));
		Assert.assertTrue(bedroom.addBed(new Bed(5, 5, Material.WOODEN)));
	}

}
