package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContractModificationTests extends TestBase{

    @Test
    public void testContractModification(){
        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
//        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContect()){
            app.getContactHelper().createContact(new ContactData("Max", "Korj", "Urala str. 55", "77777777777", "hahaha@mail.com", null));
        }
        app.goTo().changeContract();
        app.getContactHelper().fillContactForm(new ContactData("Max", "Korj", "Urala str. 55", "77777777777", "hahaha@mail.com", null), false);
        app.goTo().moveToNeed();
        app.getContactHelper().submitContactUpdate();
        List<ContactData> after = app.getContactHelper().getContactList();
//        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(1);
            Assert.assertEquals(before,after);
    }
}
