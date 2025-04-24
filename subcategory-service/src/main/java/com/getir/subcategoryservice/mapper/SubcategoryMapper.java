package com.getir.subcategoryservice.mapper;

import com.getir.subcategoryservice.dto.SubcategoryRequest;
import com.getir.subcategoryservice.dto.SubcategoryResponse;
import com.getir.subcategoryservice.entity.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryMapper {

    public Subcategory toEntity(SubcategoryRequest request) {
        return Subcategory.builder()
                .nameTr(request.getNameTr())
                .nameEn(request.getNameEn())
                .slugTr(request.getSlugTr().toLowerCase())
                .slugEn(request.getSlugEn().toLowerCase())
                .categorySlugTr(request.getCategorySlugTr().toLowerCase())
                .categorySlugEn(request.getCategorySlugEn().toLowerCase())
                .build();
    }

    public SubcategoryResponse toResponse(Subcategory subCategory) {
        return SubcategoryResponse.builder()
                .id(subCategory.getId())
                .nameTr(subCategory.getNameTr())
                .nameEn(subCategory.getNameEn())
                .slugTr(subCategory.getSlugTr())
                .slugEn(subCategory.getSlugEn())
                .categorySlugTr(subCategory.getCategorySlugTr())
                .categorySlugEn(subCategory.getCategorySlugEn())
                .build();
    }

    public void updateEntity(Subcategory subCategory, SubcategoryRequest request) {
        subCategory.setNameTr(request.getNameTr());
        subCategory.setNameEn(request.getNameEn());
        subCategory.setSlugTr(request.getSlugTr().toLowerCase());
        subCategory.setSlugEn(request.getSlugEn().toLowerCase());
        subCategory.setCategorySlugTr(request.getCategorySlugTr().toLowerCase());
        subCategory.setCategorySlugEn(request.getCategorySlugEn().toLowerCase());
    }
}
