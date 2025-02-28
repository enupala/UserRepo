package com.apexon.catchIt.dto;

import com.apexon.catchIt.model.Role;
import com.apexon.catchIt.model.Roles;

import java.util.HashSet;
import java.util.Set;

public class AssignRolesDto {
        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Roles getRole() {
                return role;
        }

        public void setRole(Roles role) {
                this.role = role;
        }

        private Long userId;
        private Roles role;




}
