package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation(String submit) {
        click(By.name(submit));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());

    }

    public void initCroupCreation(String s) {
        click(By.name(s));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public  void selectGroup() {
        click(By.name("selected[]"));
    }
}
