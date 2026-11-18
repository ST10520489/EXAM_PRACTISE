import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstateAgentTest {

    EstateAgent agent = new EstateAgent();

    @Test
    public void CalculateCommission_CalculatedSuccessfully() {
        // Supply property price and agent commission percentage
        double expected = 86000.0;
        double actual = agent.CalculateCommission("4300000", "2");
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void CalculateCommission_CalculatedUnsuccessfully() {
        // Supply values to test that an incorrect expected value fails correctly
        double incorrectExpected = 90000.0;
        double actual = agent.CalculateCommission("4300000", "2");
        assertNotEquals(incorrectExpected, actual, 0.01);
    }

    @Test
    public void ValidationTest() {
        // Test that valid data returns true and invalid/empty data returns false
        Data validData = new Data("Cape Town", "Joe Bloggs", "4300000", "2");
        assertTrue(agent.ValidateData(validData));

        Data invalidData = new Data("", "Joe Bloggs", "0", "-5");
        assertFalse(agent.ValidateData(invalidData));
    }
}