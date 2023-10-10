package com.petstore.api.pets;

import java.util.ArrayList;
import java.util.Objects;


public class PetEntity {
    public int id;
    public long Id;
    public PetCategoryEntity category;
    public String name;
    public ArrayList<String> photosUrls;
    public ArrayList<TagEntity> tags;
    public String status;

    public PetEntity(PetCategoryEntity category, String name, ArrayList<String> photosUrls, ArrayList<TagEntity> tags, String status) {
        this.category = category;
        this.name = name;
        this.photosUrls = photosUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetEntity(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setId (long Id) {
        this.Id = Id;
    }

    public void setCategory(PetCategoryEntity category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotosUrls(ArrayList<String> photosUrls) {
        this.photosUrls = photosUrls;
    }

    public void setTags(ArrayList<TagEntity> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetEntity petEntity = (PetEntity) o;
        return Objects.equals(category, petEntity.category) && Objects.equals(name, petEntity.name) && Objects.equals(photosUrls, petEntity.photosUrls) && Objects.equals(tags, petEntity.tags) && Objects.equals(status, petEntity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, photosUrls, tags, status);
    }
}
