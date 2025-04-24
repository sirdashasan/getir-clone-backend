package com.getir.subcategoryservice.service;

import com.getir.subcategoryservice.dto.SubcategoryRequest;
import com.getir.subcategoryservice.dto.SubcategoryResponse;
import com.getir.subcategoryservice.entity.Subcategory;
import com.getir.subcategoryservice.exceptions.ApiException;
import com.getir.subcategoryservice.mapper.SubcategoryMapper;
import com.getir.subcategoryservice.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubcategoryManager implements SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;

    @Override
    public List<SubcategoryResponse> getAllSubcategories() {
        return subcategoryRepository.findAll()
                .stream()
                .map(subcategoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SubcategoryResponse getSubcategoriesBySlugTr(String slugTr) {
        Subcategory subCategory = subcategoryRepository.findBySlugTr(slugTr);
        if (subCategory == null) {
            throw new ApiException("Subcategory not found with slugEn: " + slugTr, HttpStatus.NOT_FOUND);
        }
        return subcategoryMapper.toResponse(subCategory);
    }

    @Override
    public SubcategoryResponse getSubcategoriesBySlugEn(String slugEn) {
        Subcategory subCategory = subcategoryRepository.findBySlugEn(slugEn);
        if (subCategory == null) {
            throw new ApiException("Subcategory not found with slugEn: " + slugEn, HttpStatus.NOT_FOUND);
        }
        return subcategoryMapper.toResponse(subCategory);
    }

    @Override
    public SubcategoryResponse createSubcategory(SubcategoryRequest request) {
        boolean existsTr = subcategoryRepository.findBySlugTr(request.getSlugTr()) != null;
        boolean existsEn = subcategoryRepository.findBySlugEn(request.getSlugEn()) != null;

        if (existsTr || existsEn) {
            throw new ApiException("Subcategory with same slugTr or slugEn already exists", HttpStatus.BAD_REQUEST);
        }

        Subcategory subCategory = subcategoryMapper.toEntity(request);
        Subcategory saved = subcategoryRepository.save(subCategory);
        return subcategoryMapper.toResponse(saved);
    }

    @Override
    public SubcategoryResponse updateSubcategory(UUID id, SubcategoryRequest request) {
        Subcategory subCategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new ApiException("Subcategory not found with id: " + id, HttpStatus.NOT_FOUND));
        subcategoryMapper.updateEntity(subCategory, request);
        return subcategoryMapper.toResponse(subcategoryRepository.save(subCategory));
    }

    @Override
    public void deleteSubcategory(UUID id) {
        boolean exists = subcategoryRepository.existsById(id);
        if (!exists) {
            throw new ApiException("Subcategory not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        subcategoryRepository.deleteById(id);
    }
}
