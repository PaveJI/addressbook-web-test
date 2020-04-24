package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group  = new GroupData().withName("test22").withHeader("test222").withFooter("test2222");
    app.group().create(group);
    assertThat(before.size(),equalTo( (app.group().сount()) - 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testGroupCreation2() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group  = new GroupData().withName("test'").withHeader("test222").withFooter("test2222");
    app.group().create(group);
    assertThat(before.size(),equalTo(app.group().сount()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }
}
