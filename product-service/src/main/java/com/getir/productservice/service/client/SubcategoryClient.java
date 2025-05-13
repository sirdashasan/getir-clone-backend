package com.getir.productservice.service.client;

import com.getir.dto.SubcategoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subcategory-service", url = "http://subcategory-service:8083/getir/api/subcategories")
public interface SubcategoryClient {

    @GetMapping("/slug-tr/{slug}")
    SubcategoryResponse getBySlugTr(@PathVariable String slug);

    @GetMapping("/slug-en/{slug}")
    SubcategoryResponse getBySlugEn(@PathVariable String slug);
}