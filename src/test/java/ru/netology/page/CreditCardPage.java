package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CreditCardPage {

    private final SelenideElement fieldNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement fieldMonth = $("[placeholder='08']");
    private final SelenideElement fieldYear = $("[placeholder='22']");
    private final SelenideElement fieldOwner = $(byText("Владелец")).parent().$(".input__control");;
    private final SelenideElement fieldCvc = $("[placeholder='999']");
    private final SelenideElement continueButton = $$(".button").find(exactText("Продолжить"));
    private final SelenideElement successNotification = $(byText("Операция одобрена Банком."));
    private final SelenideElement failNotification = $(byText("Ошибка! Банк отказал в проведении операции."));

    private final SelenideElement messRequiredField = $(byText("Поле обязательно для заполнения"));

    private final SelenideElement messWrongFormat = $(byText("Неверный формат"));

    private final SelenideElement messWrongTerm = $(byText("Неверно указан срок действия карты"));

    private final SelenideElement messCardExpired = $(byText("Истёк срок действия карты"));


    public void cardInfo(DataHelper.CardInfo cardInfo) {
        fieldNumber.setValue(cardInfo.getCardNumber());
        fieldMonth.setValue(cardInfo.getMonth());
        fieldYear.setValue(cardInfo.getYear());
        fieldOwner.setValue(cardInfo.getOwner());
        fieldCvc.setValue(cardInfo.getCvc());
        continueButton.click();
    }

    public void waitIfMessSuccess() { successNotification.waitUntil(visible, 15000); }

    public void waitIfMessFail() {
        failNotification.waitUntil(visible, 15000);
    }

    public void waitIfMessRequiredField() {
        messRequiredField.waitUntil(visible, 10000);
    }

    public void waitIfMessWrongFormat() {
        messWrongFormat.waitUntil(visible, 10000);
    }

    public void waitIfMessWrongTerm() {
        messWrongTerm.waitUntil(visible, 10000);
    }

    public void waitIfMessCardExpired() {
        messCardExpired.waitUntil(visible, 10000);
    }


}
