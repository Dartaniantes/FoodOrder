package com.example.foodorder.Service;

import com.example.foodorder.Model.MenuElement;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class MenuElementService {
    private List<MenuElement> menuElementsRepo;

    public MenuElementService(){
        menuElementsRepo = new ArrayList<>();
        menuElementsRepo.add(new MenuElement("Mashed potato", 85.5, "Mashed boiled potato seasoned with milk"));
        menuElementsRepo.add(new MenuElement("Pasta", 109, "Classic italian pasta"));
    }

    public boolean createElement(MenuElement me){
        return menuElementsRepo.add(me);
    }

}
