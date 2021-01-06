import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.zjy.model.UserModel;
import org.zjy.service.UserService;

import java.util.List;

@ContextConfiguration()
public class apiTest {

    @Autowired
    private UserService userService;

    @Test
    public void getAllUser() {
        UserModel tUser = userService.getUserById(1);
        System.out.println(tUser.getName());
    }
}
