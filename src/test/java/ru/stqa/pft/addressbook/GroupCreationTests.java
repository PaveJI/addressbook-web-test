package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initCroupCreation("new");
    fillGroupForm(new GroupData("test22", "test222", "test2222"));
    submitGroupCreation("submit");
    returnGroupPage();
  }

}
