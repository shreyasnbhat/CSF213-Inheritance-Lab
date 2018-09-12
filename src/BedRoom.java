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
     * To keep track whether the AC is on or not. True if AC is on else false.
     */
    private boolean acState;

    /**
     * To track whether the occupant is sleeping or not. True if occupant is asleep else false.
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
     * Set a bed for the room.
     *
     * If all the dimensions of the bed fit into the room (ignore the height of room) with ample space then assign bed for this bedroom. The dimensions of the bed must be strictly lesser than the room
     *
     * @param bed A Bed object
     * @return If bed added then return true,
     * otherwise return false.
     */
    public boolean setBed(Bed bed) {
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
     * <li>Otherwise if the occupant is already asleep then set sleepState to false
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
     * Return the sleep state of the bedroom
     *
     * @return sleepState
     */
    public boolean getSleepState() {
        return sleepState;
    }

    /**
     * @return Cost of bed  + cost of room.
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
     * Starts the AC. <br>
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
     * @return The electricity bill.
     */
    public int getBill() {
        return electricityBill;
    }
}
