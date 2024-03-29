package com.ostap.hotels.controllers;

import com.ostap.hotels.models.Customer;
import com.ostap.hotels.service.CustomerService;
import com.ostap.hotels.utils.CustomerEditor;
import com.ostap.hotels.utils.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginForgetController {
    @Autowired
    private Environment environment;

    @Autowired
    private CustomerService customerService;



    @Autowired
    private CustomerEditor customerEditor;

    @Autowired
    private CustomerValidator customerValidator;



    @PostMapping("/registration")
    public String save(Customer customer, BindingResult result, Model model) throws javax.mail.MessagingException {
        customerValidator.validate(customer, result);
        if (result.hasErrors()) {
            String errors = "";
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                errors += " " + environment.getProperty(error.getCode());
            }
            model.addAttribute("error", errors);
            return "registration";
        }
        customerEditor.setValue(customer);
        customer.setCode(UUID.randomUUID().toString());
        customerService.save(customer);
        String text = "Go to the link, to activate your account : <a href='http://localhost:8080/activate/" + customer.getCode() + "'>Activate</a>";
        String subject = "Activate account";
        return "main";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code) {
        Customer user = (Customer) customerService.loadByCode(code);
        user.setEnabled(true);
        customerService.save(user);
        return "login";
    }

    @GetMapping("/login/forgotten")
    public String loginforgot(@RequestParam String email) throws MessagingException {

        Customer user = (Customer) customerService.loadUserByEmail(email);
        String subject = "Hotels - Login";
        user.setCode(UUID.randomUUID().toString());
        customerService.save(user);
        String text = "Your login is: " + user.getUsername() + " <br> Login: <a href='http://localhost:8080/login'>Login</a>";
        return "registr";
    }

    @GetMapping("/password/forgotten")
    public String restorePassword(@RequestParam String email) throws MessagingException {
        Customer user = (Customer) customerService.loadUserByEmail(email);
        String subject = "Change password";
        user.setCode(UUID.randomUUID().toString());
        customerService.save(user);
        String text = "Go to the link, to change password from your account : <a href='http://localhost:8080/change_password/" + user.getCode() + "'>Change password!</a>";
        return "registr";
    }

    @GetMapping("/change_password/{code}")
    public String change_password(@PathVariable String code, Model model) {
        Customer customer = (Customer) customerService.loadByCode(code);
        model.addAttribute("customer", customer);
        return "changepassword";
    }


    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/new_password/{id}")
    public String newPassword(@PathVariable int id,
                              @RequestParam String password1, @RequestParam String password2) {
        Customer customer = (Customer) customerService.loadUserById(id);
        if (password1.equals(password2)) {
            customer.setPassword(passwordEncoder.encode(password1));
            customerService.save(customer);
            return "login";
        } else {
            return "/change_password/" + customer.getCode();
        }
    }
}
