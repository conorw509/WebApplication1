/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author conor
 */
@Entity
@Table(name = "ACCOUNTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccountId", query = "SELECT a FROM Accounts a WHERE a.accountId = :accountId")
    , @NamedQuery(name = "Accounts.findByAccountType", query = "SELECT a FROM Accounts a WHERE a.accountType = :accountType")
    , @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status")
    , @NamedQuery(name = "Accounts.findByCustomerId", query = "SELECT a FROM Accounts a WHERE a.customerId = :customerId")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    @Size(max = 45)
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @JoinColumn(name = "SORT_CODE", referencedColumnName = "SORT_CODE")
    @ManyToOne
    private Branch sortCode;
    @OneToMany(mappedBy = "accountId")
    private Collection<Transactions> transactionsCollection;

    public Accounts() {
    }

    public Accounts(Integer accountId) {
        this.accountId = accountId;
    }

    public Accounts(Integer accountId, int status) {
        this.accountId = accountId;
        this.status = status;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Branch getSortCode() {
        return sortCode;
    }

    public void setSortCode(Branch sortCode) {
        this.sortCode = sortCode;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.Accounts[ accountId=" + accountId + " ]";
    }
    
}
