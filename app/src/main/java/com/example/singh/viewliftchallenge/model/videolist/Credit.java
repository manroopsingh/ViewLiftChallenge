package com.example.singh.viewliftchallenge.model.videolist;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.io.Serializable;

/**
 * Created by singh on 01-Apr-17.
 */

@Root(strict = false)
public class Credit implements Serializable {


    @Text
    String credit;


    @Attribute
    String role;


    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
