package com.nayelidj.cst438_1_project01_group03;


import java.util.ArrayList;

import java.util.List;

public class Results {


    private Category category;

    private Company company;

    //date when created
    private String created;

    private String description;

    private String id;

    private float latitude;

    private Location location;

    private float longitude;

    private String redirect_url;

    private String salary_is_predicted;

    // job title
    private String title;



    public Category getCategory() {
        return category;
    }

    public Company getCompany() {
        return company;
    }

    public String getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public float getLatitude() {
        return latitude;
    }

    public Location getLocation() {
        return location;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public String getSalary_is_predicted() {
        return salary_is_predicted;
    }

    public String getTitle() {
        return title;
    }

    //    public Job getJob() {
//        return job;
//    }
}
