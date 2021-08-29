package controller.dao;

import controller.entity.DebitCard;
import controller.entity.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LoanDao {
    private  SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public List<Loan> index() {
        Session session = this.sessionFactory.getCurrentSession();
        List <Loan> loans = session.createQuery("from Loan ").list();
        return loans;
    }

    public Loan show(Integer amount) {
        Session session = this.sessionFactory.getCurrentSession();
       Loan loan = (Loan) session.get(Loan.class, amount);
        return loan;
    }

    public void save(Loan loan) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(loan);
    }

    public void update(int amount, Loan updatedLoan) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(updatedLoan);
    }
    public void delete(Integer amount) {
        Session session = this.sessionFactory.getCurrentSession();
        Loan loan = (Loan) session.load(Loan.class, amount);
        if (null != loan) {
            session.delete(loan);
        }
    }
}


