import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Unit tests for Bed Class
 *
 * @author Shreyas Bhat
 * @version 3/9/2018
 */
public class BedTest {

    private Bed bed;
    private Random rand;

    @Before
    public void before() {
        rand = new Random();
    }


    @After
    public void tearDown() {
        bed = null;
    }

    /**
     * Tests Getters of the Bed
     */
    @Test
    public void testBedGetters() {
        int length = rand.nextInt();
        int width = rand.nextInt();

        bed = new Bed(length, width, Material.PLASTIC);

        Assert.assertEquals(length, bed.getLength());
        Assert.assertEquals(width, bed.getWidth());

    }

    @Test
    public void testBedCost() {
        bed = new Bed(10, 10, Material.PLASTIC);
        Assert.assertEquals(100, bed.getCost());

        bed = new Bed(10, 10, Material.STEEL);
        Assert.assertEquals(300, bed.getCost());

        bed = new Bed(10, 10, Material.WOODEN);
        Assert.assertEquals(200, bed.getCost());

        bed = new Bed(11, 11, Material.PLASTIC);
        Assert.assertEquals(100, bed.getCost());

        bed = new Bed(11, 11, Material.STEEL);
        Assert.assertEquals(300, bed.getCost());

        bed = new Bed(11, 11, Material.WOODEN);
        Assert.assertEquals(200, bed.getCost());
    }


}
