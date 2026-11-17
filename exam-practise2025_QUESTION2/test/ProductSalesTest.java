import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales();
        int expected = 2; // 700 and 600 are over 500
        int actual = ps.GetSalesOverLimit();
        assertEquals(expected, actual);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales();
        int expected = 4; // 300, 150, 250, and 200 are under 500
        int actual = ps.GetSalesUnderLimit();
        assertEquals(expected, actual);
    }
}
