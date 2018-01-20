package com.gmail.shelkovich.anton.service.model;

import com.gmail.shelkovich.anton.service.Exception.IllegalOrderStatusException;

public class OrderStatus {
    public static final int NEW = 1;
    public static final int REVIEWING = 2;
    public static final int IN_PROGRESS = 3;
    public static final int DELIVERED = 4;

    public static String getStringStatus(int status) throws IllegalOrderStatusException{
        switch (status){
            case 1: return "New";
            case 2: return "Reviewing";
            case 3: return "In progress";
            case 4: return "Delivered";
        }
        throw new IllegalOrderStatusException("Illegal order status: "+status);
    }
}
