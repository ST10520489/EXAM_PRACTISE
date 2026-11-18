public class EstateAgent implements IEstateAgent {

    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice);
        double commissionPercent = Double.parseDouble(agentCommission);
        return price * (commissionPercent / 100.0);
    }

    @Override
    public boolean ValidateData(Data dataToValidate) {
        if (dataToValidate == null) {
            return false;
        }

        // 1. Agent Location: cannot be empty
        if (dataToValidate.getAgentLocation() == null || dataToValidate.getAgentLocation().trim().isEmpty()) {
            return false;
        }

        // 2. Agent Name: cannot be empty
        if (dataToValidate.getAgentName() == null || dataToValidate.getAgentName().trim().isEmpty()) {
            return false;
        }

        // 3. Property Price & 4. Commission Percentage: cannot be less than or equal to zero (0)
        try {
            double price = Double.parseDouble(dataToValidate.getPropertyPrice());
            double commission = Double.parseDouble(dataToValidate.getAgentCommission());

            if (price <= 0 || commission <= 0) {
                return false;
            }
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }
}