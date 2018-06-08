package com.ywsoftware.oa.authServer.core.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class EntityImpl implements Entity {
    @Id
    @Column(nullable = false, length = 36)
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    protected EntityImpl() {

    }

    protected EntityImpl(String _id) {
        this.id = _id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
