package com.softserve.onlineshop.dto.response;

import com.softserve.onlineshop.entity.Phone;

public class PhoneResponse {

    private Long id;
    private Integer year;
    private Integer price;
    private String photo;
    private String color;
    private Double screenDiagonal;
    private Integer internalMemory;

    public PhoneResponse(Phone phone) {
        id = phone.getId();
        year = phone.getYear();
        price = phone.getPrice();
        photo = phone.getPhoto();
        color = phone.getColor();
        screenDiagonal = phone.getScreenDiagonal();
        internalMemory = phone.getInternalMemory();
    }
}
