import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy {
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

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class PolicyManager {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(now, true, threshold, true).entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashMap.values()) {
            if (p.getPolicyholderName().equalsIgnoreCase(holderName)) result.add(p);
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(now)) iterator.remove();
        }

        iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(now)) iterator.remove();
        }

        treeMap.headMap(now, false).clear();
    }

    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 1200));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 1500));
        manager.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5), "Home", 1800));
        manager.addPolicy(new Policy("P004", "David", LocalDate.now().plusDays(25), "Auto", 1600));

        System.out.println("Policy by Number P001:");
        System.out.println(manager.getPolicyByNumber("P001"));

        System.out.println("\nPolicies Expiring Soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nPolicies for Alice:");
        manager.getPoliciesByHolder("Alice").forEach(System.out::println);

        System.out.println("\nRemoving Expired Policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nRemaining Policies:");
        manager.hashMap.values().forEach(System.out::println);
    }
}
