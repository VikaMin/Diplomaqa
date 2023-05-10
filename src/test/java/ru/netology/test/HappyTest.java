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
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val approvedCardInformation = DataHelper.getApprovedCardInfo();
        paymentCardPage.cardInfo(approvedCardInformation);
        paymentCardPage.waitIfMessSuccess();
        val paymentStatus = SqlHelper.getPaymentEntity();
        assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("Отказ оплаты тура картой, статус Declined")
    void shouldPaymentPayNotByDecDC() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val declinedCardInformation = DataHelper.getDeclinedCardInfo();
        paymentCardPage.cardInfo(declinedCardInformation);
        paymentCardPage.waitIfMessFail();
        val paymentStatus = SqlHelper.getPaymentEntity();
        assertEquals("DECLINED", paymentStatus);
    }

    @Test
    @DisplayName("Успешная оплата тура в кредит по данным карты, статус Approved")
    void shouldCreditPaymentPayByAppDC() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val approvedCardInformation = DataHelper.getApprovedCardInfo();
        creditCardPage.cardInfo(approvedCardInformation);
        creditCardPage.waitIfMessSuccess();
        val paymentStatus = SqlHelper.getCreditEntity();
        assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("Отказ оплаты тура в кредит по данным карты, статус Declined")
    void shouldCreditPayNotByDecDC() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val declinedCardInformation = DataHelper.getDeclinedCardInfo();
        creditCardPage.cardInfo(declinedCardInformation);
        creditCardPage.waitIfMessFail();
        val paymentStatus = SqlHelper.getCreditEntity();
        assertEquals("DECLINED", paymentStatus);
    }

}
