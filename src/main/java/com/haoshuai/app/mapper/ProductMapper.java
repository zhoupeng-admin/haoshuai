package com.haoshuai.app.mapper;

import com.github.pagehelper.Page;
import com.haoshuai.app.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List getProductInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllProductInfo();
    List getNutChildInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllNutChildInfo();
    List getHmcInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllHmcInfo();
    List getSaInfo(@Param("page") int page, @Param("limit") int limit);
    List getAllSaInfo();
    Product showProduct(Product p);
}
