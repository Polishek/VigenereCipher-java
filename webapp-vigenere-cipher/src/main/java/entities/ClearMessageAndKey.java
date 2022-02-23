/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author bartu
 */
@Entity
public class ClearMessageAndKey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private String clearMessage;
    
    /**
     * Get value of clearMessage.
     * @return the value of clearMessage
     */
    public String getClearMessage(){
        return this.clearMessage;
    }
    
    /**
     * Set the value of clearMessage.
     * @param clearMessage new value of clearMessage
     */
    public void setClearMessage(String clearMessage){
        this.clearMessage = clearMessage;
    }
    
    private String key;
    /**
     * Get value of clearMessage.
     * @return the value of clearMessage
     */
    public String getKey(){
        return this.key;
    }
    
    /**
     * Set the value of key.
     * @param key new value of key
     */
    public void setKey(String key){
        this.key = key;
    }
    
    @OneToOne
    private CodedMessage codedMessage;
    
    /**
     * Set the object of codedMessage.
     * @param codedMessage new object of codedMessage
     */
    public void setCodedMessage(CodedMessage codedMessage){
        this.codedMessage = codedMessage;
    }
    
    /**
     * Get value of codedMessage.
     * @return the value of codedMessage
     */
    public CodedMessage getCodedMessage(){
        return this.codedMessage;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClearMessageAndKey)) {
            return false;
        }
        ClearMessageAndKey other = (ClearMessageAndKey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ClearMessage[ id=" + id + " ]";
    }
    
}
