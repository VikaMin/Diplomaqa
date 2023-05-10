package ru.netology.data;

import lombok.Value;



public class DataHelper {
    static DataGenerator dataGenerator = new DataGenerator();




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
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo(DataGenerator.getDeclinedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    // Поле Номер карты

    public static CardInfo getEmptyCardNumber() {
        return new CardInfo(" ", dataGenerator.getCurrentYear().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getNotFullCardNumber() {
        return new CardInfo(DataGenerator.getNotFullCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getInvalidCardNumber() {
        return new CardInfo(DataGenerator.getInvalidCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getSymbolCardNumber() {
        return new CardInfo(DataGenerator.getSymbolCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getLetterCardNumber() {
        return new CardInfo(DataGenerator.getLetterCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

   // Поле Месяц

    public static CardInfo getEmptyMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getCurrentYear().getYear(), "", DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getZeroMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getCurrentYear().getYear(), dataGenerator.getZeroMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getCurrentYear().getYear(), dataGenerator.getInvalidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getSymbolMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getCurrentYear().getYear(), dataGenerator.getSymbolMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }
    public static CardInfo getLetterMonth() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getCurrentYear().getYear(), dataGenerator.getLetterMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    /*Поле Год*/

    public static CardInfo getEmptyYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), "", dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getExpiredYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getExpiredYear().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getLotsFutureYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getLotsFutureYear().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getShortYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getShortYear().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getSymbolYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getSymbolYear().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getLetterYear() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getLetterYear().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getValidCvc());
    }

    /*Поле Владелец*/

    public static CardInfo getEmptyOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getCurrentYear().getYear(), dataGenerator.getValidMonth().getMonth(), "", DataGenerator.getValidCvc());
    }

    public static CardInfo getThreeWordsOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getInvalidThreeWordsOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getSymbolOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getInvalidSymbolOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidRuOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getInvalidRuOwner(), DataGenerator.getValidCvc());
    }

    public static CardInfo getInvalidNumbersOwner() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getInvalidNumbersOwner(), DataGenerator.getValidCvc());
    }

    /*Поле CVC/CVV*/

    public static CardInfo getEmptyCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), "");
    }
    public static CardInfo getTwoDigitsCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getTwoDigitsCvc());
    }

    public static CardInfo getFourDigitsCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getFourDigitsCvc());
    }
    public static CardInfo getSymbolCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getSymbolCvc());
    }
    public static CardInfo getLettersCvc() {
        return new CardInfo(DataGenerator.getApprovedCardNumber(), dataGenerator.getValidExpirationDate().getYear(), dataGenerator.getValidMonth().getMonth(), DataGenerator.getValidOwner(), DataGenerator.getLettersCvc());
    }

    // Пустая форма
    public static CardInfo getEmptyCardInfo() {
        return new CardInfo(" ", " ", " ", " ", " ");
    }


}