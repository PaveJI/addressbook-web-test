package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.generators.GroupDataGenerator;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(GroupData.class);
            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
            }.getType());
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validGroupsFromJson")
    public void testGroupCreation(GroupData group) throws Exception {
        logger.info("Start test testGroupCreation");
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(before.size(), equalTo((app.group().сount()) - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        logger.info("Stop test testGroupCreation");
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
