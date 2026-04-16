package dataProvider;

import models.User;
import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "loginDataSuccessful")
    public Object[][] getUserDataSuccessful() {
        return new Object[][]{
                { new User("nhung@gmail.com", "1234567890") }
        };
    }

    @DataProvider(name ="loginDataUnsuccessful")
    public Object[][] getUserDataUnsuccessful(){
        return new Object[][]{
                { new User("nhung@gmail.com","123123123"),"Your email or password is incorrect!", "invalidCredential" },
                { new User("nhung@gmail.com",""),"fill out","password"},
                { new User("","123123123"),"fill out", "email" },
                { new User("nhung123@gmail.com","123123123"),"Your email or password is incorrect!","invalidCredential" },
                { new User("abc","123123123"),"email address","email" }
        };
    }
}
