package com.consumer.consumersocket.domain.dto;

public class MessageDto {
    private boolean isActive;
    private String color;
    private int number;
    private String message;


    public MessageDto(boolean isActive, String color, int number, String message) {
        this.isActive = isActive;
        this.color = color;
        this.number = number;
        this.message = message;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
