package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class PaymentCardPage {

    private final SelenideElement fieldNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement fieldMonth = $("[placeholder='08']");
    private final SelenideElement fieldYear = $("[placeholder='22']");
    private final SelenideElement fieldOwner = $(byText("Владелец")).parent().$(".input__control");
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

    public void waitIfMessSuccess() { successNotification.shouldBe(Condition.visible, Duration.ofMillis(15000)); }

    public void waitIfMessFail() { failNotification.shouldBe(Condition.visible, Duration.ofMillis(15000)); }

    public void waitIfMessRequiredField() { messRequiredField.shouldBe(Condition.visible); }

    public void waitIfMessWrongFormat() { messWrongFormat.shouldBe(Condition.visible); }

    public void waitIfMessWrongTerm() { messWrongTerm.shouldBe(Condition.visible); }

    public void waitIfMessCardExpired() { messCardExpired.shouldBe(Condition.visible); }

}

