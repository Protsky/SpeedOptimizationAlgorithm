public class TestMain {
    public static void main(String[] args) {
        Weather regionOne = new Weather("Locarno",3000,1800);
        Paramaeters parameters = new Paramaeters(2400,17.53,4,3000,1900, regionOne);

        System.out.println(parameters.calculateSpeed());
        parameters.calculateAllTime();



    }

}
