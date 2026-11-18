void main()
{
    double[][] propertySales = {{800000, 1500000, 2000000}, {700000, 1200000, 1600000}};
    double[] totalSales = new double[2];
    String[] estateAgents = {"Joe Bloggs", "Jane Doe"};

    EstateAgentPrinting printing = new EstateAgentPrinting(propertySales, totalSales, estateAgents);

//same as question 1 from 2024 just different approach

    printing.printHeadings();
    printing.printPropertySales();
    printing.printTotalAgentSales();
    printing.printTotalAgentCommission();
    printing.printTopAgent();
}
