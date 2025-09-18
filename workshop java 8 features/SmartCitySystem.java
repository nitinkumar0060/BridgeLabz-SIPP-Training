// SmartCitySystem.java
import java.time.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.text.DecimalFormat;

// Models
class Route {
    final String id;
    final String from;
    final String to;
    final double distanceKm;
    Route(String id, String from, String to, double distanceKm) {
        this.id = id; this.from = from; this.to = to; this.distanceKm = distanceKm;
    }
    public String toString() { return id + ": " + from + "->" + to + " (" + distanceKm + " km)"; }
}

class Schedule {
    final Route route;
    final LocalTime departure;
    final double baseFare;
    final int availableSeats;
    Schedule(Route route, LocalTime departure, double baseFare, int seats) {
        this.route = route; this.departure = departure; this.baseFare = baseFare; this.availableSeats = seats;
    }
    public String toString() { return route.id + " @ " + departure + " fare:" + baseFare; }
}

class Passenger {
    final String id;
    final String name;
    Passenger(String id, String name) { this.id = id; this.name = name; }
    public String toString() { return name + "(" + id + ")"; }
}

class Trip {
    final Passenger passenger;
    final Route route;
    final LocalDateTime bookedAt;
    final double fare;
    Trip(Passenger p, Route r, LocalDateTime bookedAt, double fare) {
        this.passenger = p; this.route = r; this.bookedAt = bookedAt; this.fare = fare;
    }
    public String toString() {
        return passenger + " -> " + route.id + " fare:" + fare + " at " + bookedAt.toLocalTime();
    }
}

// Marker interface
interface EmergencyService { }

// Functional interface
@FunctionalInterface
interface FareCalculator {
    double calculateFare(Route route, double distanceKm);
}

// Geo utils as static methods in interface
interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double r = 6371; // km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return r * c;
    }
}

// TransportService interface with default method
interface TransportService {
    String name();
    List<Schedule> getSchedules();
    default void printServiceDetails() {
        System.out.println("Service: " + name());
        getSchedules().forEach(s -> System.out.println("  " + s));
    }
    default void log(String msg) { System.out.println("[" + name() + "] " + msg); }
}

// Implementations
class BusService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    BusService(String name, List<Schedule> schedules) { this.name = name; this.schedules = schedules; }
    public String name() { return name; }
    public List<Schedule> getSchedules() { return schedules; }
}

class MetroService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    MetroService(String name, List<Schedule> schedules) { this.name = name; this.schedules = schedules; }
    public String name() { return name; }
    public List<Schedule> getSchedules() { return schedules; }
}

class TaxiService implements TransportService, EmergencyService {
    private final String name;
    private final List<Schedule> schedules;
    TaxiService(String name, List<Schedule> schedules) { this.name = name; this.schedules = schedules; }
    public String name() { return name; }
    public List<Schedule> getSchedules() { return schedules; }
}

// Example extension: FerryService just implements TransportService
class FerryService implements TransportService {
    private final String name;
    private final List<Schedule> schedules;
    FerryService(String name, List<Schedule> schedules) { this.name = name; this.schedules = schedules; }
    public String name() { return name; }
    public List<Schedule> getSchedules() { return schedules; }
}

// Utilities
class FareUtils {
    static double baseFareByKm(Route route) {
        return 10 + 2 * route.distanceKm;
    }
    static String format(double d) { return new DecimalFormat("#0.00").format(d); }
}

