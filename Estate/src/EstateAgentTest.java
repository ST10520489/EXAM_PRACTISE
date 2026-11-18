import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstateAgentTest {

    // Instantiate the class containing your calculation methods
    EstateAgent agent = new EstateAgent();

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Arrange: Supply Joe Bloggs' Jan, Feb, Mar property sales
        double[] propertySales = {800000, 1500000, 2000000};
        double expectedTotal = 4300000;

        // Act
        double actualTotal = agent.EstateAgentSales(propertySales);

        // Assert
        assertEquals(expectedTotal, actualTotal, 0.01);
    }

    @Test
    public void CalculateTotalCommission_ReturnsCommission() {
        // Arrange: Supply total property sales (2% of 4,300,000 = 86,000)
        double totalSales = 4300000;
        double expectedCommission = 86000;

        // Act
        double actualCommission = agent.EstateAgentCommission(totalSales);

        // Assert
        assertEquals(expectedCommission, actualCommission, 0.01);
    }

    @Test
    public void TopAgent_ReturnsTopPosition() {
        // Arrange: Total sales for Joe Bloggs (index 0) and Jane Doe (index 1)
        double[] totalSales = {4300000, 3500000};
        int expectedTopPosition = 0; // Index 0 represents the top-selling agent

        // Act
        int actualTopPosition = agent.TopEstateAgent(totalSales);

        // Assert
        assertEquals(expectedTopPosition, actualTopPosition);
    }
}