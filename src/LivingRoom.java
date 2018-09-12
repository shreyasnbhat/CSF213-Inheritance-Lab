/**
 *	This class simulates a Living Room. A boolean tvState is used to keep track whether the TV is on or not and an integer electricityBill is used.
 * @author Shreyas Bhat
 */
public class LivingRoom extends Room {


    /**
     * A boolean to keep track whether the TV is on or not.
     * Set to True if on.
     */
    private boolean tvState;
    
    /**
     * Stores the electricity bill for the livingroom.
     */
    private int electricityBill;

    /**
     * Initialize all fields of the class.
     * <ul>
     * <li> Set electricityBill as 0 </li>
     * <li> Set tvState as false </li>
     * </ul>
     * @param roomLength Length of the livingroom.
     * @param roomWidth Width of the livingroom.
     * @param roomHeight Height of the livingroom.
     * @param type FloorType of the livingroom.
     */
    public LivingRoom(int roomLength, int roomWidth, int roomHeight, FloorType type) {
        super(roomLength, roomWidth, roomHeight, type);
        this.tvState = false;
        this.electricityBill = 0;
    }
    
    /**
     *  Simulates watching TV. <br>
     *  <ul>
     *  <li>If the TV is already on, then increment electricity bill by 5. </li>
     *  <li>Otherwise switch on the TV and increment the electricity bill by 10. </li>
     * </ul>
     */
    public void watchTV() {
        if (!this.tvState) {
            this.tvState = true;
            this.electricityBill += 10;
        } else {
            this.electricityBill += 5;
        }
    }

    /**
     * @return Electricity bill for a Living Room.
     */
    public int getBill() {
        return electricityBill;
    }

}
