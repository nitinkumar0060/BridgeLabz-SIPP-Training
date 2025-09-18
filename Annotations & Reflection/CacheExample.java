import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class ExpensiveOperation {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        try { Thread.sleep(500); } catch (Exception e) {} // simulate slow work
        int result = n * n;
        cache.put(n, result);
        return result;
    }
}

public class CacheExample {
    public static void main(String[] args) throws Exception {
        ExpensiveOperation op = new ExpensiveOperation();
        System.out.println(op.computeSquare(5));
        System.out.println(op.computeSquare(5)); // returns fast (cached)
    }
}
