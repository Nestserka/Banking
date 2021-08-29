package controller.controllers;

import controller.dao.DebitCardDao;
import controller.dao.UserDao;
import controller.entity.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.Random;

@Controller
public class DebitCardController {

  private final DebitCardDao debitCardDao;

   @Autowired
   public DebitCardController(DebitCardDao debitCardDao) {
   this.debitCardDao = debitCardDao;
   }


 @GetMapping("/debitcard")
  public String debit(Model model) { //ключ (значением может быть любой обьект)
        model.addAttribute("card", new DebitCard());
        return "/first/debitcard";
    }

    @PostMapping("/debitcard")
    public String create(@ModelAttribute("card")  DebitCard debitCard) {
        String number;
        long MAX_NUMBER = 9999999999999999L;
        long MIN_NUMBER = 1000000000000000L;
        number = String.valueOf(Long.valueOf(Math.abs(Float.valueOf(new Random().nextFloat() * (MAX_NUMBER - MIN_NUMBER)).longValue())));
        debitCard.setNumber(number);
        long millis=System.currentTimeMillis();
        java.sql.Date startDate =new java.sql.Date(millis);
        debitCard.setStartDate(startDate);
        int min = 100;
        int max = 999;
        int cvv = (int) ((Math.random() * ((max - min) + 1)) + min);
        debitCard.setCvv(cvv);
        debitCardDao.save(debitCard);
        return "redirect:/first";
    }
    @GetMapping("/AddDebitcard")
    public String AddDebitcard(Model model) {
        model.addAttribute("cardlist",debitCardDao.debit());
        return "/AddDebitcard";
    }
}
