package api.kuCoinApi;

public class TickerShort {
    private String name;
    private Float changeRage;

    public TickerShort(String name, Float changeRage) {
        this.name = name;
        this.changeRage = changeRage;
    }

    public String getName() {
        return name;
    }

    public Float getChangeRage() {
        return changeRage;
    }
}
