package com.example.foodorder.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.stream.Collectors;


@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Getter
@AllArgsConstructor

public class Menu {
    private String name;
    private List<MenuElement> menu;

    public void addElement(MenuElement me){
        if(menu != null)
            menu.add(me);

    }
    public List<MenuElement> getElements(String name){
        return menu != null ? menu.stream().filter(me -> me.getName() == name).collect(Collectors.toList()) : menu;
    }

    public MenuElement getElement(int id){
        return menu != null ? menu.stream().filter(me -> me.getId() == id).findFirst().get() : null;
    }

    public boolean removeElement(int id){
        MenuElement me = getElement(id);

        return menu.remove(me);

    }



}
