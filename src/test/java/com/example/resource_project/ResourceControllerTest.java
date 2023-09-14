package com.example.resource_project;

import com.example.resource_project.Entity.ResourceTb;
import com.example.resource_project.Entity.UnitTb;
import com.example.resource_project.Repository.ResourceTbRepository;
import com.example.resource_project.Repository.ResourceInfoRepository;
import com.example.resource_project.Repository.UnitTbRepository;
import com.example.resource_project.dto.Resource.ResourcePriceInfoTbSaveDto;
import com.example.resource_project.dto.Resource.ResourceTbSaveDto;
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
    private ResourceTbRepository codeRepository;
    @Autowired
    private ResourceInfoRepository infoRepository;
    @Autowired
    private UnitTbRepository unitRepository;

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

        ResourceTbSaveDto requestDto = ResourceTbSaveDto.builder()
                .resourceEngName(resource_eng_name)
                .resourceKorName(resource_kor_name)
                .resourceSymbol(resource_symbol)
                .unitName(unit_name)
                .build();

        String url = "http://localhost:" + port + "/resource/codesave";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<ResourceTb> all = codeRepository.findAll();
        List<UnitTb> unit_all = unitRepository.findAll();

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

        ResourcePriceInfoTbSaveDto requests = ResourcePriceInfoTbSaveDto.builder()
                .resourceDatePk(resource_date_pk)
                .price(price)
                .resourceTbSymbol(resource_tb_symbol)
                .unitIdName(unit_id_name)
                .build();


        String url = "http://localhost:" + port + "/resource/infosave";




        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requests)))
                .andExpect(status().isOk());

        //then
        List<ResourceTb> all = codeRepository.findAll();
//        assertThat(all.get(0).getResource_eng_name()).isEqualTo(name);
//        assertThat(all.get(0).getResource_kor_name()).isEqualTo(price);
    }
}
