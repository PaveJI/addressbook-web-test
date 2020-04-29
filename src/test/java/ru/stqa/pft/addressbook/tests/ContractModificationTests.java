package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContractModificationTests extends TestBase{

    @Test
    public void testContractModification(){
        app.goTo().gotoHomePage();
        List<ContactData> before = app.contact().list();
        if (! app.contact().isThereAContect()){
            app.contact().createContact(new ContactData().withName("Max").withLastName("Korj").withAddress("Urala str. 55").withMobPhone("77777777777").witheMail("hahaha@mail.com"));
        }
        app.goTo().changeContract();
        app.contact().fillContactForm(new ContactData().withName("Max").withLastName("Korj").withAddress("Urala str. 55").withMobPhone("77777777777").witheMail("hahaha@mail.com"),true);
        app.goTo().moveToNeed();
        app.contact().submitContactUpdate();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(1);
            Assert.assertEquals(before,after);
    }
}
