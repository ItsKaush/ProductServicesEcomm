package dev.kaushar.productservices.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getInCategory(Long categoryId) {
        return null;
    }
}
