package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id = Integer.MAX_VALUE;

    private String name;
    private String lastName;
    private String address;
    private String mobPhone;
    private String eMail;
    private String group;

    public String firstname;
    public String lastname;
    public String homePhone;
    public String mobilePhone;
    public String workPhone;
    private String Firstname;
    private String Lastname;
    private String HomePhone;
    private String MobilePhone;
    private String WorkPhone;

    public ContactData() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public String getEMail() {
        return eMail;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getGroup() {
        return group;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
        return this;
    }

    public ContactData witheMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public ContactData withFirstname(String Firstname) {
        this.Firstname = Firstname;
        return this;
    }
public ContactData withLastname(String Lastname) {
        this.Lastname = Lastname;
        return this;
    }
public ContactData withHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
        return this;
    }
public ContactData withMobilePhone(String MobilePhone) {
        this.MobilePhone = MobilePhone;
        return this;
    }
public ContactData withWorkPhone(String WorkPhone) {
        this.WorkPhone = WorkPhone;
        return this;
    }
    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobPhone='" + mobPhone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", group='" + group + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                '}';
    }
}
