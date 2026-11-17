import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    private final int[][] productSales = {{300, 150, 700}, {250, 200, 600}};

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        ProductSales ps = new ProductSales();
        int expected = 2200;
        int actual = ps.TotalSales(productSales);
        assertEquals(expected, actual);
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        ProductSales ps = new ProductSales();
        double expected = 366.67;
        double actual = ps.AverageSales(productSales);
        assertEquals(expected, actual, 0.01);
    }
}