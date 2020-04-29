package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContractModificationTests extends TestBase{

    @Test
    public void testContractModification(){
        app.goTo().gotoHomePage();
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        if (! app.contact().isThereAContect()){
            app.contact().createContact(new ContactData().withName("Max").withLastName("Korj").withAddress("Urala str. 55").withMobPhone("77777777777").witheMail("hahaha@mail.com"));
        }
        app.goTo().changeContract();
        app.contact().fillContactForm(new ContactData().withName("Max").withLastName("Korj").withAddress("Urala str. 55").withMobPhone("77777777777").witheMail("hahaha@mail.com"),false);
        app.goTo().moveToNeed();
        app.contact().submitContactUpdate();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() -1);

        after.add(modifiedContact);
            Assert.assertEquals(before,after);
    }
}
