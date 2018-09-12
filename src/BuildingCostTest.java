import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for getCost & getOperationalCost for a building.
 *
 * @author Kunal Dewan
 * @version 12/9/2018
 */
public class BuildingCostTest {

	private int buildingLength = 100, buildingWidth = 100;
	private int OpResult = 15033;
	private int costResult = 4510;
	private Building building;
	private Washroom washroom;
	private Bedroom bedroom;
	private Livingroom livingroom;


	@Before
	public void before() {
		building = new Building(buildingLength, buildingWidth);

	}

	@After
	public void tearDown() {
		building = null;
		washroom = null;
		bedroom = null;
		livingroom = null;

	}
	// Tests getCost()
	@Test
	public void getCostTest() {

		//create building
	

		Building.Floor floor1 = building.new Floor(10);
		Building.Floor floor2 = building.new Floor(10);

		//add rooms to each floor.
		livingroom = new Livingroom(10, 10, 10, FloorType.WOODEN);
		bedroom = new Bedroom(10,10,10, FloorType.MARBLE);
		washroom = new Washroom(10,10,10, FloorType.VINYL);

		bedroom.addBed(new Bed(1, 1, Material.STEEL));
		floor1.addRoom(washroom);
		floor2.addRoom(livingroom);
		floor2.addRoom(bedroom);

		//add floors to the building.
		building.addFloor(floor1);
		building.addFloor(floor2);

		//verify getCost.	
		Assert.assertEquals(building.getCost(), costResult);
	}
	
	@Test
	public void getOperatingCostTest() {
		Building.Floor floor1 = building.new Floor(10);
		Building.Floor floor2 = building.new Floor(10);

		//add rooms to each floor.
		livingroom = new Livingroom(10, 10, 10, FloorType.WOODEN);
		bedroom = new Bedroom(10,10,10, FloorType.MARBLE);
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
		Assert.assertEquals(building.getOperatingCosts(), OpResult);
	}


}
