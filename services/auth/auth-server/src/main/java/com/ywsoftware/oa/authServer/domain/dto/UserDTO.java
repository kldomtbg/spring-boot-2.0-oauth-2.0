package com.ywsoftware.oa.authServer.domain.dto;

import java.io.Serializable;
import java.util.Set;

public class UserDTO implements Serializable {

    private String nome;
    private String userName;
    private Boolean enabled;
    private Set<DominioDTO> role;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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


    public Set<DominioDTO> getRole() {
        return role;
    }

    public void setRole(Set<DominioDTO> role) {
        this.role = role;
    }
}
