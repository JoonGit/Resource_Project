package com.jojoldu.book.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.book.spring.domain.posts.Repository.HelloRepository;
import com.jojoldu.book.spring.domain.posts.Entity.TestEntity;
import com.jojoldu.book.spring.web.dto.Hello.HelloSaveRequestDto;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private HelloRepository helloRepository;

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
    public void hello_save_test() throws Exception{
        //given
        String name = "title_test";
        String amount = "content_test";
        HelloSaveRequestDto requestDto = HelloSaveRequestDto.builder()
                .name(name)
                .amount(amount)
                .build();

        String url = "http://localhost:" + port + "/hello/save";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<TestEntity> all = helloRepository.findAll();
//        assertThat(all.get(0).getName()).isEqualTo(name);
//        assertThat(all.get(0).getName()).isEqualTo(amount);
    }
//    @Test
//    public void hello_return() throws Exception {
//        String hello = "hello";
//
//        mvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(hello));
//    }
//
//    @Test
//    public void Dto_return() throws Exception {
//        String name = "hello";
//        int amount = 1000;
//
//        mvc.perform(
//                        get("/hello/dto")
//                                .param("name", name)
//                                .param("amount", String.valueOf(amount)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(name)))
//                .andExpect(jsonPath("$.amount", is(amount)));
//    }
}