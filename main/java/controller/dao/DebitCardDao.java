package controller.dao;

import controller.entity.DebitCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class DebitCardDao {
    private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<DebitCard> debit() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DebitCard> cards = session.createQuery("from DebitCard ").list();
        return cards;
    }

    public DebitCard show(String number) {
        Session session = this.sessionFactory.getCurrentSession();
        DebitCard thisdebit = (DebitCard) session.get(DebitCard.class, number);
        return thisdebit;
    }

    public void save(DebitCard debitCard) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(debitCard);
    }

    public void update(String number, DebitCard updatedDebitCard) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(updatedDebitCard);
    }

    public void delete(String number) {
        Session session = this.sessionFactory.getCurrentSession();
        DebitCard card = (DebitCard) session.load(DebitCard.class, number);
        if (null != card) {
            session.delete(card);
        }
    }
}