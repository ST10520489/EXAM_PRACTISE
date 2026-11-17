import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTicketsTest {

    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales() {
        // Arrange
        MovieTickets movieTickets = new MovieTickets();
        int[] sales = {3000, 1500, 1700};
        int expected = 6200;

        // Act
        int actual = movieTickets.TotalMovieSales(sales);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void TopMovieSales_ReturnsTopMovie() {
        // Arrange
        MovieTickets movieTickets = new MovieTickets();
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};
        String expected = "Oppenheimer";

        // Act
        String actual = movieTickets.TopMovie(movies, totalSales);

        // Assert
        assertEquals(expected, actual);
    }
}