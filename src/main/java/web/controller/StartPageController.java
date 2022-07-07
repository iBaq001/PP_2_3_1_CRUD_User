package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartPageController {


    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("������!");
        messages.add("��� CRUD ���������� �� ���� Spring-mvs");
        messages.add("��� ������ ����� �� ������ ���� ");
        model.addAttribute("messages", messages);
        return "startPage";
    }
}