package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initCroupCreation("new");
    app.getGroupHelper().fillGroupForm(new GroupData("test22", "test222", "test2222"));
    app.getGroupHelper().submitGroupCreation("submit");
    app.getGroupHelper().returnGroupPage();
  }

}
