package com.gmail.shelkovich.anton.repository.model;



public enum OrderStatus {
    NEW{
        @Override
        public String toString(){
            return "Новый";
        }
    },
    REVIEWING{
        @Override
        public String toString(){
            return "Подготовка к доставке";
        }
    },
    IN_PROGRESS{
        @Override
        public String toString(){
            return "В процессе доставки";
        }
    },
    DELIVERED{
        @Override
        public String toString(){
            return "Доставлен";
        }
    }
}
