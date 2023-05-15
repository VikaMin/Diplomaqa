package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    LocalDate today = LocalDate.now();
    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");


    /*Поле Номер карты*/
    protected static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }
    protected static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }
    protected static String getNotFullCardNumber() {
        return "4444 4444 4444 444";
    }
    protected static String getInvalidCardNumber() {
        return "1234 1234 1234 1234";
    }

/*   protected static String getZeroCardNumber() {
        return "0000 0000 0000 0000";
    }*/
    protected static String getSymbolCardNumber() {
        return "%$#@";
    }
    protected static String getLetterCardNumber() {
        return "rytw iiyy iiui iyiy";
    }

    /*Поле Месяц*/

    @Value
    protected static class Month {
        String month;
    }
    protected Month getValidMonth() {
        LocalDate newMonth = today.plusMonths(1);
        return new Month(monthFormatter.format(newMonth));
    }

    protected Month getInvalidMonth() {
        return new Month("13");
    }
    protected Month getZeroMonth() {
        return new Month("00");
    }
    protected Month getSymbolMonth() {
        return new Month("%$");
    }
    protected Month getLetterMonth() {
        return new Month("df");
    }

    /*Поле Год*/

    @Value
    protected static class Year {
        String year;
    }
    protected Year getCurrentYear() {
        LocalDate currentYear = LocalDate.now();
        return new Year(yearFormatter.format(currentYear));
    }
    protected Year getValidExpirationDate() {
        LocalDate newYear = today.plusYears(1);
        return new Year(yearFormatter.format(newYear));
    }
    protected Year getExpiredYear() {
        LocalDate newYear = today.minusYears(1);
        return new Year(yearFormatter.format(newYear));
    }
    protected Year getLotsFutureYear() {
        LocalDate newYear = today.plusYears(3);
        return new Year(yearFormatter.format(newYear));
    }
    protected Year getShortYear() { return new Year("2"); }
    protected Year getSymbolYear() { return new Year("%$");
    }
    protected Year getLetterYear() { return new Year("df");
    }

    /*Поле Владелец*/

    protected static String getValidOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().name();
    }

    protected static String getInvalidThreeWordsOwner() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().fullName();
    }

    protected static String getInvalidSymbolOwner() {
        return "$#$#$ $##$$$";
    }

    protected static String getInvalidRuOwner() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    protected static String getInvalidNumbersOwner() {
        return "11322 02023223";
    }

    /*Поле CVC/CVV*/

    protected static String getValidCvc() { return "111"; }

    protected static String getTwoDigitsCvc() {
        return "23";
    }

    protected static String getFourDigitsCvc() {
        return "6589";
    }

    protected static String getSymbolCvc() {
        return "@#%";
    }

    protected static String getLettersCvc() {
        return "adf";
    }

}