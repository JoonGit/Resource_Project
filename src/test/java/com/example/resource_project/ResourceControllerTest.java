package com.example.resource_project;

import com.example.resource_project.Entity.Resource_tb;
import com.example.resource_project.Entity.Unit_tb;
import com.example.resource_project.Repository.Resource_tb_repository;
import com.example.resource_project.Repository.Resource_info_repository;
import com.example.resource_project.Repository.Unit_tb_repository;
import com.example.resource_project.dto.Resource.Resource_price_info_tb_save_dto;
import com.example.resource_project.dto.Resource.Resource_tb_save_dto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResourceControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private Resource_tb_repository codeRepository;
    @Autowired
    private Resource_info_repository infoRepository;
    @Autowired
    private Unit_tb_repository unitRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void Code_save_test() throws Exception{
        //given
        String resource_eng_name = "영어";
        String resource_kor_name = "한글";
        String resource_symbol = "단위";
        String unit_name = "유닛";

        Resource_tb_save_dto requestDto = Resource_tb_save_dto.builder()
                .resource_eng_name(resource_eng_name)
                .resource_kor_name(resource_kor_name)
                .resource_symbol(resource_symbol)
                .unit_name(unit_name)
                .build();

        String url = "http://localhost:" + port + "/resource/codesave";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Resource_tb> all = codeRepository.findAll();
        List<Unit_tb> unit_all = unitRepository.findAll();

        assertThat(all.get(0).getResourceEngName()).isEqualTo(resource_eng_name);
        assertThat(all.get(0).getResourceKorName()).isEqualTo(resource_kor_name);
        assertThat(all.get(0).getResourceSymbol()).isEqualTo(resource_symbol);
        assertThat(unit_all.get(0).getUnitName()).isEqualTo(unit_name);
    }

    @Test
    public void Info_save_test() throws Exception{
        //given
        String resource_date_pk = LocalDate.now().toString();
        float price = 10000;
        String resource_tb_symbol = "단위";
        String unit_id_name = "유닛";

//        List<Resource_price_info_tb_save_dto> test = List<Resource_price_info_tb_save_dto>;

        Resource_price_info_tb_save_dto requests = Resource_price_info_tb_save_dto.builder()
                .resource_date_pk(resource_date_pk)
                .price(price)
                .resource_tb_symbol(resource_tb_symbol)
                .unit_id_name(unit_id_name)
                .build();


        String url = "http://localhost:" + port + "/resource/infosave";




        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requests)))
                .andExpect(status().isOk());

        //then
        List<Resource_tb> all = codeRepository.findAll();
//        assertThat(all.get(0).getResource_eng_name()).isEqualTo(name);
//        assertThat(all.get(0).getResource_kor_name()).isEqualTo(price);
    }
}
