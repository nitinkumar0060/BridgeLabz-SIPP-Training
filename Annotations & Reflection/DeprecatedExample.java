class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old Feature (Don’t use)");
    }

    public void newFeature() {
        System.out.println("New Feature (Use this instead)");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // shows warning
        api.newFeature();
    }
}
