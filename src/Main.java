void main() {
        // Single-dimensional arrays for labels
        String[] years = {"YEAR 1", "YEAR 2"};
        String[] quarters = {"QUARTER 1", "QUARTER 2", "QUARTER 3"};

        // Two-dimensional array for product sales data
        int[][] productSales = { {300, 150, 700},{250, 200, 600} };

        ProductSales ps = new ProductSales(); //ps can be written as obj if you want

        int total = ps.TotalSales(productSales);
        int average = (int) Math.round(ps.AverageSales(productSales));
        int max = ps.MaxSale(productSales);
        int min = ps.MinSale(productSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("------------------------------------");
        System.out.println("Total sales:   " + total);
        System.out.println("Average sales: " + average);
        System.out.println("Maximum sale:  " + max);
        System.out.println("Minimum sale:  " + min);
        System.out.println("------------------------------------");
    }