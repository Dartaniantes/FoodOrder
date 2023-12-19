package com.example.foodorder.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MenuElement {
    private int id;
    private String name;
    private double price;
    private String description;

    public MenuElement(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
