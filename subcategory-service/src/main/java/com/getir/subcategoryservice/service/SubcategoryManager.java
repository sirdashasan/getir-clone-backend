package com.getir.subcategoryservice.service;

import com.getir.subcategoryservice.dto.SubcategoryRequest;
import com.getir.subcategoryservice.dto.SubcategoryResponse;
import com.getir.subcategoryservice.entity.Subcategory;
import com.getir.subcategoryservice.mapper.SubcategoryMapper;
import com.getir.subcategoryservice.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;

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
    public SubcategoryResponse getBySlugTr(String slugTr) {
        Subcategory subCategory = subcategoryRepository.findBySlugTr(slugTr);
        if (subCategory == null) {
            throw new RuntimeException("Subcategory not found with slugTr: " + slugTr);
        }
        return subcategoryMapper.toResponse(subCategory);
    }

    @Override
    public SubcategoryResponse getBySlugEn(String slugEn) {
        Subcategory subCategory = subcategoryRepository.findBySlugEn(slugEn);
        if (subCategory == null) {
            throw new RuntimeException("Subcategory not found with slugEn: " + slugEn);
        }
        return subcategoryMapper.toResponse(subCategory);
    }

    @Override
    public SubcategoryResponse createSubcategory(SubcategoryRequest request) {
        boolean existsTr = subcategoryRepository.findBySlugTr(request.getSlugTr()) != null;
        boolean existsEn = subcategoryRepository.findBySlugEn(request.getSlugEn()) != null;

        if (existsTr || existsEn) {
            throw new RuntimeException("Subcategory with same slugTr or slugEn already exists");
        }

        Subcategory subCategory = subcategoryMapper.toEntity(request);
        Subcategory saved = subcategoryRepository.save(subCategory);
        return subcategoryMapper.toResponse(saved);
    }

    @Override
    public SubcategoryResponse updateSubcategory(UUID id, SubcategoryRequest request) {
        Subcategory subCategory = subcategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subcategory not found with id: " + id));
        subcategoryMapper.updateEntity(subCategory, request);
        return subcategoryMapper.toResponse(subcategoryRepository.save(subCategory));
    }

    @Override
    public void deleteSubcategory(UUID id) {
        boolean exists = subcategoryRepository.existsById(id);
        if (!exists) {
            throw new RuntimeException("Subcategory not found with id: " + id);
        }
        subcategoryRepository.deleteById(id);
    }
}
