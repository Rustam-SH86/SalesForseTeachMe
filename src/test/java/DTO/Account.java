package DTO;

public class Account {
    String accountName;
    String phone;
    String fax;
    String rating;
    String street;

    public Account(String accountName, String phone, String fax,String street, String rating) {
        this.accountName = accountName;
        this.phone = phone;
        this.fax = fax;
        this.rating = rating;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getRating() {
        return rating;
    }

}
