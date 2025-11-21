package AddressBook;

import java.io.Serializable;

public class Address implements Serializable {
    private String name;
    private String province;
    private String city;
    private String postalCode;
    private String detailAddress;

    public Address(String name, String province, String city, String postalCode, String detailAddress) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
        this.detailAddress = detailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", name, province, city, postalCode, detailAddress);
    }
}
