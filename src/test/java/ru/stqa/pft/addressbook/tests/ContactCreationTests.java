package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreations()throws Exception{
        app.goTo().gotoHome();
        List<ContactData> before = app.contact().list();
        app.goTo().gotoAddPage();
        ContactData contact = new ContactData().withName("John").withLastName("Silver");
        List<ContactData> after = app.contact().initContact(contact);
        Assert.assertEquals(after.size(), before.size() + 1);


//        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        before.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        after.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        Assert.assertEquals(after,before);
    }
}
