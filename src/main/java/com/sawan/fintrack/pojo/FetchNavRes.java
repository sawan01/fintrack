package com.sawan.fintrack.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FetchNavRes {

    @JsonProperty("Scheme Code")
    private String schemaCode;

    @JsonProperty("ISIN Div Payout/ISIN Growth")
    private String isin;

    @JsonProperty("ISIN Div Reinvestment")
    private String isinReinv;

    @JsonProperty("Scheme Name")
    private String schemaName;

    @JsonProperty("Net Asset Value")
    private String nav;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Scheme Type")
    private String schemaType;

    @JsonProperty("Scheme Category")
    private String schemaCat;

    @JsonProperty("Mutual Fund Family")
    private String mfFamily;

    public String getSchemaCode() {
        return schemaCode;
    }

    public void setSchemaCode(String schemaCode) {
        this.schemaCode = schemaCode;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIsinReinv() {
        return isinReinv;
    }

    public void setIsinReinv(String isinReinv) {
        this.isinReinv = isinReinv;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSchemaType() {
        return schemaType;
    }

    public void setSchemaType(String schemaType) {
        this.schemaType = schemaType;
    }

    public String getSchemaCat() {
        return schemaCat;
    }

    public void setSchemaCat(String schemaCat) {
        this.schemaCat = schemaCat;
    }

    public String getMfFamily() {
        return mfFamily;
    }

    public void setMfFamily(String mfFamily) {
        this.mfFamily = mfFamily;
    }
}
