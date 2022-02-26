package com.thiago.page;

import com.google.common.collect.Lists;
import com.thiago.core.CorePage;
import com.thiago.driver.TLDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageGuruDragAndDrop extends CorePage<PageGuruDragAndDrop> {

    @FindBy(id = "credit")
    private WebElement creditElement;

    @FindBy(id = "fourth")
    private WebElement debitElement;

    @FindBy(id = "credit0")
    private WebElement secondCreditElement;

    @FindBy(id = "credit2")
    private WebElement bankButton;

    @FindBy(id = "credit1")
    private WebElement salesButton;

    @FindBy(id = "credit3")
    private WebElement ownersEquityButton;

    @FindBy(id = "credit4")
    private WebElement loanButton;

    @FindBy(id = "bank")
    private WebElement bankDraggedOptions;

    @FindBy(id = "amt7")
    private WebElement amoutBankDreggedOptions;

    @FindBy(id = "loan")
    private WebElement loanDraggedOptions;

    @FindBy(id = "amt7")
    private WebElement debitSiteDraggedOptions;


    public void moveCreditElementToBankDraggedOptions() {

        this.moveElement(creditElement, bankDraggedOptions);

    }
    public void moveDebitElementToBankDraggedOptions(){

        this.moveElement(debitElement, bankDraggedOptions);

    }
    public void moveSecondCreditElementToBankDraggedOptions() {

        this.moveElement(secondCreditElement, bankDraggedOptions);

    }

    public void moveBankButtonToBankDraggedOptions() {

        this.moveElement(bankButton, bankDraggedOptions);

    }

    public void moveDebitElementoToDebitSite() {

        this.moveElement(debitElement, amoutBankDreggedOptions);

    }

    public void moveNegativeDebitElementToDebitSite() {

        this.moveElement(secondCreditElement, amoutBankDreggedOptions);

    }

    private void moveElement(WebElement source, WebElement destination ) {

        Actions actions = new Actions(driver);
        Action dragAndDrop = actions.clickAndHold(source).moveToElement(destination).release().build();
        dragAndDrop.perform();

    }

    public List<String> getDraggedElements(WebElement elementToGetItens) {

        List<String> allElementsDragged = Lists.newArrayList();
        List<WebElement> allElements = elementToGetItens.findElements(By.tagName("li"));

        for (WebElement element: allElements) {
            if (element.getText().trim().isEmpty()) {
                continue;
            }
            allElementsDragged.add(element.getText());
        }

        return allElementsDragged;

    }
    public List<String> getAllElementsFromCreditDraggedOptions(){

        return this.getDraggedElements(bankDraggedOptions);

    }

    public List<String> getAllElementsFromDebitDraggedOptions() {

        return this.getDraggedElements(debitSiteDraggedOptions);

    }

}
