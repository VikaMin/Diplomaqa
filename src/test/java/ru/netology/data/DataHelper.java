package ru.netology.data;
import lombok.Value;

public class DataHelper {



    @Value
    public static class CardInfo {
        String cardNumber;
        String year;
        String month;
        String owner;
        String cvc;
    }


    // Позитивные сценарии

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo(DataGenerator.getDeclinedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    // Поле Номер карты

    public static CardInfo getEmptyCardNumber() {
        return new CardInfo(" ", DataGenerator.getCurrentYear(0), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getNotFullCardNumber() {
        return new CardInfo(DataGenerator.getNotFullCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getInvalidCardNumber() {
        return new CardInfo(DataGenerator.getInvalidCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getSymbolCardNumber() {
        return new CardInfo(DataGenerator.getSymbolCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getLetterCardNumber() {
        return new CardInfo(DataGenerator.getLetterCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    // Поле Месяц

    public static CardInfo getEmptyMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(0), "", DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getZeroMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(0), DataGenerator.getZeroMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(0), DataGenerator.getInvalidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getSymbolMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(0), DataGenerator.getSymbol(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getLetterMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(0), DataGenerator.getLetter(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    /*Поле Год*/

    public static CardInfo getEmptyYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), "", DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getExpiredYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(-1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getLotsFutureYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(4), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getShortYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getShortYear(), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getSymbolYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getSymbol(), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getLetterYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getLetter(), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    /*Поле Владелец*/

    public static CardInfo getEmptyOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(0), DataGenerator.getValidMonth(), "", DataGenerator.getValidCvc());
    }

    public static CardInfo getThreeWordsOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getInvalidThreeWordsOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getSymbolOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getInvalidSymbolOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidRuOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getInvalidRuOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidNumbersOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getInvalidNumbersOwner(), DataGenerator.getValidCvc());
    }

    /*Поле CVC/CVV*/

    public static CardInfo getEmptyCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), "");
    }
    public static CardInfo getTwoDigitsCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getTwoDigitsCvc());
    }

    public static CardInfo getFourDigitsCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getFourDigitsCvc());
    }
    public static CardInfo getSymbolCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getSymbolCvc());
    }
    public static CardInfo getLettersCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), DataGenerator.getCurrentYear(1), DataGenerator.getValidMonth(), DataGenerator.getValidOwner(), DataGenerator.getLettersCvc());
    }

    // Пустая форма
    public static CardInfo getEmptyCardInfo() {
        return new CardInfo(" ", " ", " ", " ", " ");
    }

}

