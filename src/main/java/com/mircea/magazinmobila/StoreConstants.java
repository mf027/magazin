package com.mircea.magazinmobila;

import java.util.Arrays;
import java.util.List;

public class StoreConstants {

    private static final List<String> categories = Arrays.asList(
        "Furniture", "Office Supplies", "Technology"
    );

    private static final String SUCCES_STATUS = "succes";
    private static final String FAILED_STATUS = "failed";

    public static List<String> getCategories() {
        return categories;
    }

    public static String getSuccesStatus() {
        return SUCCES_STATUS;
    }

    public static String getFailedStatus() {
        return FAILED_STATUS;
    }
    
}
