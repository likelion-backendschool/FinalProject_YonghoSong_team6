package com.ll.exam.books_YonghoSong.app.security;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    AUTHOR("ROLE_AUTHOR"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private final String value;
}
