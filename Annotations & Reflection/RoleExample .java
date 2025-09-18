import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted");
    }
}

public class RoleExample {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // change to ADMIN

        Method m = SecureService.class.getMethod("deleteUser");
        RoleAllowed role = m.getAnnotation(RoleAllowed.class);

        if (role.value().equals(currentUserRole)) {
            m.invoke(new SecureService());
        } else {
            System.out.println("Access Denied!");
        }
    }
}
