package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContractModificationTests extends TestBase{

    @BeforeMethod
    public void contactPreconditions(){
        app.goTo().gotoHomePage();
        if (! app.contact().isThereAContect()){
            app.contact().createContact(new ContactData().withName("Max").withLastName("Korj").withAddress("Urala str. 55").withMobPhone("77777777777").witheMail("hahaha@mail.com"));
        }
    }

    @Test
    public void testContractModification(){
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        app.goTo().changeContract();
        app.contact().fillContactForm(new ContactData().withName("Max").withLastName("Korj").withAddress("Urala str. 55").withMobPhone("77777777777").witheMail("hahaha@mail.com"),false);
        app.goTo().moveToNeed();
        app.contact().submitContactUpdate();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() -1);

        assertThat(after, equalTo(before.without(modifiedContact)));
    }
}
