package com.petStore.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    private long id;
            private Category category;
            private String name;
            private List<String> photoUrls;
            private List<Tag> tags;
            private String status;





}
