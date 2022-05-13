package com.labo.budgets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AffectRoleToUserDto {
    private String username;
    private String role;
}
