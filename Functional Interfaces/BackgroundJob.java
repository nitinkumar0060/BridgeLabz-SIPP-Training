public class BackgroundJob {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Background task running...");
        new Thread(job).start();
    }
}
