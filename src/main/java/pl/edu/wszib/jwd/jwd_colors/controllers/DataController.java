package pl.edu.wszib.jwd.jwd_colors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.jwd_colors.service.SelectedColorService;

@Controller
public class DataController {

    @Autowired
    SelectedColorService selectedColorService;

    @Value("${app.title.data}")
    private String title;

@GetMapping("/data")
    public String dataPage(Model model){
        model.addAttribute("title", title);
        model.addAttribute("selectedColors", selectedColorService.getAllData());
        return "data";
    }
}
