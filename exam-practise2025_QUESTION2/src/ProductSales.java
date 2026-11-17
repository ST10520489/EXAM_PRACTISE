public class ProductSales implements IProductSales {

    private final int[][] productSales = {{300, 150, 700},{250, 200, 600}};
    private final int SALES_LIMIT = 500;

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }
        return total;
    }
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                if (productSales[i][j] > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                if (productSales[i][j] < SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                count++;
            }
        }
        return count;
    }
    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = GetProductsProcessed();
        if (count == 0) {
            return 0.0;
        }
        return (double) total / count;
    }
}