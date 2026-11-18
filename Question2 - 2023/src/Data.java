public class Data {
    private String agentLocation;
    private String agentName;
    private String propertyPrice;
    private String agentCommission;

    //constructors
    public Data(String agentLocation, String agentName, String propertyPrice, String agentCommission) {
        this.agentLocation = agentLocation;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.agentCommission = agentCommission;
    }

    public String getAgentLocation() {
        return agentLocation;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public String getAgentCommission() {
        return agentCommission;
    }
}
