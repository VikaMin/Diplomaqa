package ru.netology.test;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.data.SqlHelper;
import static com.codeborne.selenide.Selenide.open;
public class CreditCardTest {

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
    void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SqlHelper.cleanDataBase();
    }


    /*Поле Номер карты*/


    @Test
    @DisplayName("Отправка пустого поля Номер карты")
    void shouldErrorEmptyCardNumber() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var emptyCardNum = DataHelper.getEmptyCardNumber();
        creditCardPage.cardInfo(emptyCardNum);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка короткого номера карты")
    void shouldErrorNotFullNumber() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var notFullCardInformation = DataHelper.getNotFullCardNumber();
        creditCardPage.cardInfo(notFullCardInformation);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка несуществующего номера карты банка")
    void shouldErrorPayByNumber() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var invalidCardNumber = DataHelper.getInvalidCardNumber();
        creditCardPage.cardInfo(invalidCardNumber);
        creditCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Номер карты")
    void shouldErrorSymbolNumber() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var symbolCardNumber = DataHelper.getSymbolCardNumber();
        creditCardPage.cardInfo(symbolCardNumber);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Номер карты")
    void shouldErrorLetterCardNumber() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var letterCardNumber = DataHelper.getLetterCardNumber();
        creditCardPage.cardInfo(letterCardNumber);
        creditCardPage.waitIfMessRequiredField();
    }



    /*Поле Месяц*/

    @Test
    @DisplayName("Отправка пустого поля месяц")
    void shouldErrorEmptyMonth() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var emptyMonth = DataHelper.getEmptyMonth();
        creditCardPage.cardInfo(emptyMonth);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения 00 в поле месяц")
    void shouldErrorZeroMonth() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var zeroMonth = DataHelper.getZeroMonth();
        creditCardPage.cardInfo(zeroMonth);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка нерелевантного значения, больше 12 в поле месяц")
    void shouldErrorInvalidMonth() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var invalidMonth = DataHelper.getInvalidMonth();
        creditCardPage.cardInfo(invalidMonth);

        creditCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле месяц")
    void shouldErrorSymbolMonth() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var symbolMonth = DataHelper.getSymbolMonth();
        creditCardPage.cardInfo(symbolMonth);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле месяц")
    void shouldErrorLetterMonth() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var letterMonth = DataHelper.getLetterMonth();
        creditCardPage.cardInfo(letterMonth);
        creditCardPage.waitIfMessRequiredField();
    }


    /*Поле Год*/

    @Test
    @DisplayName("Отправка пустого поля год")
    void shouldErrorEmptyYear() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var emptyYear = DataHelper.getEmptyYear();
        creditCardPage.cardInfo(emptyYear);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения меньше текущего года")
    void shouldErrorExpiredYear() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var expiredYear = DataHelper.getExpiredYear();
        creditCardPage.cardInfo(expiredYear);

        creditCardPage.waitIfMessCardExpired();
    }

    @Test
    @DisplayName("Отправка значения большего текущего года на 3")
    void shouldErrorLotsFutureYear() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var lotsFutureYear = DataHelper.getLotsFutureYear();
        creditCardPage.cardInfo(lotsFutureYear);

        creditCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка значения менее 2 цифр в поле год")
    void shouldErrorShortYear() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var shortYear = DataHelper.getShortYear();
        creditCardPage.cardInfo(shortYear);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле год")
    void shouldErrorSymbolYear() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var symbolYear = DataHelper.getSymbolYear();
        creditCardPage.cardInfo(symbolYear);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле год")
    void shouldErrorLetterYear() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var letterYear = DataHelper.getLetterYear();
        creditCardPage.cardInfo(letterYear);
        creditCardPage.waitIfMessRequiredField();
    }


    /*Поле Владелец*/

    @Test
    @DisplayName("Отправка пустого поля владелец")
    void shouldErrorEmptyOwner() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var emptyOwner = DataHelper.getEmptyOwner();
        creditCardPage.cardInfo(emptyOwner);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка трех и более слов латинскими буквами в поле владелец")
    void shouldErrorThreeWordsOwner() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var threeWordsOwner = DataHelper.getThreeWordsOwner();
        creditCardPage.cardInfo(threeWordsOwner);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле владелец")
    void shouldErrorSymbolOwner() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var symbolOwner = DataHelper.getSymbolOwner();
        creditCardPage.cardInfo(symbolOwner);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка слов кириллицей в поле владелец")
    void shouldErrorInvalidRuOwner() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var invalidRuOwner = DataHelper.getInvalidRuOwner();
        creditCardPage.cardInfo(invalidRuOwner);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка чисел в поле владелец")
    void shouldErrorNumbersOwner() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var invalidNumbersOwner = DataHelper.getInvalidNumbersOwner();
        creditCardPage.cardInfo(invalidNumbersOwner);
        creditCardPage.waitIfMessRequiredField();
    }


    /*Поле CVC/CVV*/

    @Test
    @DisplayName("Отправка пустого поля Cvc")
    void shouldErrorEmptyCvc() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var emptyCvc = DataHelper.getEmptyCvc();
        creditCardPage.cardInfo(emptyCvc);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка 2 цифр в поле Cvc")
    void shouldErrorTwoDigitsCvc() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var twoDigitsCvc = DataHelper.getTwoDigitsCvc();
        creditCardPage.cardInfo(twoDigitsCvc);
        creditCardPage.waitIfMessWrongFormat();
    }


    @Test
    @DisplayName("Отправка 4 цифр в поле Cvc")
    void shouldErrorFourDigitsCvc() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var fourDigitsCvc = DataHelper.getFourDigitsCvc();
        creditCardPage.cardInfo(fourDigitsCvc);
        creditCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Cvc")
    void shouldErrorSymbolCvc() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var fourSymbolCvc = DataHelper.getSymbolCvc();
        creditCardPage.cardInfo(fourSymbolCvc);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Cvc")
    void shouldErrorLettersCvc() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var fourLettersCvc = DataHelper.getLettersCvc();
        creditCardPage.cardInfo(fourLettersCvc);
        creditCardPage.waitIfMessRequiredField();
    }


    @Test
    @DisplayName("Отправка пустой формы")
    void shouldNotSendEmptyForm() {
        var creditCardPage = dashboardPage.payByCreditCard();
        var emptyForm = DataHelper.getEmptyCardInfo();
        creditCardPage.cardInfo(emptyForm);
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
    }

}

