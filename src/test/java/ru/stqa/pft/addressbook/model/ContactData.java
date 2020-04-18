package ru.stqa.pft.addressbook.model;

public class ContactData {

    private String name;
    private String lastName;
    private String address;
    private String mobPhone;
    private String eMail;

    public ContactData(String name, String lastName, String address, String mobPhone, String eMail){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.mobPhone = mobPhone;
        this.eMail = eMail;
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
}
