import org.junit.Test;


public class AuthTests extends AuthBaseTest {

    @Test
    public void loginTestPositive() {
        login("user", "user");
    }

    @Test
    public void loginTestNegative() {
        login("users", "users");
    }

}
