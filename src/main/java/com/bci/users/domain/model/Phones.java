package com.bci.users.domain.model;


import java.util.UUID;

public class Phones {

    private UUID id;
    private String number;
    private String cityCode;
    private String countryCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phones{");
        sb.append("number=").append(number);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", countryCode=").append(countryCode);
        sb.append('}');
        return sb.toString();
    }
}
