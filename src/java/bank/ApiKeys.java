/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author conor
 */
@Entity
@Table(name = "API_KEYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApiKeys.findAll", query = "SELECT a FROM ApiKeys a")
    , @NamedQuery(name = "ApiKeys.findByApiKey", query = "SELECT a FROM ApiKeys a WHERE a.apiKey = :apiKey")})
public class ApiKeys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "API_KEY")
    private Integer apiKey;

    public ApiKeys() {
    }

    public ApiKeys(Integer apiKey) {
        this.apiKey = apiKey;
    }

    public Integer getApiKey() {
        return apiKey;
    }

    public void setApiKey(Integer apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apiKey != null ? apiKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApiKeys)) {
            return false;
        }
        ApiKeys other = (ApiKeys) object;
        if ((this.apiKey == null && other.apiKey != null) || (this.apiKey != null && !this.apiKey.equals(other.apiKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.ApiKeys[ apiKey=" + apiKey + " ]";
    }
    
}
