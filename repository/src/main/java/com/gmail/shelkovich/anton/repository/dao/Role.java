package com.gmail.shelkovich.anton.repository.dao;

public enum Role {
    ROLE_SUPERADMIN{
        public String toString(){
            return "Супер администратор";
        }
    },
    ROLE_ADMIN{
        public String toString(){
            return "Администратор";
        }
    },
    ROLE_USER{
        public String toString(){
            return "Пользователь";
        }
    }
}
