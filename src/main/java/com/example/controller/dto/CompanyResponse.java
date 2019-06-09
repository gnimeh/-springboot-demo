package com.example.controller.dto;

import com.example.entity.Company;

public class CompanyResponse {
    private Long id;
    private String name;
    private ResourceManagerDTO resourceManager;

    public static CompanyResponse from(Company company) {
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setName(company.getName());
        companyResponse.setId(company.getId());
        companyResponse.setResourceManager(ResourceManagerDTO.form(company.getResourceManager()));
        return companyResponse;
    }

    public CompanyResponse() {
    }

    public CompanyResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceManagerDTO getResourceManager() {
        return resourceManager;
    }

    public void setResourceManager(ResourceManagerDTO resourceManager) {
        this.resourceManager = resourceManager;
    }
}
