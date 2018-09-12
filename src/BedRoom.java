/**
 * This class simulates a bedroom.
 *
 * @author Shreyas Bhat
 */
public class BedRoom extends Room {

    /**
     * Bed for the room.
     */
    private Bed bed;

    /**
     * To keep track whether the AC is on or not.
     */
    private boolean acState;

    /**
     * To track whether the occupant is sleeping or not.
     */
    private boolean sleepState;

    /**
     * To keep track of the electricity bill for the bedroom.
     */
    private int electricityBill;


    /**
     * Initialize all fields of the class.
     * <ul>
     * <li> Set electricityBill as 0. </li>
     * <li> Set default values for sleepState and acState as false. </li>
     * </ul>
     *
     * @param roomLength Length of the bedroom.
     * @param roomWidth  Width of the bedroom.
     * @param roomHeight Height of the bedroom.
     * @param type       FloorType of the bedroom.
     */
    public BedRoom(int roomLength, int roomWidth, int roomHeight, FloorType type) {
        super(roomLength, roomWidth, roomHeight, type);
        this.electricityBill = 0;
        this.sleepState = false;
        this.acState = false;
    }

    /**
     * If all the dimensions of the bed fit into the room (ignore the height of room) with ample space then assign bed for this bedroom.
     *
     * @param bed A Bed object
     * @return If bed added then return true,
     * otherwise return false.
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

    /**
     * Simulates sleep in the occupant's life. <br>
     * <ul>
     * <li>If there is a bed in the room and If the occupant is awake, then start the AC and go to sleep.
     * <li>Otherwise if the occupant is already asleep then toggle the sleep state.
     * </ul>
     *
     * @return True if successfully slept.
     * False otherwise ( when one can't afford a bed.. ).
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
     * @return For a bedroom : return cost of bed  + cost of room.
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
     * <ul>
     * <li>If the AC is off , turn it on and increment the electricity by 10 * volume of the room. </li>
     * <li>Otherwise increment the electricity bill by 5 * volume of the room. </li>
     * </ul>
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
