package ru.dan.course.Models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.DEVELOPERS_READ)),
    ADMIN(Set.of(Permission.DEVELOPERS_WRITE,Permission.DEVELOPERS_READ));
    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        System.out.println("public Set<SimpleGrantedAuthority> getAuthorities()" + getPermissions().stream().map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet()));
        return getPermissions().stream().map(permissions -> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());
    }
}
