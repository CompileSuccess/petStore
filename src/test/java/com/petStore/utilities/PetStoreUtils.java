package com.petStore.utilities;

public class PetStoreUtils {


    public  String url(){
       final String url = ConfigurationReader.getProperty("base.url");
        return url;
    }
}
