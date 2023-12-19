package com.example.foodorder;

import com.example.foodorder.Model.Menu;
import com.example.foodorder.Service.MenuElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MenuElementController {
    private final MenuElementService menuElementService;

    @GetMapping("/")
    public String getElements(Model model){
        model.addAttribute("menu", menuElementService.getMenuElementsRepo());
        return "menu";
    }
}
