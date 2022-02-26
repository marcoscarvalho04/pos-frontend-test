package com.thiago.teste;

import com.thiago.page.PageGuruDragAndDrop;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GuruDragDropTest {

    private PageGuruDragAndDrop pageGuruDragAndDrop;

    private static final String BASE_URL = "https://demo.guru99.com/test/drag_drop.html";

    private static final String CREDIT0_NEGATIVO = "-5000";

    private static final String CREDIT0_POSITIVO = "5000";

    @BeforeTest
    public void setupTests() {
        this.pageGuruDragAndDrop = new PageGuruDragAndDrop().openPage(PageGuruDragAndDrop.class, BASE_URL);
    }

    @AfterMethod
    public void afterTests() {
        this.pageGuruDragAndDrop.driver.get(BASE_URL);
    }

    @AfterClass
    public void afterClassTest() {
        this.pageGuruDragAndDrop.driver.close();
    }




    @Test
    public void dragDebitElementToDebitSideTest(){

        this.pageGuruDragAndDrop.moveDebitElementToBankDraggedOptions();
        this.validateIsEmpty(this.pageGuruDragAndDrop.getAllElementsFromCreditDraggedOptions());

    }

    @Test
    public void dragSecondCreditElementToDebitSideTest() {

        this.pageGuruDragAndDrop.moveSecondCreditElementToBankDraggedOptions();
        List<String> allElements = this.pageGuruDragAndDrop.getAllElementsFromCreditDraggedOptions();
        Assert.assertEquals(this.validateElementNotExists(allElements,CREDIT0_NEGATIVO), true);

    }

    @Test
    public void dragBankButtonToDebitSideTest() {

        String bankElement = "BANK";
        this.pageGuruDragAndDrop.moveBankButtonToBankDraggedOptions();
        List<String> allElements = this.pageGuruDragAndDrop.getAllElementsFromCreditDraggedOptions();
        Assert.assertTrue(this.validateElementExists(allElements, bankElement));

    }

    @Test
    public void dragPositiveDebitButtonToDebitSite() {

        this.pageGuruDragAndDrop.moveDebitElementoToDebitSite();
        List<String> allElements = this.pageGuruDragAndDrop.getAllElementsFromDebitDraggedOptions();
        Assert.assertTrue(this.validateElementExists(allElements, CREDIT0_POSITIVO));

    }

    @Test
    public void dragNegativeDebitButtontoDebitSite() {

        this.pageGuruDragAndDrop.moveNegativeDebitElementToDebitSite();
        List<String> allElements = this.pageGuruDragAndDrop.getAllElementsFromDebitDraggedOptions();
        Assert.assertTrue(this.validateElementNotExists(allElements, CREDIT0_NEGATIVO));

    }

    public void validateIsEmpty(List<String> elements) {

        if (!elements.isEmpty()) {
            throw new IllegalArgumentException("Expected empty list.  Got : "+elements.size() + " elements");
        }
    }

    @Test
    public void dragCreditElementToDebitSideTest(){

        this.pageGuruDragAndDrop.moveCreditElementToBankDraggedOptions();
        this.validateIsEmpty(this.pageGuruDragAndDrop.getAllElementsFromCreditDraggedOptions());

    }
    public boolean validateElementExists(List<String> elements, String element) {

       for (String listElement: elements ) {
           if (listElement.trim().equals(element)) {
               return true;
           }
       }

        return false;

    }

    public boolean validateElementNotExists(List<String> elements, String element) {

        return !this.validateElementExists(elements, element);
    }

    public void validateDebitSide(String element) {

        List<String> allElements = this.pageGuruDragAndDrop.getAllElementsFromCreditDraggedOptions();
        Assert.assertEquals(this.validateElementExists(allElements, element), true );
    }
}
