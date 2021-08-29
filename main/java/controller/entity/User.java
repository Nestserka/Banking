package controller.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user1", schema = "public", catalog = "postgres")
public class User {
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    @Id
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "registrationdate")
    Date registrationDate;
    @OneToMany
    private List<DebitCard> cards;
    @OneToMany
    private List<Loan> loans;

    public List<DebitCard> getCards() {
        return cards;
    }

    public void setCards(List<DebitCard> cards) {
        this.cards = cards;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password) && registrationDate.equals(user.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, registrationDate);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


}
