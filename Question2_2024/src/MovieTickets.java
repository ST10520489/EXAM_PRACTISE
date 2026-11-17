public class MovieTickets implements IMovieTickets {

    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subtotal = numberOfTickets * ticketPrice;
        double vat = subtotal * 0.14;
        return subtotal + vat;
    }

    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        if (movieTicketData == null) {
            return false;
        }
        // 1. Movie Ticket Name cannot be empty
        if (movieTicketData.getMovieName() == null || movieTicketData.getMovieName().trim().isEmpty()) {
            return false;
        }
        // 2. Movie Ticket Price cannot be less than or equal to zero (0)
        if (movieTicketData.getTicketPrice() <= 0) {
            return false;
        }
        // 3. Number of Movie Tickets cannot be less than or equal to zero (0)
        if (movieTicketData.getNumberOfTickets() <= 0) {
            return false;
        }
        return true;
    }
}