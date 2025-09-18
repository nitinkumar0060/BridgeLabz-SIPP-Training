interface ReportExporter {
    void export();

    default void exportToJSON() {
        System.out.println("Exporting report to JSON...");
    }
}

class CSVExporter implements ReportExporter {
    public void export() { System.out.println("Exporting report to CSV..."); }
}

public class ExportDemo {
    public static void main(String[] args) {
        ReportExporter exporter = new CSVExporter();
        exporter.export();
        exporter.exportToJSON();
    }
}
