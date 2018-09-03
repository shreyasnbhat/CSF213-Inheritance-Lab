/**
 * An interface for common Building functionality.
 */
public interface IBuilding {

    /**
     * @return The function returns the cost of running the building.
     */
    int getOperatingCosts();

    /**
     * @return The function computes the surface area of the building.
     */
    int getSurfaceArea();
}
