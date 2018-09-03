/**
 *	This class simulates a bedroom.
 *
 */
public class BedRoom extends Room {

	/**
	 * Bed for the room.
	 */
	private Bed bed;

	/**
	 * To keep track whether the AC is on or not
	 */
	private boolean acState;

	/**
	 * To track whether the occupant is sleeping or not. 
	 */
	private boolean sleepState;
	
	/**
	 * To keep track of the bill for the room.
	 */
	private int electricityBill;

	
	/**
	 * @param roomLength
	 * @param roomWidth
	 * @param roomHeight
	 * @param type
	 * Initialize default values for electricityBill, sleepState & acState and construct a room.
	 */
	public BedRoom(int roomLength, int roomWidth, int roomHeight, FloorType type) {
		super(roomLength, roomWidth, roomHeight, type);
		this.electricityBill = 0;
		this.sleepState = false;
		this.acState = false;
	}

	/**
	 * @param bed
	 * 		A Bed object
	 * @return If all the dimensions of the bed fit into the room (ignore the height) with ample space then add this bed to the room & return true.
	 *                  otherwise return false.
	 */
	public boolean addBed(Bed bed) {
		if (bed.getLength() < this.roomLength && bed.getWidth() < this.roomWidth) {
			this.bed = bed;
			return true;
		} else {
			return false;
		}
	}

	// If sleep state is 0 then start AC and revert sleep state
	/** If there is a bed in the room and If the occupant is awake, then start the AC and go to sleep
	 *  otherwise if the occupant is already asleep then toggle the sleep state. 
	 * 
	 * @return return true if successfully slept.
	 */
	public boolean sleep() {
		if (bed != null) {
			if (!sleepState)
				startAC();
			sleepState = !sleepState;
			return true;
		} else {
			return false;
		}
	}

	/**
	 *  @return For a bedroom : returns cost of bed  + cost of room.
	 */
	@Override
	public int getCost() {
		return super.getCost() + this.bed.getCost();
	}

	/**
	 * Resets the sleepState to default value (false).
	 */
	public void wakeUp() {
		this.sleepState = false;
	}

	/**
	 * 	If the AC is off , turn it on and increment the electricity by 10 * volume of the room.
	 * Otherwise increment the electricity bill by 5 * volume of the room.
	 */
	public void startAC() {
		if (!acState) {
			this.acState = true;
			this.electricityBill += 10 * this.getVolume();
		} else {
			this.electricityBill += 5 * this.getVolume();
		}
	}

	/**
	 * @return For Bedroom : returns the electricity bill.
	 */
	public int getBill() {
		return electricityBill;
	}
}
