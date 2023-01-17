
package com.example.mvc.web2.beans;

import java.io.Serializable;

/**
 *
 * @author Thiago
 */
public class ConfigBean implements Serializable{
    
    public String emailAdm;

    public ConfigBean(String emailAdm) {
        this.emailAdm = emailAdm;
    }

    public String getEmailAdm() {
        return emailAdm;
    }

    public void setEmailAdm(String emailAdm) {
        this.emailAdm = emailAdm;
    }
    
    
    
}
