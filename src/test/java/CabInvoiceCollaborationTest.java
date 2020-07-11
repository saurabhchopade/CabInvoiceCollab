import com.bridgelab.CabInvoiceCollaboration.service.InvoiceGenerator;
import com.bridgelab.CabInvoiceCollaboration.service.InvoiceSummary;
import com.bridgelab.CabInvoiceCollaboration.service.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceCollaborationTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void init() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0, 2);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

}
