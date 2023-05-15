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
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SqlHelper.cleanDataBase();
    }


    /*Поле Номер карты*/


    @Test
    @DisplayName("Отправка пустого поля Номер карты")
    void shouldErrorEmptyCardNumber() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val emptyCardNum = DataHelper.getEmptyCardNumber();
        creditCardPage.cardInfo(emptyCardNum);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка короткого номера карты")
    void shouldErrorNotFullNumber() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val notFullCardInformation = DataHelper.getNotFullCardNumber();
        creditCardPage.cardInfo(notFullCardInformation);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка несуществующего номера карты банка")
    void shouldErrorPayByNumber() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val invalidCardNumber = DataHelper.getInvalidCardNumber();
        creditCardPage.cardInfo(invalidCardNumber);
        creditCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Номер карты")
    void shouldErrorSymbolNumber() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val symbolCardNumber = DataHelper.getSymbolCardNumber();
        creditCardPage.cardInfo(symbolCardNumber);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Номер карты")
    void shouldErrorLetterCardNumber() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val letterCardNumber = DataHelper.getLetterCardNumber();
        creditCardPage.cardInfo(letterCardNumber);
        creditCardPage.waitIfMessRequiredField();
    }



    /*Поле Месяц*/

    @Test
    @DisplayName("Отправка пустого поля месяц")
    void shouldErrorEmptyMonth() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val emptyMonth = DataHelper.getEmptyMonth();
        creditCardPage.cardInfo(emptyMonth);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения 00 в поле месяц")
    void shouldErrorZeroMonth() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val zeroMonth = DataHelper.getZeroMonth();
        creditCardPage.cardInfo(zeroMonth);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка нерелевантного значения, больше 12 в поле месяц")
    void shouldErrorInvalidMonth() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val invalidMonth = DataHelper.getInvalidMonth();
        creditCardPage.cardInfo(invalidMonth);

        creditCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле месяц")
    void shouldErrorSymbolMonth() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val symbolMonth = DataHelper.getSymbolMonth();
        creditCardPage.cardInfo(symbolMonth);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле месяц")
    void shouldErrorLetterMonth() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val letterMonth = DataHelper.getLetterMonth();
        creditCardPage.cardInfo(letterMonth);
        creditCardPage.waitIfMessRequiredField();
    }


    /*Поле Год*/

    @Test
    @DisplayName("Отправка пустого поля год")
    void shouldErrorEmptyYear() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val emptyYear = DataHelper.getEmptyYear();
        creditCardPage.cardInfo(emptyYear);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка значения меньше текущего года")
    void shouldErrorExpiredYear() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val expiredYear = DataHelper.getExpiredYear();
        creditCardPage.cardInfo(expiredYear);

        creditCardPage.waitIfMessCardExpired();
    }

    @Test
    @DisplayName("Отправка значения большего текущего года на 3")
    void shouldErrorLotsFutureYear() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val lotsFutureYear = DataHelper.getLotsFutureYear();
        creditCardPage.cardInfo(lotsFutureYear);

        creditCardPage.waitIfMessWrongTerm();
    }

    @Test
    @DisplayName("Отправка значения менее 2 цифр в поле год")
    void shouldErrorShortYear() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val shortYear = DataHelper.getShortYear();
        creditCardPage.cardInfo(shortYear);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле год")
    void shouldErrorSymbolYear() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val symbolYear = DataHelper.getSymbolYear();
        creditCardPage.cardInfo(symbolYear);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле год")
    void shouldErrorLetterYear() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val letterYear = DataHelper.getLetterYear();
        creditCardPage.cardInfo(letterYear);
        creditCardPage.waitIfMessRequiredField();
    }


    /*Поле Владелец*/

    @Test
    @DisplayName("Отправка пустого поля владелец")
    void shouldErrorEmptyOwner() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val emptyOwner = DataHelper.getEmptyOwner();
        creditCardPage.cardInfo(emptyOwner);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка трех и более слов латинскими буквами в поле владелец")
    void shouldErrorThreeWordsOwner() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val threeWordsOwner = DataHelper.getThreeWordsOwner();
        creditCardPage.cardInfo(threeWordsOwner);
        creditCardPage.waitIfMessWrongFormat();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле владелец")
    void shouldErrorSymbolOwner() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val symbolOwner = DataHelper.getSymbolOwner();
        creditCardPage.cardInfo(symbolOwner);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка слов кириллицей в поле владелец")
    void shouldErrorInvalidRuOwner() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val invalidRuOwner = DataHelper.getInvalidRuOwner();
        creditCardPage.cardInfo(invalidRuOwner);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка чисел в поле владелец")
    void shouldErrorNumbersOwner() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val invalidNumbersOwner = DataHelper.getInvalidNumbersOwner();
        creditCardPage.cardInfo(invalidNumbersOwner);
        creditCardPage.waitIfMessRequiredField();
    }


    /*Поле CVC/CVV*/

    @Test
    @DisplayName("Отправка пустого поля Cvc")
    void shouldErrorEmptyCvc() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val emptyCvc = DataHelper.getEmptyCvc();
        creditCardPage.cardInfo(emptyCvc);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка 2 цифр в поле Cvc")
    void shouldErrorTwoDigitsCvc() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val twoDigitsCvc = DataHelper.getTwoDigitsCvc();
        creditCardPage.cardInfo(twoDigitsCvc);
        creditCardPage.waitIfMessWrongFormat();
    }


    @Test
    @DisplayName("Отправка 4 цифр в поле Cvc")
    void shouldErrorFourDigitsCvc() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val fourDigitsCvc = DataHelper.getFourDigitsCvc();
        creditCardPage.cardInfo(fourDigitsCvc);
        creditCardPage.waitIfMessFail();
    }

    @Test
    @DisplayName("Отправка символьных значений в поле Cvc")
    void shouldErrorSymbolCvc() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val fourSymbolCvc = DataHelper.getSymbolCvc();
        creditCardPage.cardInfo(fourSymbolCvc);
        creditCardPage.waitIfMessRequiredField();
    }

    @Test
    @DisplayName("Отправка букв в поле Cvc")
    void shouldErrorLettersCvc() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val fourLettersCvc = DataHelper.getLettersCvc();
        creditCardPage.cardInfo(fourLettersCvc);
        creditCardPage.waitIfMessRequiredField();
    }


    @Test
    @DisplayName("Отправка пустой формы")
    void shouldNotSendEmptyForm() {
        val creditCardPage = dashboardPage.payByCreditCard();
        val emptyForm = DataHelper.getEmptyCardInfo();
        creditCardPage.cardInfo(emptyForm);
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
        creditCardPage.waitIfMessRequiredField();
    }

}
