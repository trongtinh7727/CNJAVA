package com.iiex.javamidterm.Controller;


import com.iiex.javamidterm.Model.User;
import com.iiex.javamidterm.Service.UserService;
import com.iiex.javamidterm.DTO.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String loginForm() {
        return "auths/loginpage";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "auths/register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "auths/register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

}