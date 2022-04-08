public class Weather {
    private String region;
    private int maxAltezza;
    private int minAltezza;


    public Weather(String region, int maxAltezza, int minAltezza) {
        this.region = region;
        this.maxAltezza = maxAltezza;
        this.minAltezza = minAltezza;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMaxAltezza() {
        return maxAltezza;
    }

    public void setMaxAltezza(int maxAltezza) {
        this.maxAltezza = maxAltezza;
    }

    public int getMinAltezza() {
        return minAltezza;
    }

    public void setMinAltezza(int minAltezza) {
        this.minAltezza = minAltezza;
    }
}
