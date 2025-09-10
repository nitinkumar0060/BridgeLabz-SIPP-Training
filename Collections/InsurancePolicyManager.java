import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class InsurancePolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();
    Map<String, Integer> policyCount = new HashMap<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
        policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
    }

    public Set<Policy> getAllUniquePolicies() {
        return hashSet;
    }

    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet) {
            long days = ChronoUnit.DAYS.between(now, p.getExpiryDate());
            if (days >= 0 && days <= 30) result.add(p);
        }
        return result;
    }

    public List<Policy> getPoliciesByCoverage(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) result.add(p);
        }
        return result;
    }

    public List<Policy> getDuplicatePolicies() {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashSet) {
            if (policyCount.get(p.getPolicyNumber()) > 1) result.add(p);
        }
        return result;
    }

    public void comparePerformance() {
        List<Policy> sample = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            sample.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Auto", 1000 + i));
        }

        long start = System.nanoTime();
        Set<Policy> hs = new HashSet<>(sample);
        long hashTime = System.nanoTime() - start;

        start = System.nanoTime();
        Set<Policy> lhs = new LinkedHashSet<>(sample);
        long linkedTime = System.nanoTime() - start;

        start = System.nanoTime();
        Set<Policy> ts = new TreeSet<>(sample);
        long treeTime = System.nanoTime() - start;

        System.out.println("Add Time (ns): HashSet=" + hashTime + ", LinkedHashSet=" + linkedTime + ", TreeSet=" + treeTime);
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 1200));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 1500));
        manager.addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 1800));
        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 1200));

        System.out.println("All Unique Policies:");
        manager.getAllUniquePolicies().forEach(System.out::println);

        System.out.println("\nPolicies Expiring Soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nPolicies with Coverage Type 'Health':");
        manager.getPoliciesByCoverage("Health").forEach(System.out::println);

        System.out.println("\nDuplicate Policies:");
        manager.getDuplicatePolicies().forEach(System.out::println);

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}
