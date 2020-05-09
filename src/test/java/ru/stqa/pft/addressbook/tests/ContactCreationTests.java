package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreations()throws Exception{
        app.goTo().gotoHome();
        Contacts before = app.contact().all();
        app.goTo().gotoAddPage();
        ContactData contact = new ContactData().withName("John").withLastName("Silver");
        Set<ContactData> after = app.contact().initContact(contact, true);
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));
    }
}
