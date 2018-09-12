/**
 * This class is a general representation of a room.
 *
 * @author Shreyas Bhat
 */
public abstract class Room {

    /**
     * Length of the room
     */
    protected int roomLength;
    /**
     * Width of the room
     */
    protected int roomWidth;
    /**
     * Height of the room
     */
    protected int roomHeight;
    /**
     * Floor type of the room
     */
    protected FloorType type;

    /**
     * A room has a length, width, height and a floor type.
     * Initialize all fields of the class.
     *
     * @param roomLength Length of the room.
     * @param roomWidth  Width of the room.
     * @param roomHeight Height of the room.
     * @param type       Floortype of the room.
     */
    public Room(int roomLength, int roomWidth, int roomHeight, FloorType type) {
        this.roomLength = roomLength;
        this.roomWidth = roomWidth;
        this.roomHeight = roomHeight;
        this.type = type;
    }


    /**
     * Computes the volume of the room
     * <br>
     * <ul>
     * <li>Volume is computed as (roomLength * roomWidth * roomHeight). </li>
     * </ul>
     *
     * @return Volume of the room.
     */
    public int getVolume() {
        return (this.roomLength * this.roomWidth * this.roomHeight);
    }

    /**
     * Returns length of the room.
     *
     * @return Length roomLength
     */
    public int getRoomLength() {
        return roomLength;
    }

    /**
     * Returns width of the room.
     *
     * @return Width roomWidth
     */
    public int getRoomWidth() {
        return roomWidth;
    }

    /**
     * Returns height of the room.
     *
     * @return Height roomHeight
     */
    public int getRoomHeight() {
        return roomHeight;
    }

    /**
     * Computes the surface area of the room.
     * <br>
     * <ul>
     * <li>Surface Area is calculated as 2*(length * width + width * height + height * length). </li>
     * </ul>
     *
     * @return Surface area of the room.
     */
    public int getSurfaceArea() {
        return 2 * this.roomHeight * (this.roomLength + this.roomWidth) + 2 * this.roomLength * this.roomWidth;
    }

    /**
     * An abstract method that computes the room's bill.
     *
     * @return Bill for the room.
     */
    public abstract int getBill();

    /**
     * Computes cost of the room.
     *
     * @return Cost of room
     * <ul>
     * <li>Cost = SurfaceArea of Room * 4 if floor type is MARBLE</li>
     * <li>Cost = SurfaceArea of Room * 3 if floor type is WOODEN</li>
     * <li>Cost = SurfaceArea of Room * 2 if floor type is VINYL</li>
     * </ul>
     */
    public int getCost() {
        if (type == FloorType.MARBLE) {
            return this.getSurfaceArea() * 4;
        } else if (type == FloorType.WOODEN) {
            return this.getSurfaceArea() * 3;
        } else {
            return this.getSurfaceArea() * 2;
        }
    }

}