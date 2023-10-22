package com.demoProject.Controllers;

import com.demoProject.Models.Tache;
import com.demoProject.Services.TacheService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class TacheController {
    @Autowired

    private TacheService tacheService;


    @GetMapping("/todolist")
    public String showPage(Model m){
        List<Tache> taches = tacheService.getAllTaches();
        m.addAttribute("tache", taches);
        m.addAttribute("t", new Tache());

        return "TodoList";
    }

    @PostMapping("/processTaskForm")
    public String  processSensorForm(@ModelAttribute("tache") @Valid Tache ssr, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("notification","sensor not saved , please check your input informations");

            return "redirect:/todolist"; // Return to the form if there are validation errors
        }

        tacheService.addTache(ssr); // Save data if validation passes
        redirectAttributes.addFlashAttribute("notification","sensor saved succefully");
        return "redirect:/todolist";

    }
    @GetMapping("/done/{id}")
    public String doneTache(@PathVariable("id") Long id){
        Tache ssr = tacheService.getTacheById(id);
        ssr.setComplited(true);
        tacheService.updateTache(id,ssr);
        return "redirect:/todolist";
    }
    @GetMapping("/delete/{id}")
    public String deleteTache(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        Tache ssr = tacheService.getTacheById(id);
        tacheService.deleteTache(id);
        redirectAttributes.addFlashAttribute("notification","sensor id="+ssr.getIdTache()+" deleted succefully");
        return "redirect:/todolist";
    }
}
