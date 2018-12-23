/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import com.oracle.jrockit.jfr.ValueDefinition;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author gohnem
 */
@Entity
public class Client {
    @Id @GeneratedValue
    private int clientId;
    private String clientEmail;
    private String clientPass;
    private String clientName;
    private String clientNationalId;
    private String clientPhone;
    private String clientAddress;
  
    private int balance;
    @OneToMany (mappedBy = "client")
    private Collection<Process> p = new ArrayList<Process>();

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPass() {
        return clientPass;
    }

    public void setClientPass(String clientPass) {
        this.clientPass = clientPass;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNationalId() {
        return clientNationalId;
    }

    public void setClientNationalId(String clientNationalId) {
        this.clientNationalId = clientNationalId;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

  

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Collection<Process> getP() {
        return p;
    }

    public void setP(Collection<Process> p) {
        this.p = p;
    }
    
    
}
