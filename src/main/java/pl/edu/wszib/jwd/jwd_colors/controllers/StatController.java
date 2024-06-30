package pl.edu.wszib.jwd.jwd_colors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.jwd_colors.helpers.ColorHelper;
import pl.edu.wszib.jwd.jwd_colors.model.SelectedColor;
import pl.edu.wszib.jwd.jwd_colors.service.SelectedColorService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatController {

    @Autowired
    SelectedColorService selectedColorService;

    @Value("${app.title.stats}")
    private String title;

    @GetMapping("/stats")
    public String statsPage(Model model){
        List<SelectedColor> selectedColors = selectedColorService.getAllData();
        Map<String, Long> dataMap = selectedColors.stream().collect(Collectors.groupingBy(SelectedColor::getColor, Collectors.counting()));
        model.addAttribute("title", title);
        model.addAttribute("labels", dataMap.keySet());
        model.addAttribute("data", dataMap.values());
        model.addAttribute("backgrounds", ColorHelper.convertColors(dataMap.keySet()));
        return "stats";
    }
}