// Main System Demo
public class SmartCitySystem {
    public static void main(String[] args) {
        Route r1 = new Route("R101","Central","North",12.5);
        Route r2 = new Route("R102","Central","East",8.0);
        Route r3 = new Route("R103","North","Airport",23.0);

        Schedule s1 = new Schedule(r1, LocalTime.of(8,0), FareUtils.baseFareByKm(r1), 40);
        Schedule s2 = new Schedule(r1, LocalTime.of(9,30), FareUtils.baseFareByKm(r1)*0.95, 20);
        Schedule s3 = new Schedule(r2, LocalTime.of(7,45), FareUtils.baseFareByKm(r2), 50);
        Schedule s4 = new Schedule(r3, LocalTime.of(6,30), FareUtils.baseFareByKm(r3), 30);
        Schedule s5 = new Schedule(r3, LocalTime.of(18,0), FareUtils.baseFareByKm(r3)*0.9, 25);

        TransportService bus = new BusService("CityBus", Arrays.asList(s1, s2));
        TransportService metro = new MetroService("MetroX", Arrays.asList(s3));
        TransportService taxi = new TaxiService("QuickTaxi", Arrays.asList(s4, s5));
        TransportService ferry = new FerryService("RiverFerry", Arrays.asList(new Schedule(r2, LocalTime.of(12,0), FareUtils.baseFareByKm(r2)*1.2, 100)));

        List<TransportService> services = Arrays.asList(bus, metro, taxi, ferry);

        FareCalculator calculator = (route, dist) -> {
            double base = FareUtils.baseFareByKm(route);
            return Math.max(30, base + 1.5 * dist);
        };

        List<Passenger> passengers = Arrays.asList(
            new Passenger("P001","Amit"),
            new Passenger("P002","Ravi"),
            new Passenger("P003","Neha"),
            new Passenger("P004","Sneha"),
            new Passenger("P005","Karan"),
            new Passenger("P006","Mira")
        );

        List<Trip> bookings = new ArrayList<>();
        bookings.add(new Trip(passengers.get(0), r1, LocalDateTime.now().minusHours(1), calculator.calculateFare(r1, r1.distanceKm)));
        bookings.add(new Trip(passengers.get(1), r1, LocalDateTime.now().minusDays(1), calculator.calculateFare(r1, r1.distanceKm)));
        bookings.add(new Trip(passengers.get(2), r2, LocalDateTime.now().minusHours(2), calculator.calculateFare(r2, r2.distanceKm)));
        bookings.add(new Trip(passengers.get(3), r3, LocalDateTime.now().minusHours(3), calculator.calculateFare(r3, r3.distanceKm)));
        bookings.add(new Trip(passengers.get(4), r3, LocalDateTime.now().minusMinutes(30), calculator.calculateFare(r3, r3.distanceKm)));
        bookings.add(new Trip(passengers.get(5), r2, LocalDateTime.now().minusDays(2), calculator.calculateFare(r2, r2.distanceKm)));

        System.out.println("=== Dashboard: Available Services (forEach + method reference) ===");
        services.forEach(TransportService::printServiceDetails);

        System.out.println("\n=== Filtering & Sorting: find earliest departure and lowest fare per route ===");
        services.stream()
            .flatMap(svc -> svc.getSchedules().stream())
            .collect(Collectors.groupingBy(sc -> sc.route.id,
                    Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparing((Schedule sc) -> sc.departure)
                                        .thenComparing(sc -> sc.baseFare)),
                        Optional::get)))
            .values().stream()
            .sorted(Comparator.comparing((Schedule sc) -> sc.departure))
            .forEach(sc -> System.out.println("Selected: " + sc.route.id + " -> " + sc));

        System.out.println("\n=== Top-used Routes (groupingBy + counting) ===");
        Map<String, Long> topRoutes = bookings.stream()
            .collect(Collectors.groupingBy(t -> t.route.id, Collectors.counting()));
        topRoutes.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .forEach(e -> System.out.println(e.getKey() + " used " + e.getValue() + " times"));

        System.out.println("\n=== Revenue Reports (groupingBy + summing/averaging) ===");
        Map<String, Double> revenueByRoute = bookings.stream()
            .collect(Collectors.groupingBy(t -> t.route.id, Collectors.summingDouble(t -> t.fare)));
        Map<String, Double> avgFareByRoute = bookings.stream()
            .collect(Collectors.groupingBy(t -> t.route.id, Collectors.averagingDouble(t -> t.fare)));
        revenueByRoute.forEach((r, rev) -> System.out.println(r + " revenue=" + FareUtils.format(rev)
                + " avg=" + FareUtils.format(avgFareByRoute.get(r))));

        System.out.println("\n=== Partitioning: peak vs non-peak (trips) ===");
        Predicate<Trip> isPeak = t -> {
            int h = t.bookedAt.getHour();
            return (h >= 7 && h <= 10) || (h >= 17 && h <= 20);
        };
        Map<Boolean, List<Trip>> peakPartition = bookings.stream().collect(Collectors.partitioningBy(isPeak));
        System.out.println("Peak trips: " + peakPartition.get(true).size() + " Non-peak: " + peakPartition.get(false).size());

        System.out.println("\n=== Summarizing fares (summarizingDouble) ===");
        Map<String, DoubleSummaryStatistics> fareStatsByRoute = bookings.stream()
            .collect(Collectors.groupingBy(t -> t.route.id, Collectors.summarizingDouble(t -> t.fare)));
        fareStatsByRoute.forEach((k, s) -> System.out.println(k + " -> count:" + s.getCount() + " sum:" + FareUtils.format(s.getSum()) + " avg:" + FareUtils.format(s.getAverage())));

        System.out.println("\n=== Find available services for passenger preference (lambda filter + comparator) ===");
        LocalTime preferredTime = LocalTime.of(9,0);
        double maxFare = 300;
        List<Schedule> matching = services.stream()
            .flatMap(svc -> svc.getSchedules().stream())
            .filter(sc -> !sc.departure.isBefore(preferredTime))
            .filter(sc -> sc.baseFare <= maxFare)
            .sorted(Comparator.comparing((Schedule sc) -> sc.baseFare))
            .collect(Collectors.toList());
        matching.forEach(sc -> System.out.println("Match: " + sc));

        System.out.println("\n=== Emergency services detection (marker interface) ===");
        services.stream()
            .filter(svc -> svc instanceof EmergencyService)
            .forEach(svc -> System.out.println("Emergency-enabled: " + svc.name()));

        System.out.println("\n=== Example GeoUtils use (method reference style) ===");
        double dist = GeoUtils.calculateDistance(28.7,77.1, 28.5,77.2);
        System.out.println("Distance (approx): " + FareUtils.format(dist) + " km");

        System.out.println("\n=== Simulate a booking (lambda fare calculator) ===");
        TransportService chosen = services.get(0);
        Schedule chosenSchedule = chosen.getSchedules().get(0);
        Passenger p = passengers.get(0);
        double fare = calculator.calculateFare(chosenSchedule.route, chosenSchedule.route.distanceKm);
        Trip newTrip = new Trip(p, chosenSchedule.route, LocalDateTime.now(), fare);
        bookings.add(newTrip);
        System.out.println("Booked: " + newTrip);

        System.out.println("\n=== Live dashboard: show all active bookings (forEach) ===");
        bookings.forEach(System.out::println);
    }
}
