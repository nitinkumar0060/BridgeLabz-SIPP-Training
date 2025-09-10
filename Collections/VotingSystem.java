import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteMap = new HashMap<>();
    Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedResults = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, voteMap.get(candidate));
        sortedResults.put(candidate, voteMap.get(candidate));
    }

    public int getVotes(String candidate) {
        return voteMap.getOrDefault(candidate, 0);
    }

    public void displayVotesInInsertionOrder() {
        for (Map.Entry<String, Integer> entry : orderedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayVotesSortedByCandidate() {
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayAllVotes() {
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");

        System.out.println("All Votes:");
        system.displayAllVotes();

        System.out.println("\nVotes in Insertion Order:");
        system.displayVotesInInsertionOrder();

        System.out.println("\nVotes Sorted by Candidate:");
        system.displayVotesSortedByCandidate();
    }
}
