package com.android.www.recyclerdynamica.Model;

import java.util.ArrayList;

public class SectionDataModel {
    private String headerTitle;
    private ArrayList<SingleItemModel> allSectionItem;

    public SectionDataModel(String headerTitle, ArrayList<SingleItemModel> allSectionItem) {
        this.headerTitle = headerTitle;
        this.allSectionItem = allSectionItem;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel> getAllSectionItem() {
        return allSectionItem;
    }

    public void setAllSectionItem(ArrayList<SingleItemModel> allSectionItem) {
        this.allSectionItem = allSectionItem;
    }
}
