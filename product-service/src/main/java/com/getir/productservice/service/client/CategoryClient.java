package com.getir.productservice.service.client;

import com.getir.dto.CategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service", url = "http://category-service:8082/getir/api/categories")
public interface CategoryClient {

    @GetMapping("/slug-tr/{slug}")
    CategoryResponse getBySlugTr(@PathVariable String slug);

    @GetMapping("/slug-en/{slug}")
    CategoryResponse getBySlugEn(@PathVariable String slug);
}