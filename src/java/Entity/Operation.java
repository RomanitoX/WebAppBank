package Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Operations")
public class Operation implements Serializable {

    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    private OperationType type;

    private String wording;

    @OneToOne
    private Third third;

    @ManyToOne(cascade = CascadeType.MERGE)
    private BankAccount account;

    @Temporal(TemporalType.DATE)
    @Column(name = "operationDate")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        return sdf.format(this.date) + "\t" + this.amount + "€\t" + this.third + "\t" + this.type;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (this.type == OperationType.DEBIT) {
            this.amount = amount - (amount * 2);
        } else {
            this.amount = amount;
        }
    }

    /**
     * @return the type
     */
    public OperationType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(OperationType type) {
        this.type = type;
    }

    /**
     * @return the wording
     */
    public String getWording() {
        return wording;
    }

    /**
     * @param wording the wording to set
     */
    public void setWording(String wording) {
        this.wording = wording;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the third
     */
    public Third getThird() {
        return third;
    }

    /**
     * @param third the third to set
     */
    public void setThird(Third third) {
        this.third = third;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public BankAccount getAccount() {
        return account;
    }
}
