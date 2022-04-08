import java.util.HashMap;
import java.util.Map;

public class Paramaeters {


    private double actualAltitude;
    private double distance;
    private double ratioThermal;
    private double nextAltitude;
    private double obstacleAltitude;
    private HashMap<Integer, Integer> ratioGlider = new HashMap<>();
    Weather weather;


    public Paramaeters(double actualAltitude, double distance, double ratioThermal, double nextAltitude, double obstacleAltitude, Weather weather) {
        this.actualAltitude = actualAltitude;
        this.distance = distance;
        this.ratioThermal = ratioThermal;
        this.nextAltitude = nextAltitude;
        this.obstacleAltitude = obstacleAltitude;
        this.weather = weather;
        getRatioGlider().put(91,38);
        getRatioGlider().put(106,36);
        getRatioGlider().put(119,33);
        getRatioGlider().put(130,30);
        getRatioGlider().put(141,27);
        getRatioGlider().put(151,24);
        getRatioGlider().put(160,22);
    }


    public double getActualAltitude() {
        return actualAltitude;
    }

    public void setActualAltitude(double actualAltitude) {
        this.actualAltitude = actualAltitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getRatioThermal() {
        return ratioThermal;
    }

    public void setRatioThermal(double ratioThermal) {
        this.ratioThermal = ratioThermal;
    }

    public double getNextAltitude() {
        return nextAltitude;
    }

    public void setNextAltitude(double nextAltitude) {
        this.nextAltitude = nextAltitude;
    }



    public HashMap<Integer, Integer> getRatioGlider() {
        return ratioGlider;
    }

    public void setRatioGlider(HashMap<Integer, Integer> ratioGlider) {
        this.ratioGlider = ratioGlider;
    }


    public double getObstacleAltitude() {
        return obstacleAltitude;
    }

    public void setObstacleAltitude(double obstacleAltitude) {
        this.obstacleAltitude = obstacleAltitude;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public double calculateSpeed(){
        double speedToFly =0;
        double timeToFly = 100000;
        for(Map.Entry<Integer, Integer> entry : ratioGlider.entrySet()) {

            int vel = entry.getKey();
            int fin = entry.getValue();

            double df = getDistance();
            double hf = getNextAltitude();
            double ho = getActualAltitude();
            double tf = getRatioThermal();

            double s1 = (df*1000)/(vel/3.6);
            double s2 = (hf-(ho-((1000*df)/fin)))/tf;

            double resultTime =  s1 + s2;


            if(ho-(df*1000)*1/fin > getObstacleAltitude() && ho-(df*1000)*1/fin > weather.getMinAltezza() && resultTime < timeToFly  ){
                timeToFly = resultTime;
                speedToFly = vel;
            }


        }
        return speedToFly;

    }

    public void calculateAllTime(){

        for(Map.Entry<Integer, Integer> entry : ratioGlider.entrySet()) {


            int vel = entry.getKey();
            int fin = entry.getValue();

            double df = getDistance();
            double hf = getNextAltitude();
            double ho = getActualAltitude();
            double tf = getRatioThermal();

            double s1 = (df*1000)/(vel/3.6);
            double s2 = (hf-(ho-((1000*df)/fin)))/tf;

            double resultTime =  s1 + s2;

            System.out.println("Time: " + resultTime + " at speed " + vel);

        }

    }

}