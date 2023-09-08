package com.example.resource_project;

import com.example.resource_project.Entity.ResourceCodeEntity;
import com.example.resource_project.Repository.ResourceCodeRepository;
import com.example.resource_project.Repository.ResourceInfoRepository;
import com.example.resource_project.dto.Resource.resourceCodeSaveDto;
import com.example.resource_project.dto.Resource.resourceInfoSaveDto;
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

import java.util.ArrayList;
import java.util.Date;
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
    private ResourceCodeRepository codeRepository;
    @Autowired
    private ResourceInfoRepository infoRepository;

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
        String name = "test02";
        float firstPrice = 10000;
        String unit = "단위";

        resourceCodeSaveDto requestDto = resourceCodeSaveDto.builder()
                .name(name)
                .firstPrice(firstPrice)
                .unit(unit)
                .build();

        String url = "http://localhost:" + port + "/resource/codesave";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<ResourceCodeEntity> all = codeRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getFirstPrice()).isEqualTo(firstPrice);
    }

    @Test
    public void Info_save_test() throws Exception{
        //given
        List<String> name = new ArrayList<String>() ;
        name.add("test01");
        name.add("test02");
        List<Float> price = new ArrayList<Float>();
        price.add(10000f);
        price.add(20000f);
        String today = new Date().toString();

        resourceInfoSaveDto requestDto = resourceInfoSaveDto.builder()
                .name(name)
                .price(price)
                .acquisitionTime(today)
                .build();

        String url = "http://localhost:" + port + "/resource/infosave";

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<ResourceCodeEntity> all = codeRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getFirstPrice()).isEqualTo(price);
    }
}
