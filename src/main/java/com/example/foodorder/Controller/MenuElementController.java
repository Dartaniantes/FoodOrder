package com.example.foodorder.Controller;

import com.example.foodorder.Model.MenuElement;
import com.example.foodorder.Service.Menu;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping(value= {"/", "/menu"})
public class MenuElementController {
    private final Menu menuElementService;
    private String role = "user";

    @GetMapping("/")
    public String getElements(Model model){
        model.addAttribute("menu", menuElementService.getMenuElementsRepo());
        model.addAttribute("role", role);
        return "menu";
    }

    @GetMapping("/add")
    public String addElement(){
        return "add_menu_element";
    }
    @PostMapping("/create")
    public String createElement(MenuElement me){
        menuElementService.createElement(me);
        return "redirect:/";
    }

    @GetMapping("/element/{id}/details")
    public String getElement(@PathVariable("id") int id, Model model){
        model.addAttribute("dish", menuElementService.getElement(id));
        return "view_menu_element";
    }

    @PostMapping("/element/{id}/remove")
    public String removeElement(@PathVariable("id") int id){
        menuElementService.remove(id);
        return "redirect:/";
    }

    @PostMapping("/switchRole")
    public String switchRole(){
        if(role.equals("user"))
            role = "admin";
        else
            role = "user";
        return "redirect:/";
    }

}
