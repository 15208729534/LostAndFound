package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Announce {
    private Integer announceId;

    private Integer userId;

    private String itemName;

    private Boolean announceType;

    private String itemPhoto;

    private String tagName;

    private String itemDescription;

    //直接使用jackson注解，不需要重写反序列化
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date itemTime;

    private String itemPlace;

    private String contact;

    private Integer isStatus;

}