package com.ywsoftware.oa.authserver.repository.spec;


class SearchCriteria {
    private String key;
    private String operation;
    private Object value;

    SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    String getKey() {
        return key;
    }

    void setKey(String key) {
        this.key = key;
    }

    String getOperation() {
        return operation;
    }

    void setOperation(String operation) {
        this.operation = operation;
    }

    Object getValue() {
        return value;
    }

    void setValue(Object value) {
        this.value = value;
    }
}
