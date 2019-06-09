package com.example.service;

import com.example.controller.dto.CompanyRequest;
import com.example.controller.dto.CompanyResponse;
import com.example.controller.dto.ResourceManagerDTO;
import com.example.entity.Company;
import com.example.entity.ResourceManager;
import com.example.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setName(companyRequest.getName());
        companyRepository.save(company);


        ResourceManagerDTO resourceManagerDTO = companyRequest.getResourceManager();
        ResourceManager resourceManager = new ResourceManager();
        resourceManager.setName(resourceManagerDTO.getName());
        resourceManager.setCompany(company);

        company.setResourceManager(resourceManager);

        return CompanyResponse.from(company);
    }

    @Transactional
    public CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(companyId).orElseThrow(RuntimeException::new);
        company.setName(companyRequest.getName());
        company.getResourceManager().setName(companyRequest.getResourceManager().getName());

        return CompanyResponse.from(company);

    }

    public CompanyResponse deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow(RuntimeException::new);
        companyRepository.delete(company);
        return CompanyResponse.from(company);
    }
}
