package testCases;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    @Test
    public void testScrollUpUsingArrowButton() {
        homePage.scrollToBottom();

        homePage.clickScrollUpArrow();

        Assert.assertTrue(
                homePage.isTopTextVisible(),
                "Lỗi: Dùng mũi tên cuộn lên thất bại, không thấy text ở đỉnh trang!"
        );
        System.out.println("Test Case 25 Passed: Nút mũi tên hoạt động tốt!");
    }

    @Test
    public void testScrollUpWithoutArrowButton() {
        homePage.scrollToBottom();
        homePage.scrollToTopWithoutArrow();

        Assert.assertTrue(
            homePage.isAtTopOfPage(),
            "Scroll to top thất bại!"
        );
    }
}
