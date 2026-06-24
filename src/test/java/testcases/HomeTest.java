package testcases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Automation Exercise Web")
@Feature("Quản lý trang chủ")

public class HomeTest extends BaseTest {
    @Test
    public void testScrollUpUsingArrowButton() {
        homePage.scrollToBottom();

        homePage.clickScrollUpArrow();

        Assert.assertTrue(
                homePage.isTopTextVisible(),
                "Lỗi: Dùng mũi tên cuộn lên thất bại, không thấy text ở đỉnh trang!"
        );
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



