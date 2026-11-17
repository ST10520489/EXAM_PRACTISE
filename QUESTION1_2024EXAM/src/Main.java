void main() {
        // 1. Single and Two-dimensional arrays
        String[] movies = {"Napoleon", "Oppenheimer"};
        String[] months = {"JAN", "FEB", "MAR"};

        int[][] ticketSales = { {3000, 1500, 1700},{3500, 1200, 1600} };

        MovieTickets movieTickets = new MovieTickets();
        int[] totalSales = new int[movies.length];

        // 2. Print Header simply
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();
        System.out.println("\t\t\t\t\tJAN\t\t\t\tFEB\t\t\t\tMAR"); //obvious just add or subtract till you get the layout u want
        System.out.println("---------------------------------------------------------------");

        // 3. Print rows using standard print and tabs (\t)
        for (int i = 0; i < movies.length; i++) {
            System.out.print(movies[i] + "\t\t\t");
            for (int j = 0; j < months.length; j++) {
                System.out.print(ticketSales[i][j] + "\t\t\t"); // spaces between the number
            }
            System.out.println();

            // Calculate total using your Q.1.2 method
            totalSales[i] = movieTickets.TotalMovieSales(ticketSales[i]);
        }

        System.out.println();
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Total movie ticket sales for " + movies[i] + " " + totalSales[i]);
        }
        System.out.println();
        String topMovie = movieTickets.TopMovie(movies, totalSales);
        System.out.println("Top performing movie: " + topMovie);
    }
