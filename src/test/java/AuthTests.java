import org.junit.Test;


public class AuthTests extends AuthBaseTest {

    @Test
    public void loginTestPositive() {
        login("user", "user");
        //Здесь должен быть assert, но я не совсем понимаю, что и с чем сравнивать
    }

    @Test
    public void loginTestNegative() {
        login("users", "users");
        //Здесь должен быть assert, но я не совсем понимаю, что и с чем сравнивать
    }

}
