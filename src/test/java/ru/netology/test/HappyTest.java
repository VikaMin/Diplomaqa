package ru.netology.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.page.DashboardPage;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HappyTest {


    DashboardPage dashboardPage = new DashboardPage();


    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @BeforeEach
    void setup() {
        open(System.getProperty("sut.url"));
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SqlHelper.cleanDataBase();
    }


    @Test
    @DisplayName("Успешная оплата тура картой, статус Approved")
    void shouldPaymentPayByAppDC() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var approvedCardInformation = DataHelper.getApprovedCardInfo();
        paymentCardPage.cardInfo(approvedCardInformation);
        paymentCardPage.waitIfMessSuccess();
        var paymentStatus = SqlHelper.getPaymentEntity();
        assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("Отказ оплаты тура картой, статус Declined")
    void shouldPaymentPayNotByDecDC() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var declinedCardInformation = DataHelper.getDeclinedCardInfo();
        paymentCardPage.cardInfo(declinedCardInformation);
        paymentCardPage.waitIfMessFail();
        var paymentStatus = SqlHelper.getPaymentEntity();
        assertEquals("DECLINED", paymentStatus);
    }

    @Test
    @DisplayName("Успешная оплата тура в кредит по данным карты, статус Approved")
    void shouldCreditPaymentPayByAppDC() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var approvedCardInformation = DataHelper.getApprovedCardInfo();
        creditCardPage.cardInfo(approvedCardInformation);
        creditCardPage.waitIfMessSuccess();
        var paymentStatus = SqlHelper.getCreditEntity();
        assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("Отказ оплаты тура в кредит по данным карты, статус Declined")
    void shouldCreditPayNotByDecDC() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var declinedCardInformation = DataHelper.getDeclinedCardInfo();
        creditCardPage.cardInfo(declinedCardInformation);
        creditCardPage.waitIfMessFail();
        var paymentStatus = SqlHelper.getCreditEntity();
        assertEquals("DECLINED", paymentStatus);
    }

}
