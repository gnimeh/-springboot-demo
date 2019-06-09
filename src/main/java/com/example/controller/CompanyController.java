package com.example.controller;

import com.example.controller.dto.CompanyRequest;
import com.example.controller.dto.CompanyResponse;
import com.example.service.CompanyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @PostMapping("/companies")
    public CompanyResponse createCompany(@RequestBody CompanyRequest company) {
        return companyService.createCompany(company);
    }


    @PutMapping("/companies/{companyId}")
    public CompanyResponse updateCompany(@PathVariable Long companyId, @RequestBody CompanyRequest company) {
        return companyService.updateCompany(companyId, company);
    }

    @DeleteMapping("/companies/{companyId}")
    public CompanyResponse deleteCompany(@PathVariable Long companyId) {
        return companyService.deleteCompany(companyId);
    }

}
