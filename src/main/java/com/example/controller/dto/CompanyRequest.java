package com.example.controller.dto;

public class CompanyRequest {
    private String name;

    private ResourceManagerDTO resourceManager;

    public String getName() {
        return this.name;
    }


    public ResourceManagerDTO getResourceManager() {
        return this.resourceManager;
    }
}
