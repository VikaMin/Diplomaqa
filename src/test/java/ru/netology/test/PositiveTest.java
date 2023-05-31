package ru.netology.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.page.DashboardPage;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTest {


    DashboardPage dashboardPage = new DashboardPage();

    @BeforeEach
    void setup() {
        open(System.getProperty("sut.url"));
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        var approvedCardInformation = DataHelper.getValidCard();
        paymentCardPage.cardInfo(approvedCardInformation);
        paymentCardPage.waitIfMessSuccess();
        var paymentStatus = SqlHelper.getPaymentStatus();
        assertEquals("APPROVED", paymentStatus);
    }


    @Test
    @DisplayName("Отказ оплаты тура картой, статус Declined")
    void shouldPaymentPayNotByDecDC() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var declinedCardInformation = DataHelper.getDeclinedCardInfo();
        paymentCardPage.cardInfo(declinedCardInformation);
        paymentCardPage.waitIfMessFail();
        var paymentStatus = SqlHelper.getPaymentStatus();
        assertEquals("DECLINED", paymentStatus);
    }

    @Test
    @DisplayName("Успешная оплата тура в кредит по данным карты, статус Approved")
    void shouldCreditPaymentPayByAppDC() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var approvedCardInformation = DataHelper.getValidCard();
        creditCardPage.cardInfo(approvedCardInformation);
        creditCardPage.waitIfMessSuccess();
        var paymentStatus = SqlHelper.getCreditStatus();
        assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("Отказ оплаты тура в кредит по данным карты, статус Declined")
    void shouldCreditPayNotByDecDC() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var declinedCardInformation = DataHelper.getDeclinedCardInfo();
        creditCardPage.cardInfo(declinedCardInformation);
        creditCardPage.waitIfMessFail();
        var paymentStatus = SqlHelper.getCreditStatus();
        assertEquals("DECLINED", paymentStatus);
    }

}
