package com.in28minutes.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

////Not recommended Aproach 1 - Ignoring properties at class level (Changing field name later will require change)
@JsonIgnoreProperties({"field3", "field5"})
public class SomeBean {

    private String field1;

    ////Preferred Aproach 2 - Ignoring property at field level
    @JsonIgnore
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    public SomeBean(String field1, String field2, String field3, String field4, String field5) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }
}
