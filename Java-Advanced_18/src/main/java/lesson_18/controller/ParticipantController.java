package lesson_18.controller;

import lesson_18.entity.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lesson_18.service.ParticipantService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParticipantController {
    private final ParticipantService service;

    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String init(HttpServletRequest req) {
        req.setAttribute("participants", service.findAll());
        req.setAttribute("mode", "P_VIEW");
        return "index";
    }

    @GetMapping("/new")
    public String newBook(HttpServletRequest req) {
        req.setAttribute("mode", "P_CREATE");
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant p, HttpServletRequest req) {
        service.save(p);
        req.setAttribute("participants", service.findAll());
        req.setAttribute("mode", "P_VIEW");
        return "index";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        req.setAttribute("participant", service.get(id));
        req.setAttribute("mode", "P_EDIT");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam int id, HttpServletRequest req) {
        service.delete(id);
        req.setAttribute("participants", service.findAll());
        req.setAttribute("mode", "P_VIEW");
        return "index";
    }
}