package ru.netology.data;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {


    /*Поле Номер карты*/
    static String getApprovedCardNumber() { return "4444 4444 4444 4441"; }
    static String getDeclinedCardNumber() { return "4444 4444 4444 4442"; }
    static String getNotFullCardNumber() { return "4444 4444 4444 444"; }
    static String getInvalidCardNumber() { return "1234 1234 1234 1234"; }
    static String getSymbolCardNumber() { return "%$#@"; }
    static String getLetterCardNumber() { return "rytw iiyy iiui iyiy"; }
    static String getSymbol() { return "%$"; }
    static String getLetter() { return "df"; }


    /*Поле Месяц*/

    static String getValidMonth() { return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM")); }
    static String getInvalidMonth() { return "13"; }
    static String getZeroMonth() { return "00";}


    /*Поле Год*/

    static String getCurrentYear() { return LocalDate.now().format(DateTimeFormatter.ofPattern("yy")); }
    static String getValidExpirationDate() { return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy")); }
    static String getExpiredYear() { return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy")); }
    static String getLotsFutureYear() { return LocalDate.now().plusYears(4).format(DateTimeFormatter.ofPattern("yy")); }
    static String getShortYear() { return "2"; }


    /*Поле Владелец*/

    static String getValidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().name();
    }
    static String getInvalidThreeWordsOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().fullName();
    }
    static String getInvalidSymbolOwner() { return "$#$#$ $##$$$"; }
    static String getInvalidRuOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }
    static String getInvalidNumbersOwner() { return "11322 02023223"; }

    /*Поле CVC/CVV*/

    static String getValidCvc() { return "111"; }
    static String getTwoDigitsCvc() { return "23"; }
    static String getFourDigitsCvc() { return "6589"; }
    static String getSymbolCvc() { return "@#%"; }
    static String getLettersCvc() { return "adf"; }

}