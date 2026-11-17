import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MovieTicketsTest {

    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        // Arrange
        MovieTickets movieTickets = new MovieTickets();
        int numberOfTickets = 3;
        double ticketPrice = 100.0;
        double expected = 342.0;

        // Act
        double actual = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);

        // Assert
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void ValidationTests() {
        // Arrange
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData invalidData = new MovieTicketData("Napoleon", 3, 0);

        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);

        // Assert
        assertFalse(isValid);
    }
}