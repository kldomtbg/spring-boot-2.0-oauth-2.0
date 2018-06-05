package com.ywsoftware.oa.authServer.core.entity.dto;

import java.io.Serializable;
import java.util.Set;

public class UserDTO implements Serializable {

    private String id;
    private String userName;
    private Boolean enabled;
    private Set<roleDTO> role;
    private String clientId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public Set<roleDTO> getRole() {
        return role;
    }

    public void setRole(Set<roleDTO> role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
