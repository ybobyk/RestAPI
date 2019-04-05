package com.develop.models.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    User("user"), Admin("admin");

    String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
