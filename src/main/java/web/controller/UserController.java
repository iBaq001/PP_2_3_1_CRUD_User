package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //READ ALL
    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    //READ TO ID
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "show";
    }

    //CREAT
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.createUser(user);
        return "redirect:/users";
    }

    //EDIT UPDATE
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.readUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
