package com.example.RestaurantTableBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "Email id is required and must be unique")
    @Pattern(regexp = "^[a-zA-Z0-9]+@gmail.com$")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "password is required and required length must be greater than 8")
    @Pattern(regexp = "^[a-zA-Z0-9-_@]{8,}$")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status role;

    @Override
    public Collection<? extends GrantedAuthority>getAuthorities(){
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
}
