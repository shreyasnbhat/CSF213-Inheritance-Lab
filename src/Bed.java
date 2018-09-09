/**
 * A simple representation of a bed.
 * Implements the IChargeable interface.
 * @author Shreyas Bhat, Kunal Dewan
 * @version 1
 * 
 */
public class Bed implements IChargeable{
	

    /**
     * Length of the bed.
     */
    private int length;

    /**
     * Width of the bed.
     */
    private int width;

    /**
     * The material used to build the bed.
     */
    private Material material;

    /**
     * Initialize all fields of the class.
     * @param length Length of the bed.
     * @param width Width of the bed.
     * @param material Material of the bed.
     */
    
    public Bed(int length, int width, Material material) {
        this.length = length;
        this.width = width;
        this.material = material;
    }


    /**
     * Returns length of the bed.
     * @return Returns length of the bed.
     */
    public int getLength() {
        return length;
    }

    /**
     * Return width of the bed.
     * @return Returns width of the bed.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Cost of the bed depends upon the material used for building it.
     * <ul>
     *    <li>If the material is Wooden, then the cost is 200.</li>
     *    <li>If the material is Steel, then the cost is 300.</li>
     *    <li>If the material is Plastic, then the cost is 100.</li>
     * </ul>
     * @return The cost of building the bed.
     */
    public int getCost() {
        if (material == Material.WOODEN)
            return 200;
        else if (material == Material.STEEL)
            return 300;
        else
            return 100;
    }
}
