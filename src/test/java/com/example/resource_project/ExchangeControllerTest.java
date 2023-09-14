package com.example.resource_project;

import com.example.resource_project.Entity.ExchangeTb;
import com.example.resource_project.Entity.ResourceTb;
import com.example.resource_project.Entity.UnitTb;
import com.example.resource_project.Repository.ResourceInfoRepository;
import com.example.resource_project.Repository.ResourceTbRepository;
import com.example.resource_project.Repository.UnitTbRepository;
import com.example.resource_project.dto.Resource.ExchageInfoTbSaveDto;
import com.example.resource_project.dto.Resource.ExchageTbSaveDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExchangeControllerTest {


    @LocalServerPort
    private int port;

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
    public void TbSave()throws Exception{

        //given
        String currencyName = "Name";
        String currencySymbol = "Symbol";
        String country = "country";

        ExchageTbSaveDto requestDto = ExchageTbSaveDto.builder()
                .currencyName(currencyName)
                .currencySymbol(currencySymbol)
                .country(country)
                .build();


        String url = "http://localhost:" + port + "/exchange/tbsave";
        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void infoSave()throws Exception{

        //given
        String exchangeDatePk = LocalDate.now().toString();
        int exchangeRate = 10000;
        String currencyName = "Name";

        ExchageInfoTbSaveDto requestDto = ExchageInfoTbSaveDto.builder()
                .exchangeDatePk(exchangeDatePk)
                .exchangeRate(exchangeRate)
                .currencyName(currencyName)
                .build();


        String url = "http://localhost:" + port + "/exchange/infosave";
        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
    }
}
