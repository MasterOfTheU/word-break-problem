package testing;

import org.junit.Test;
import org.junit.Assert;
import wbpsolution.Metrics;

public class MetricsTest {
    @Test
    public void printMethodName() {
        String actualResult = Thread.currentThread().getStackTrace()[1].getMethodName();
        String expected = "printMethodName";
        Assert.assertEquals(expected, actualResult);
    }

    @Test
    public void gatherPerformance() {
        boolean result = Metrics.gatherPerformance();
        Assert.assertTrue(result);
    }

}