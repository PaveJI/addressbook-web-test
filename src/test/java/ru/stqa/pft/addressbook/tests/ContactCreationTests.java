package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreations()throws Exception{
        app.goTo().gotoHome();
        List<ContactData> before = app.getContactHelper().getContactList();
//        int before = app.getContactHelper().getContactCount();
        app.goTo().gotoAddPage();
        ContactData contact = new ContactData("John", "Silver", "Lenina str. 60a", "89991231212", "pishi@mail.com", "test1");
        app.getContactHelper().fillContactForm(contact, true);
        app.goTo().moveToNeed();
        app.getContactHelper().submitContactCreation();
        List<ContactData> after = app.getContactHelper().getContactList();
//        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() + 1);

//        Assert. assertEquals(after,before);
        int max = 0;
        for (ContactData c : after){
            if(c.getId() > max) {
                max = c.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(after),new HashSet<Object>(before));
    }
}
