package com.task001.Model;

/**
 * Created by ssasa on 12-Jul-18.
 */

public class Category {

    private String Id;
    private String TitleEN;
    private String TitleAR;
    private String Photo;
    private String ProductCount;
    private String HaveModel;
    private Category[] SubCategories;

    public String getId() {
        return Id;
    }

    public String getTitleEN() {
        return TitleEN;
    }

    public String getTitleAR() {
        return TitleAR;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getProductCount() {
        return ProductCount;
    }

    public String getHaveModel() {
        return HaveModel;
    }

    public Category[] getSubCategories() {
        return SubCategories;
    }

}
