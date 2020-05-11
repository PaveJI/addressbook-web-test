package ru.stqa.pft.addressbook.tests;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[] {new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(before.size(),equalTo( (app.group().сount()) - 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testGroupCreation2() throws Exception {
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    GroupData group  = new GroupData().withName("test'").withHeader("test222").withFooter("test2222");
//    app.group().create(group);
//    assertThat(before.size(),equalTo(app.group().сount()));
//    Groups after = app.group().all();
//    assertThat(after, equalTo(before));
//  }
}
