public interface IEstateAgent {
    double CalculateCommission(String propertyPrice, String agentCommission);
    boolean ValidateData(Data dataToValidate);
}
//data tells you there should be a data class