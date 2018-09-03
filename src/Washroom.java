/**
 *	This class simulates a washroom.
 */

public class Washroom extends Room {

	/**
	 * To keep track of the waterbill of the washroom.
	 */
    private int waterBill;

    /**
     * @param roomLength
     * @param roomWidth
     * @param roomHeight
     * @param floortype
     * Initializes default value for waterBill & construct a room.
     */
    public Washroom(int roomLength, int roomWidth, int roomHeight, FloorType type) {
        super(roomLength, roomWidth, roomHeight, type);
        this.waterBill = 0;
    }
    /**
     * @returns returns the waterbill for a washroom. 
     */
    public int getBill() {
        return waterBill;
    }

    /**
     * @returns For a washroom : if floortype is VINYL, then returns 10, else returns 20.
     */
    public int getCost() {
        if (type == FloorType.VINYL) {
            return 10;
        } else {
            return 20;
        }
    }

    /**
     * Important to flush after use! Increments the waterbill by 10 followed by a handwash.
     */
    public void flush() {
        this.waterBill += 10;
        this.handWash();
    }

    /**
     * Keeps your hands clean. Increments the waterbill by 2.
     */
    public void handWash() {
        this.waterBill += 2;
    }

    /**
     * Makes your teeth shine bright.
     * Increments the waterbill by 4.
     */
    public void brushTeeth() {
        this.waterBill += 4;
    }
}
