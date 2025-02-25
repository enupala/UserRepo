package com.apexon.catchIt.model;

import jakarta.persistence.*;

@Entity
public class Role {
    public Role(Roles roleName) {
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public Roles getRoleName() {
        return roleName;
    }

    public void setRoleName(Roles roleName) {
        this.roleName = roleName;
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Roles roleName;
}
