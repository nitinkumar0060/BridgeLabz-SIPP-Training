import java.time.*;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiryDate;
    Member(String name, LocalDate expiryDate) {
        this.name = name; this.expiryDate = expiryDate;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Ravi", LocalDate.now().plusDays(40)),
            new Member("Neha", LocalDate.now().plusDays(25))
        );

        members.stream()
               .filter(m -> !m.expiryDate.isAfter(LocalDate.now().plusDays(30)))
               .forEach(m -> System.out.println(m.name + " expiring on " + m.expiryDate));
    }
}
