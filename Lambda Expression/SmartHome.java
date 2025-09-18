interface LightAction {
    void execute();
}

public class SmartHome {
    public static void main(String[] args) {
        LightAction motion = () -> System.out.println("Lights ON due to motion detected!");
        LightAction timeOfDay = () -> System.out.println("Dim lights for evening mode.");
        LightAction voiceCommand = () -> System.out.println("Lights OFF on voice command.");

        motion.execute();
        timeOfDay.execute();
        voiceCommand.execute();
    }
}
