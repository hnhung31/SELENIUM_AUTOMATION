package dataprovider;

import models.ContactUs;
import org.testng.annotations.DataProvider;

import java.io.File;

public class ContactUsData {
    static String absolutePath = new File("src/test/resources/dssf.html").getAbsolutePath();
    @DataProvider(name = "getContactUsSuccessful")
    public Object[][] getContactUsSuccessful(){
        return new Object[][]{
                {
                    //Case1 : Send successful
                    new ContactUs("hongnhung","hnhung123@gmail.com","We really appreciate your response to our website.","Nothing",absolutePath)
                },
                {
                    //Case 2: minimum field( only email field)
                    new ContactUs("","hnhung123@gmail.com","","","")
                }
        };
    }

    @DataProvider(name = "getContactUsDataWithInvalidField")
    public Object[][] getContactUsDataWithInvalidField(){
        return new Object[][]{
                {
                    //Case 3: empty Email
                        new ContactUs("hongnhung","","We really appreciate your response to our website.","Nothing",absolutePath),"fill out"
                },
                {
                    //Case 4: Incorrect email format
                    new ContactUs("hongnhung","hnhung123","We really appreciate your response to our website.","Nothing",absolutePath),"include an"
                }

                
        };
    }
}
