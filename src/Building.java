/**
 * This class simulates a Building.
 * Implements the IBuilding and IChargeable interface.
 */
public class Building implements IBuilding, IChargeable {

    /**
     * Length of the building.
     */
    private int length;
    /**
     * Width of the building.
     */
    private int width;
    /**
     * Height of the building.
     */
    private int height;
    /**
     * An array of floors to store all floors in a building.
     */
    private Floor floors[];
    /**
     * The number of floors in the building.
     */
    private int floorCount;
    /**
     * The maximum number of floor in the building.
     */
    static int maxFloors = 10;

    /**
     * Initialize all fields of the class.
     * <ul>
     * <li> Set height as 0 </li>
     * <li> Set floorCount as 0 </li>
     * </ul>
     *
     * @param length Length of the building.
     * @param width  Width of the building.
     */
    public Building(int length, int width) {
        this.length = length;
        this.width = width;
        this.height = 0;
        this.floorCount = 0;
        this.floors = new Floor[maxFloors];
    }

    /**
     * An inner class that represents a floor of a building.
     */
    public class Floor implements IChargeable {

        /**
         * An array of Rooms to store all rooms in a floor.
         */
        private Room rooms[];
        /**
         * Stores the floor number.
         */
        private int floorNumber;
        /**
         * Maximum number of rooms in the floor.
         */
        private int maxRoomCount;
        /**
         * Length of the floor.
         */
        private int floorLength;
        /**
         * Width of the floor.
         */
        private int floorWidth;
        /**
         * Height of the floor.
         */
        private int floorHeight;
        /**
         * Number of rooms in the floor currently.
         */
        private int roomCount;
        /**
         * Free space left in the floor for more rooms
         */
        private int freeSpaceLeftForRoom;


        /**
         * @return Height of the floor.
         */
        public int getFloorHeight() {
            return floorHeight;
        }


        /**
         * Constructor to initialize fields. All rooms in the floor have the same width and height, the length may vary.
         * <ul>
         * <li>Initialize <strong>maxRoomCount</strong> as 10</li>
         * <li>Set floorLength as the length of the building</li>
         * <li>Set floorWidth as the length of the building</li>
         * <li>Initialize roomCount to 0</li>
         * <li>Initialize freeSpaceLeftForRoom to length of the floor</li>
         * </ul>
         *
         * @param height <br>
         */
        public Floor(int height) {
            this.maxRoomCount = 10;
            this.rooms = new Room[this.maxRoomCount];
            this.floorLength = Building.this.length;
            this.floorWidth = Building.this.width;
            this.floorHeight = height;
            this.floorNumber = Building.this.floorCount;
            this.roomCount = 0;
            this.freeSpaceLeftForRoom = Building.this.length;
        }

        /**
         * Computes the surface area of the floor.
         * <br>
         * Surface Area is calculated as 2 * ( length * width + width * height + height * length )
         * @return Return surface area of the building.
         */
        public int getSurfaceArea() {
            return 2 * this.floorHeight * (this.floorLength + this.floorWidth) + 2 * this.floorLength * this.floorWidth;
        }

        /**
         * If more rooms can be added then add the room to this floor, update free space and room count and return true.
         * A room might not be added due to any of the below reasons
         * <ul>
         * <li>roomLength is greater than freeSpaceLeftForRoom</li>
         * <li>roomCount = maxRoomCount</li>
         * </ul>
         *
         * @param room Room object to be added to the floor
         * @return true if room was added successfully, else return false.
         */
        public boolean addRoom(Room room) {
            if (this.roomCount == this.maxRoomCount)
                return false;
            else if (room.getRoomLength() <= this.freeSpaceLeftForRoom) {
                this.rooms[this.roomCount++] = room;
                this.freeSpaceLeftForRoom -= room.getRoomLength();
                return true;
            } else {
                return false;
            }
        }

        /**
         * Cost is calculated as the summation of the cost of all rooms in the floor.
         * @return Cost of the floor
         */
        public int getCost() {
            int cost = 0;
            for (int i = 0; i < roomCount; i++) {
                cost += this.rooms[i].getCost();
            }
            return cost;
        }

        /**
         * Operating Cost is calculated as the summation of the bill of all rooms in the floor.
         * @return Operating cost of the floor
         */
        public int getOperatingCost() {
            int operatingCosts = 0;
            for (int i = 0; i < this.roomCount; i++) {
                operatingCosts += this.rooms[i].getBill();
            }

            return operatingCosts;
        }


    }  // end floor class.

    /**
     * 
     * Adds a floor to a building if floorCount is less than maxFloors. 
     * <ul>
     * <li> floorCount gets incremented. </li>
     * <li> height gets updated.</li>
     * </ul>
     *
     * @param floor A floor object
     */
    public void addFloor(Floor floor) {
        if (this.floorCount < maxFloors) {
            this.floors[this.floorCount++] = floor;
            this.height += floor.getFloorHeight();
        }
    }

    /**
     *   Returns number of floors in the building.
     * @return Number of floors in the building.
     */
    public int getFloorCount() {
        return floorCount;
    }

    /**
     * Returns cost for the building
     *
     * @return Sum of cost of all floors.
     */
    public int getCost() {
        int cost = 0;
        for (int i = 0; i < floorCount; i++) {
            cost += this.floors[i].getCost();
        }
        return cost;
    }

    /**
     * Returns operating cost for the building
     *
     * @return Sum of operating cost of all floors.
     */
    @Override
    public int getOperatingCosts() {
        int operatingCost = 0;
        for (int i = 0; i < this.floorCount; i++) {
            operatingCost += floors[i].getOperatingCost();
        }
        return operatingCost;
    }

    /**
     * Calculates and returns surface area of the building.
     * @return Returns surface area of the building.
     * Use the formula 2 * h * ( l + b ) + 2 * l * b.
     * where h, l, b represent height, length and width of the building respectively.
     */
    @Override
    public int getSurfaceArea() {
        return 2 * this.height * (this.length + this.width) + 2 * this.length * this.width;
    }
}
