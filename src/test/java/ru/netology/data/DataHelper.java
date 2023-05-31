package ru.netology.data;
import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {


    @Value
    public static class CardInfo {
        String cardNumber;
        String year;
        String month;
        String owner;
        String cvc;
    }

    public static Faker faker = new Faker(new Locale("en"));
    public static CardInfo getValidCard() {

        var cardNumber = "4444 4444 4444 4441";
        var year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
        var month = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
        var owner = faker.name().name();
        var cvc = "111";
        return new CardInfo(cardNumber, year, month, owner, cvc);
    }


    // Позитивные сценарии


    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo("4444 4444 4444 4442", getValidCard().year, getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    // Поле Номер карты

    public static CardInfo getEmptyCardNumber() {
        return new CardInfo(" ", getValidCard().year, getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }
    public static CardInfo getNotFullCardNumber() {
        return new CardInfo("4444 4444 4444 444", getValidCard().year, getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }
    public static CardInfo getInvalidCardNumber() {
        return new CardInfo("1234 1234 1234 1234", getValidCard().year, getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }
    public static CardInfo getSymbolCardNumber() {
        return new CardInfo("%$#@", getValidCard().year, getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }
    public static CardInfo getLetterCardNumber() {
        return new CardInfo("rytw iiyy iiui iyiy", getValidCard().year, getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    // Поле Месяц

    public static CardInfo getEmptyMonth() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, "", getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getZeroMonth() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, "00", getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getInvalidMonth() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, "13", getValidCard().owner, getValidCard().cvc);
    }
    public static CardInfo getSymbolMonth() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year,"%$", getValidCard().owner, getValidCard().cvc);
    }
    public static CardInfo getLetterMonth() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, "df", getValidCard().owner, getValidCard().cvc);
    }

    /*Поле Год*/

    public static CardInfo getEmptyYear() {
        return new CardInfo(getValidCard().cardNumber, "", getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getExpiredYear() {
        return new CardInfo(getValidCard().cardNumber, "22", getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getLotsFutureYear() {
        return new CardInfo(getValidCard().cardNumber, "25", getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getShortYear() {
        return new CardInfo(getValidCard().cardNumber, "2", getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getSymbolYear() {
        return new CardInfo(getValidCard().cardNumber, "%$", getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    public static CardInfo getLetterYear() {
        return new CardInfo(getValidCard().cardNumber, "df", getValidCard().month, getValidCard().owner, getValidCard().cvc);
    }

    /*Поле Владелец*/

    public static CardInfo getEmptyOwner() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, "", getValidCard().cvc);
    }

    public static CardInfo getThreeWordsOwner() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, "Smit Wolf Nird-Fart_Bort", getValidCard().cvc);
    }

    public static CardInfo getSymbolOwner() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, "$#$#$ $##$$$", getValidCard().cvc);
    }

    public static CardInfo getInvalidRuOwner() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, "Иванова Екатерина Ивановна", getValidCard().cvc);
    }

    public static CardInfo getInvalidNumbersOwner() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, "11322 02023223", getValidCard().cvc);
    }

    /*Поле CVC/CVV*/

    public static CardInfo getEmptyCvc() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, getValidCard().owner, "");
    }
    public static CardInfo getTwoDigitsCvc() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, getValidCard().owner, "23");
    }

    public static CardInfo getFourDigitsCvc() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, getValidCard().owner, "6589");
    }
    public static CardInfo getSymbolCvc() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, getValidCard().owner, "@#%");
    }
    public static CardInfo getLettersCvc() {
        return new CardInfo(getValidCard().cardNumber, getValidCard().year, getValidCard().month, getValidCard().owner, "adf");
    }

    // Пустая форма
    public static CardInfo getEmptyCardInfo() {
        return new CardInfo(" ", " ", " ", " ", " ");
    }

}

