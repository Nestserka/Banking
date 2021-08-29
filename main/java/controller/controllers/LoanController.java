package controller.controllers;

import controller.dao.LoanDao;
import controller.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoanController {

    private final LoanDao loanDao;

    @Autowired
    public LoanController(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @GetMapping("/first")
    public String helloPage() {
        return "/first/hello";
    }

    @GetMapping("/loan")
    public String Loan(Model model) { //ключ (значением может быть любой обьект)
        model.addAttribute("loan", new Loan());
        return "first/loan";
    }

    @PostMapping("/loan")
    public String createLoan(@ModelAttribute("loan") Loan loan) {
    int monthlyPayment=(int) ((loan.getAmount() * loan.getInterest()) - Math.pow (1+ loan.getInterest(), -loan.getTerm()));
   loan.setMonthlyPayment(monthlyPayment);
    int overpaymentAmount =  (monthlyPayment * loan.getTerm()) - loan.getAmount();
    loan.setOverpaymentAmount(overpaymentAmount);
    long millis=System.currentTimeMillis();
   java.sql.Date startDate =new java.sql.Date(millis);
    loan.setStartDate(startDate);
    loanDao.save(loan);
    return "redirect:/first";
    }

    @GetMapping("/Addloan")
    public String show(Model model) {
        model.addAttribute("loanlist", loanDao.index());
        return "Addloan";
    }
}

