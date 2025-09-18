import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    public User(String username) throws Exception {
        this.username = username;

        Field f = User.class.getDeclaredField("username");
        MaxLength ml = f.getAnnotation(MaxLength.class);

        if (username.length() > ml.value()) {
            throw new IllegalArgumentException("Username too long!");
        }
    }
}

public class MaxLengthExample {
    public static void main(String[] args) throws Exception {
        new User("Krishna");      // OK
        new User("ThisIsTooLong"); // Throws exception
    }
}
