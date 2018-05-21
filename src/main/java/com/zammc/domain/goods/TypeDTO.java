package com.zammc.domain.goods;

import lombok.Data;

import java.util.List;

@Data
public class TypeDTO {
    private Long goodsId;
    private String typeName;
    private List<String> typeMsg;
}
