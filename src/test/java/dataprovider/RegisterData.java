package dataProvider;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.UUID;

public class RegisterData {
    private String randomEmail() {
        return UUID.randomUUID() + "@gmail.com";
    }

    @DataProvider(name = "registerSuccessful")
    public Object[][] getDataRegisterUser() {
        return new Object[][]{
                {
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789")
                }
        };
    }

    @DataProvider(name = "registerUnsuccessful")
    public Object[][] getDataRegisteredUserUnsuccessful() {
        return new Object[][]{
                {   //Case 5: Empty password field
                        new User("NgocHoa", randomEmail(), "", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "password", "fill out"
                },
                {   //Case 6: Empty first name field
                        new User("NgocHoa", randomEmail(), "123123123", "", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "firstname", "fill out"
                },
                {   //Case 7: Empty last name field
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "lastname", "fill out"
                },
                {    //Case 8: Empty address field
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "Nguyen", "", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "address", "fill out"
                },
                {   //Case 9: Empty state field
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "", "Thu Duc", "456099", "0123456789"), "state", "fill out"
                },
                {   //Case 10: Empty city field
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "", "456099", "0123456789"), "city", "fill out"
                },
                {   //Case 11: Empty zipcode field
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "", "0123456789"), "zipcode", "fill out"
                },
                {   //Case 12: Empty mobile phone field
                        new User("NgocHoa", randomEmail(), "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", ""), "phone", "fill out"
                }
        };
    }

    @DataProvider(name = "registerUnsuccessfulStep1")
    public Object[][] getDataRegisteredUserUnsuccessfulStep1() {
        return new Object[][]{
                {   //Case 1: Empty name field
                        new User("", randomEmail(), "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "name", "fill out"
                },
                {   //Case 2: Empty email field
                        new User("NgocHoa", "", "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "email", "fill out"
                },
                {   //Case 3: Email existed
                        new User("NgocHoa", "nhung@gmail.com", "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "errorcredential", "Email Address already exist!"
                },
                {   //Case 4: Incorrect email format
                        new User("NgocHoa", "nhung", "123123123", "Hoa", "Nguyen", "Dien Bien Phu", "India", "TP HCM", "Thu Duc", "456099", "0123456789"), "email", "include an"
                },
        };
    }
}

