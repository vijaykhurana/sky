package com.sky.exercise.api;

import com.sky.exercise.util.RequiredForMarshalling;

import java.util.Objects;

/**
 * The channel subscription is known as the product in this bounded context
 */
public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @RequiredForMarshalling
    public Product() {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
