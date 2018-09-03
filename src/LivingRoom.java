/**
 *	This class simulates a livingroom. A boolean tvState is used to keep track whether the TV is on or not and an integer electricityBill is used.
 */
public class LivingRoom extends Room {

    private boolean tvState;
    private int electricityBill;

    /**
     * @param roomLength
     * @param roomWidth
     * @param roomHeight
     * @param type
     * Initializes default values for tvState & electricityBill and construct a room.
     */
    public LivingRoom(int roomLength, int roomWidth, int roomHeight, FloorType type) {
        super(roomLength, roomWidth, roomHeight, type);
        this.tvState = false;
        this.electricityBill = 0;
    }
    
    /**
     *  If the tv is already on, then increment electricity bill by 5.
     *  otherwise switch on the tv and increment the electricity bill by 10.
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
     * @return electricity bill for a livingroom
     */
    public int getBill() {
        return electricityBill;
    }

}
