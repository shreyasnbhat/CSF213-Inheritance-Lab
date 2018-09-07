/**
 *	This class simulates a washroom.
 */

public class Washroom extends Room {

	/**
	 * To keep track of the waterbill of the washroom.
	 */
    private int waterBill;

    /**
     * Initialize all fields of the class.
     * <ul>
     * <li> Set waterBill as 0 </li>
     * </ul>
     * 
     * @param roomLength Length of the washroom.
     * @param roomWidth Width of the washroom.
     * @param roomHeight Height of the washroom.
     * @param type FloorType of the washroom.
     * 
     */
    public Washroom(int roomLength, int roomWidth, int roomHeight, FloorType type) {
        super(roomLength, roomWidth, roomHeight, type);
        this.waterBill = 0;
    }
    /**
     * @return Return the waterbill for a washroom. 
     */
    public int getBill() {
        return waterBill;
    }

    /**
     * @return For a washroom : if floortype is VINYL, then returns 10, else returns 20.
     */
    public int getCost() {
        if (type == FloorType.VINYL) {
            return 10;
        } else {
            return 20;
        }
    }

    /**
     * Important to flush after use.
     * <ul>
     * <li>Increments the waterbill by 10 followed by a handwash. </li>
     * </ul>
     */
    public void flush() {
        this.waterBill += 10;
        this.handWash();
    }

    /**
     * Keeps your hands clean. 
     * <ul>
     * <li>Increments the waterbill by 2.</li>
     * </ul>
     */
    public void handWash() {
        this.waterBill += 2;
    }

    /**
     * Makes your teeth shine bright.
     * <ul>
     * <li> Increments the waterbill by 4. </li>
     * </ul>
     */
    public void brushTeeth() {
        this.waterBill += 4;
    }
}
