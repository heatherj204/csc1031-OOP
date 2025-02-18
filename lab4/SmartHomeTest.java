public class SmartHomeTest {
    public static void main(String[] args) {
        SmartHome.SmartWashingMachine swm = new SmartHome.SmartWashingMachine("Samsung", 1500, 7, true);
        swm.turnOn();
        swm.washClothes();
        swm.connectToWiFi();
        System.out.println("WiFi Enabled: " + swm.hasWiFi());

        SmartHome.WashingMachine wm = new SmartHome.WashingMachine("LG", 1300, 6);
        wm.turnOn();
        wm.washClothes();
        System.out.println("Drum Size: " + wm.getDrumSize() + " kg");

        SmartHome.Refrigerator fridge = new SmartHome.Refrigerator("Whirlpool", 800, 4.0);
        fridge.turnOn();
        fridge.coolItems();
        fridge.setTemperature(2.5);
        System.out.println("Current Temperature: " + fridge.getTemperature() + "°C");
    }
}