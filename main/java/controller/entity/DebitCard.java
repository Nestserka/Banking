package controller.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "debitcard", schema = "public", catalog = "postgres")
public class DebitCard {
    @Column(name = "cardholderfirstname")
    private String cardholderFirstName;
    @Column(name = "cardholderlastname")
    private String cardholderLastName;
    @Id
    @Column(name = "number")
    private String number;
    @Column
    private int cvv;
    @Column(name = "term")
    private int term;
    @Column(name = "startdate")
    private Date startDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebitCard debitCard = (DebitCard) o;
        return cvv == debitCard.cvv && term == debitCard.term && cardholderFirstName.equals(debitCard.cardholderFirstName) && cardholderLastName.equals(debitCard.cardholderLastName) && number.equals(debitCard.number) && startDate.equals(debitCard.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardholderFirstName, cardholderLastName, number, cvv, term, startDate);
    }




    public String getCardholderFirstName() {
        return cardholderFirstName;
    }

    public void setCardholderFirstName(String cardholderFirstName) {
        this.cardholderFirstName = cardholderFirstName;
    }

    public String getCardholderLastName() {
        return cardholderLastName;
    }

    public void setCardholderLastName(String cardholderLastName) {
        this.cardholderLastName = cardholderLastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }





}

