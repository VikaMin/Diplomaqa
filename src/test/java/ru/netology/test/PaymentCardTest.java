package ru.netology.test;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.data.SqlHelper;
import static com.codeborne.selenide.Selenide.open;

public class PaymentCardTest {

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


    /*Поле Номер карты*/


    @Test
    @DisplayName("Отправка пустого поля Номер карты")
    void shouldErrorEmptyCardNumber() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var emptyCardNum = DataHelper.getEmptyCardNumber();
        paymentCardPage.cardInfo(emptyCardNum);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка короткого номера карты")
    void shouldErrorNotFullNumber() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var notFullCardInformation = DataHelper.getNotFullCardNumber();
        paymentCardPage.cardInfo(notFullCardInformation);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка несуществующего номера карты банка")
    void shouldErrorPayByNumber() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var invalidCardNumber = DataHelper.getInvalidCardNumber();
        paymentCardPage.cardInfo(invalidCardNumber);
        paymentCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Номер карты")
    void shouldErrorSymbolNumber() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var symbolCardNumber = DataHelper.getSymbolCardNumber();
        paymentCardPage.cardInfo(symbolCardNumber);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Номер карты")
    void shouldErrorLetterCardNumber() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var letterCardNumber = DataHelper.getLetterCardNumber();
        paymentCardPage.cardInfo(letterCardNumber);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле Месяц*/

    @Test
    @DisplayName("Отправка пустого поля месяц")
    void shouldErrorEmptyMonth() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var emptyMonth = DataHelper.getEmptyMonth();
        paymentCardPage.cardInfo(emptyMonth);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения 00 в поле месяц")
    void shouldErrorZeroMonth() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var zeroMonth = DataHelper.getZeroMonth();
        paymentCardPage.cardInfo(zeroMonth);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка нерелевантного значения, больше 12 в поле месяц")
    void shouldErrorInvalidMonth() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var invalidMonth = DataHelper.getInvalidMonth();
        paymentCardPage.cardInfo(invalidMonth);

        paymentCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле месяц")
    void shouldErrorSymbolMonth() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var symbolMonth = DataHelper.getSymbolMonth();
        paymentCardPage.cardInfo(symbolMonth);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле месяц")
    void shouldErrorLetterMonth() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var letterMonth = DataHelper.getLetterMonth();
        paymentCardPage.cardInfo(letterMonth);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле Год*/


    @Test
    @DisplayName("Отправка пустого поля год")
    void shouldErrorEmptyYear() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var emptyYear = DataHelper.getEmptyYear();
        paymentCardPage.cardInfo(emptyYear);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения меньше текущего года")
    void shouldErrorExpiredYear() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var expiredYear = DataHelper.getExpiredYear();
        paymentCardPage.cardInfo(expiredYear);

        paymentCardPage.waitIfMessCardExpired();
    }

    @Test
    @DisplayName("Отправка значения большего текущего года на 3")
    void shouldErrorLotsFutureYear() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var lotsFutureYear = DataHelper.getLotsFutureYear();
        paymentCardPage.cardInfo(lotsFutureYear);

        paymentCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка значения менее 2 цифр в поле год")
    void shouldErrorShortYear() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var shortYear = DataHelper.getShortYear();
        paymentCardPage.cardInfo(shortYear);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле год")
    void shouldErrorSymbolYear() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var symbolYear = DataHelper.getSymbolYear();
        paymentCardPage.cardInfo(symbolYear);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле год")
    void shouldErrorLetterYear() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var letterYear = DataHelper.getLetterYear();
        paymentCardPage.cardInfo(letterYear);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле Владелец*/


    @Test
    @DisplayName("Отправка пустого поля владелец")
    void shouldErrorEmptyOwner() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var emptyOwner = DataHelper.getEmptyOwner();
        paymentCardPage.cardInfo(emptyOwner);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка трех и более слов латинскими буквами в поле владелец")
    void shouldErrorThreeWordsOwner() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var threeWordsOwner = DataHelper.getThreeWordsOwner();
        paymentCardPage.cardInfo(threeWordsOwner);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле владелец")
    void shouldErrorSymbolOwner() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var symbolOwner = DataHelper.getSymbolOwner();
        paymentCardPage.cardInfo(symbolOwner);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка слов кириллицей в поле владелец")
    void shouldErrorInvalidRuOwner() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var invalidRuOwner = DataHelper.getInvalidRuOwner();
        paymentCardPage.cardInfo(invalidRuOwner);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка чисел в поле владелец")
    void shouldErrorNumbersOwner() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var invalidNumbersOwner = DataHelper.getInvalidNumbersOwner();
        paymentCardPage.cardInfo(invalidNumbersOwner);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле CVC/CVV*/


    @Test
    @DisplayName("Отправка пустого поля Cvc")
    void shouldErrorEmptyCvc() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var emptyCvc = DataHelper.getEmptyCvc();
        paymentCardPage.cardInfo(emptyCvc);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка 2 цифр в поле Cvc")
    void shouldErrorTwoDigitsCvc() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var twoDigitsCvc = DataHelper.getTwoDigitsCvc();
        paymentCardPage.cardInfo(twoDigitsCvc);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка 4 цифр в поле Cvc")
    void shouldErrorFourDigitsCvc() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var fourDigitsCvc = DataHelper.getFourDigitsCvc();
        paymentCardPage.cardInfo(fourDigitsCvc);
        paymentCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Cvc")
    void shouldErrorSymbolCvc() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var fourSymbolCvc = DataHelper.getSymbolCvc();
        paymentCardPage.cardInfo(fourSymbolCvc);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Cvc")
    void shouldErrorLettersCvc() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var fourLettersCvc = DataHelper.getLettersCvc();
        paymentCardPage.cardInfo(fourLettersCvc);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка пустой формы")
    void shouldNotSendEmptyForm() {
        var paymentCardPage = dashboardPage.payByPaymentCard();
        var emptyForm = DataHelper.getEmptyCardInfo();
        paymentCardPage.cardInfo(emptyForm);
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
    }

}

