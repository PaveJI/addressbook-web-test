package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContractModificationTests extends TestBase{

    @Test (enabled = false)
    public void testContractModification(){
        app.goTo().gotoHomePage();
        app.goTo().changeContract();
        app.getContactHelper().fillContactForm(new ContactData("Max", "Korj", "Urala str. 55", "77777777777", "hahaha@mail.com", null), false);
        app.goTo().moveToNeed();
        app.getContactHelper().submitContactUpdate();


    }
}
