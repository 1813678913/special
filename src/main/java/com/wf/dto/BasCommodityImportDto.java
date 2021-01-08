package com.wf.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
//@ApiModel(value = "BasCommodityImportDto", description = "导入")
public class BasCommodityImportDto {

    private String sku;


    private String skuShort;


    private String productName;


    private String goodsNumber;


    private String modelType;


    private String unit;

    private String brand;

    private String customerName;

    private String attribute;


    private BigDecimal unitPrice;

    private String packaging;

    private Double weight;

    private Double length;

    private Double width;

    private Double height;

    private Double volume;

    private String customsName;

    private String customsNameEn;

    private String customsNameTh;

    private String customsCode;

    private String tariffSequence;

    private BigDecimal customsPrice;

}
