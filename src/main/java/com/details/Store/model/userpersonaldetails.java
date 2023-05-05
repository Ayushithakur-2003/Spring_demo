package com.details.Store.model;
import javax.persistence.*;


@Entity
@Table(name = "userpersonaldetails")
public class userpersonaldetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(name = "username")
    private String username;

    @Column(name = "userage")
    private Integer userage;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "gender")
    private String gender;

    public userpersonaldetails(){
        
    }

    public userpersonaldetails(String username, Integer userage, String occupation, String gender) {
        this.username = username;
        this.userage = userage;
        this.occupation = occupation;
        this.gender = gender;
    }



    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getUserage() {
        return userage;
    }


    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
