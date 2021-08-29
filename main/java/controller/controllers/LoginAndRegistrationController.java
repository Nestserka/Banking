package controller.controllers;

import controller.dao.UserDao;
import controller.entity.Loan;
import controller.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class LoginAndRegistrationController {

    private final UserDao userDao;
    public static User user = null;


    public LoginAndRegistrationController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String getLoginPage(Model model) { //ключ (значением может быть любой обьект)
        model.addAttribute("user", new User());
        return "first/loginpage";
    }
   @PostMapping("/")
   public String doLogin(@ModelAttribute("user") User user)  {
        User userNew = userDao.show(user.getEmail());
        if (userNew == null || !userNew.getPassword().equals(user.getPassword())) {
            return "redirect:/";
        }
       return "first/hello";
   }

    @GetMapping("/registerpage")
    public String AgetRegisterPage(Model model) {
        model.addAttribute("userlist", userDao.user());
        return "first/registerpage";
    }
    @PostMapping("/registerpage")
    public String doRegister(@ModelAttribute("user") User user) {
        long millis=System.currentTimeMillis();
        java.sql.Date registrationDate=new java.sql.Date(millis);
        user.setRegistrationDate(registrationDate);
        userDao.save(user);
        return "first/registerpage";
    }

    }
