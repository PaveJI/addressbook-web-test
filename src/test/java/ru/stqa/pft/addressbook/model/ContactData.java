package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String mobPhone;
    private String eMail;
    private String group;

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public ContactData(int id, String name, String lastName, String address, String mobPhone, String eMail, String group){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.mobPhone = mobPhone;
        this.eMail = eMail;
        this.group = group;
    }

 public ContactData(String name, String lastName, String address, String mobPhone, String eMail, String group){
        this.id = 0;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.mobPhone = mobPhone;
        this.eMail = eMail;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mobPhone, that.mobPhone) &&
                Objects.equals(eMail, that.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, address, mobPhone, eMail);
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGroup() {
        return group;
    }
}
