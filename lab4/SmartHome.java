public class SmartHome {
    static class Appliance {
        private String brand;
        private double powerConsumption;

        public Appliance(String brand, double powerConsumption){
            this.brand = brand;
            this.powerConsumption = powerConsumption;
        }

        public Appliance(){
            this.brand = null;
            this.powerConsumption = 0;
        }

        public Appliance(String brand){
            this.brand = brand;
            this.powerConsumption = 0;
        }

        public Appliance(double powerConsumption){
            this.brand = null;
            this.powerConsumption = powerConsumption;
        }

        // getters and setters for the variables as they are private there is no way of accessing them without this
        public String getBrand() {
            return this.brand;
        }

        public void setBrand(String brand){
            this.brand = brand;
        }

        public double  getPowerConsumption() {
            return this.powerConsumption;
        }

        public void setPowerConsumption(double powerConsumption){
            this.powerConsumption = powerConsumption;
        }

        public void turnOn(){
            System.out.println("Turning on " + this.brand + " appliance");
        }
        public void turnOff(){
            System.out.println("Turning off " + this.brand + " appliance");

        }
    }

    static class WashingMachine extends Appliance{
        private int drumSize;

        public WashingMachine(String brand, double powerConsumption, int drumSize){
            super(brand, powerConsumption);
            this.drumSize = drumSize;
        }

        public WashingMachine(){
            this(null,0, 0);
        }

        public WashingMachine(String brand){
            this(brand,0, 0);
        }

        public WashingMachine(String brand, int drumSize){
            this(brand,0, drumSize);
        }

        public WashingMachine(double powerConsumption){
            this(null, powerConsumption, 0);
        }

        public int getDrumSize(){
            return this.drumSize;
        }

        public void setDrumSize(int drumSize){
            this.drumSize = drumSize;
        }

        public void washClothes(){
            System.out.println("Washing clothes in a " + this.getBrand() + " washing machine");
        }
    }

    static class Refrigerator extends Appliance{
        private double temperature;

        public Refrigerator(String brand, double powerConsumption, double temperature){
            super(brand, powerConsumption);
            this.temperature = temperature;
        }

        public Refrigerator(){
            this(null, 0, 0);
        }

        public Refrigerator(String brand){
            this(brand, 0, 0);
        }

        public Refrigerator(String brand, double temperature){
            this(brand, 0, temperature);
        }

        public Refrigerator(double powerConsumption){
            this(null, powerConsumption, 0);
        }

        public double getTemperature(){
            return this.temperature;
        }

        public void setTemperature(double temperature){
            this.temperature = temperature;
        }

        public void coolItems(){
            System.out.println("Cooling items in a " + this.getBrand() + " refrigerator at " + this.temperature + "°C" );
        }
    }

    static class SmartWashingMachine extends WashingMachine{
        private boolean hasWiFi;

        public SmartWashingMachine(String brand, double powerConsumption, int drumSize, boolean hasWiFi){
            super(brand, powerConsumption, drumSize);
            this.hasWiFi = hasWiFi;
        }

        public void connectToWiFi(){
            if (this.hasWiFi) {
                System.out.println("Smart Washing Machine connected to WiFi");
            } else{
                System.out.println("This washing machine does not support WiFi");
            }
        }

        public boolean hasWiFi(){
            return this.hasWiFi;
        }
    }
}