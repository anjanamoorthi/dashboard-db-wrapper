package com.invenco.dashboardAPIHandler.DBWrapper.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 25/09/2020
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private int id;

    @Column(name="username")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Release> releases;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }
}
