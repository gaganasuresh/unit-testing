package test.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourceTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HelloResource helloResource;
    @Before
    public void setUp() throws Exception{
        mockMvc=MockMvcBuilders.standaloneSetup((helloResource))
                .build();
    }
    @Test
    public void testhello() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/hello"))
                .andExpect((MockMvcResultMatchers.status().isOk()))
                .andExpect(MockMvcResultMatchers.content().string("hello world"));
    }

}