package controller.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;


@Entity
@Table(name = "loan", schema = "public", catalog = "postgres")
public class Loan {
    @Id
    @Column(name = "amount")
    private int amount;
    @Column(name = "interest")
    private double interest;
    @Column(name = "term")
    private int term;
    @Column(name = "monthlypayment")
    private int monthlyPayment;
    @Column(name = "overpaymentamount")
    private int overpaymentAmount;
    @Column(name = "startdate")
    private Date startDate;
    @Column(name = "description")
    private String description;




    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getOverpaymentAmount() {
        return overpaymentAmount;
    }

    public void setOverpaymentAmount(int overpaymentAmount) {
        this.overpaymentAmount = overpaymentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {

        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return amount == loan.amount && Double.compare(loan.interest, interest) == 0 && term == loan.term && monthlyPayment == loan.monthlyPayment && overpaymentAmount == loan.overpaymentAmount && startDate.equals(loan.startDate) && description.equals(loan.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, interest, term, monthlyPayment, overpaymentAmount, startDate, description);
    }

}

