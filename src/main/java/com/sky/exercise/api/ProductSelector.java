package com.sky.exercise.api;

import com.google.common.collect.Multimap;

public interface ProductSelector {

    Multimap<Category, Product> selectProducts();
}
