package com.example.controller.dto;

import com.example.entity.ResourceManager;

public class ResourceManagerDTO {
    private String name;

    public ResourceManagerDTO() {

    }

    public static ResourceManagerDTO form(ResourceManager resourceManager) {
        ResourceManagerDTO resourceManagerDTO = new ResourceManagerDTO();
        resourceManagerDTO.setName(resourceManager.getName());
        return resourceManagerDTO;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
