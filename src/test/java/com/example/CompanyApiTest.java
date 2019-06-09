package com.example;

import com.example.entity.Company;
import com.example.repository.CompanyRepository;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CompanyApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void should_get_hello_world() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world!"));
    }

    @Test
    public void should_create_company_given_company_info_when_create() throws Exception {
        mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"name\":\"TW\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Is.is("TW")));
        List<Company> companies = companyRepository.findAll();
        assertEquals("TW", companies.get(0).getName());
    }

    @Test
    public void should_create_company_with_resource_manager_given_company_and_resource_manager_info_when_create() throws Exception {
        mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{" +
                        "\"name\":\"TW\"," +
                        "\"resourceManager\":{" +
                        "    \"name\":\"rm\"" +
                        "   }" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Is.is("TW")))
                .andExpect(jsonPath("$.resourceManager.name", Is.is("rm")));
        List<Company> companies = companyRepository.findAll();
        assertEquals("TW", companies.get(0).getName());
        assertEquals("rm", companies.get(0).getResourceManager().getName());
    }

    @After
    public void tearDown() {
        companyRepository.deleteAll();
    }
}
