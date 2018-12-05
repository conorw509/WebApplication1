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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author conor
 */
@Entity
@Table(name = "BRANCH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
    , @NamedQuery(name = "Branch.findBySortCode", query = "SELECT b FROM Branch b WHERE b.sortCode = :sortCode")
    , @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SORT_CODE")
    private Integer sortCode;
    @Size(max = 45)
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @OneToMany(mappedBy = "sortCode")
    private Collection<Accounts> accountsCollection;

    public Branch() {
    }

    public Branch(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sortCode != null ? sortCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.sortCode == null && other.sortCode != null) || (this.sortCode != null && !this.sortCode.equals(other.sortCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.Branch[ sortCode=" + sortCode + " ]";
    }
    
}
