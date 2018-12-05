/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author conor
 */
@Entity
@Table(name = "TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTransId", query = "SELECT t FROM Transactions t WHERE t.transId = :transId")
    , @NamedQuery(name = "Transactions.findByTransType", query = "SELECT t FROM Transactions t WHERE t.transType = :transType")
    , @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount")
    , @NamedQuery(name = "Transactions.findByDateCreated", query = "SELECT t FROM Transactions t WHERE t.dateCreated = :dateCreated")
    , @NamedQuery(name = "Transactions.findByBalance", query = "SELECT t FROM Transactions t WHERE t.balance = :balance")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_ID")
    private Integer transId;
    @Size(max = 45)
    @Column(name = "TRANS_TYPE")
    private String transType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "BALANCE")
    private Double balance;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne
    private Accounts accountId;

    public Transactions() {
    }

    public Transactions(Integer transId) {
        this.transId = transId;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Accounts getAccountId() {
        return accountId;
    }

    public void setAccountId(Accounts accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.Transactions[ transId=" + transId + " ]";
    }
    
}
