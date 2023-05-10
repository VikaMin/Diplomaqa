package ru.netology.test;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
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
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val emptyCardNum = DataHelper.getEmptyCardNumber();
        paymentCardPage.cardInfo(emptyCardNum);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка короткого номера карты")
    void shouldErrorNotFullNumber() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val notFullCardInformation = DataHelper.getNotFullCardNumber();
        paymentCardPage.cardInfo(notFullCardInformation);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка несуществующего номера карты банка")
    void shouldErrorPayByNumber() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val invalidCardNumber = DataHelper.getInvalidCardNumber();
        paymentCardPage.cardInfo(invalidCardNumber);
        paymentCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Номер карты")
    void shouldErrorSymbolNumber() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val symbolCardNumber = DataHelper.getSymbolCardNumber();
        paymentCardPage.cardInfo(symbolCardNumber);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Номер карты")
    void shouldErrorLetterCardNumber() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val letterCardNumber = DataHelper.getLetterCardNumber();
        paymentCardPage.cardInfo(letterCardNumber);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле Месяц*/

    @Test
    @DisplayName("Отправка пустого поля месяц")
    void shouldErrorEmptyMonth() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val emptyMonth = DataHelper.getEmptyMonth();
        paymentCardPage.cardInfo(emptyMonth);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения 00 в поле месяц")
    void shouldErrorZeroMonth() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val zeroMonth = DataHelper.getZeroMonth();
        paymentCardPage.cardInfo(zeroMonth);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка нерелевантного значения, больше 12 в поле месяц")
    void shouldErrorInvalidMonth() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val invalidMonth = DataHelper.getInvalidMonth();
        paymentCardPage.cardInfo(invalidMonth);

        paymentCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле месяц")
    void shouldErrorSymbolMonth() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val symbolMonth = DataHelper.getSymbolMonth();
        paymentCardPage.cardInfo(symbolMonth);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле месяц")
    void shouldErrorLetterMonth() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val letterMonth = DataHelper.getLetterMonth();
        paymentCardPage.cardInfo(letterMonth);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле Год*/


    @Test
    @DisplayName("Отправка пустого поля год")
    void shouldErrorEmptyYear() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val emptyYear = DataHelper.getEmptyYear();
        paymentCardPage.cardInfo(emptyYear);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения меньше текущего года")
    void shouldErrorExpiredYear() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val expiredYear = DataHelper.getExpiredYear();
        paymentCardPage.cardInfo(expiredYear);

        paymentCardPage.waitIfMessCardExpired();
    }

    @Test
    @DisplayName("Отправка значения большего текущего года на 3")
    void shouldErrorLotsFutureYear() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val lotsFutureYear = DataHelper.getLotsFutureYear();
        paymentCardPage.cardInfo(lotsFutureYear);

        paymentCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка значения менее 2 цифр в поле год")
    void shouldErrorShortYear() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val shortYear = DataHelper.getShortYear();
        paymentCardPage.cardInfo(shortYear);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле год")
    void shouldErrorSymbolYear() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val symbolYear = DataHelper.getSymbolYear();
        paymentCardPage.cardInfo(symbolYear);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле год")
    void shouldErrorLetterYear() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val letterYear = DataHelper.getLetterYear();
        paymentCardPage.cardInfo(letterYear);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле Владелец*/


    @Test
    @DisplayName("Отправка пустого поля владелец")
    void shouldErrorEmptyOwner() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val emptyOwner = DataHelper.getEmptyOwner();
        paymentCardPage.cardInfo(emptyOwner);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка трех и более слов латинскими буквами в поле владелец")
    void shouldErrorThreeWordsOwner() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val threeWordsOwner = DataHelper.getThreeWordsOwner();
        paymentCardPage.cardInfo(threeWordsOwner);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле владелец")
    void shouldErrorSymbolOwner() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val symbolOwner = DataHelper.getSymbolOwner();
        paymentCardPage.cardInfo(symbolOwner);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка слов кириллицей в поле владелец")
    void shouldErrorInvalidRuOwner() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val invalidRuOwner = DataHelper.getInvalidRuOwner();
        paymentCardPage.cardInfo(invalidRuOwner);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка чисел в поле владелец")
    void shouldErrorNumbersOwner() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val invalidNumbersOwner = DataHelper.getInvalidNumbersOwner();
        paymentCardPage.cardInfo(invalidNumbersOwner);
        paymentCardPage.waitIfMessRequiredField();
    }


    /*Поле CVC/CVV*/


    @Test
    @DisplayName("Отправка пустого поля Cvc")
    void shouldErrorEmptyCvc() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val emptyCvc = DataHelper.getEmptyCvc();
        paymentCardPage.cardInfo(emptyCvc);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка 2 цифр в поле Cvc")
    void shouldErrorTwoDigitsCvc() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val twoDigitsCvc = DataHelper.getTwoDigitsCvc();
        paymentCardPage.cardInfo(twoDigitsCvc);
        paymentCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка 4 цифр в поле Cvc")
    void shouldErrorFourDigitsCvc() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val fourDigitsCvc = DataHelper.getFourDigitsCvc();
        paymentCardPage.cardInfo(fourDigitsCvc);
        paymentCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Cvc")
    void shouldErrorSymbolCvc() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val fourSymbolCvc = DataHelper.getSymbolCvc();
        paymentCardPage.cardInfo(fourSymbolCvc);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Cvc")
    void shouldErrorLettersCvc() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val fourLettersCvc = DataHelper.getLettersCvc();
        paymentCardPage.cardInfo(fourLettersCvc);
        paymentCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка пустой формы")
    void shouldNotSendEmptyForm() {
        val paymentCardPage = dashboardPage.payByPaymentCard();
        val emptyForm = DataHelper.getEmptyCardInfo();
        paymentCardPage.cardInfo(emptyForm);
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
        paymentCardPage.waitIfMessRequiredField();
    }

}