public class MovieTickets implements IMovieTickets {
        @Override
        public int TotalMovieSales(int[] movieTicketSales) {
            int total = 0;
            if (movieTicketSales != null) {
                // Traditional index-based for loop
                for (int i = 0; i < movieTicketSales.length; i++) {
                    total += movieTicketSales[i];
                }
            }
            return total;
        }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int maxSales = totalSales[0];
        int maxIndex = 0;

        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                maxIndex = i;
            }
        }
        return movies[maxIndex];
    }
    }