package com.getir.subcategoryservice.service;

import com.getir.dto.SubcategoryResponse;
import com.getir.subcategoryservice.dto.SubcategoryRequest;


import java.util.List;
import java.util.UUID;

public interface SubcategoryService {
    List<SubcategoryResponse> getAllSubcategories();
    SubcategoryResponse getSubcategoriesBySlugTr(String slugTr);
    SubcategoryResponse getSubcategoriesBySlugEn(String slugEn);
    SubcategoryResponse createSubcategory(SubcategoryRequest request);
    SubcategoryResponse updateSubcategory(UUID id, SubcategoryRequest request);
    void deleteSubcategory(UUID id);
}
