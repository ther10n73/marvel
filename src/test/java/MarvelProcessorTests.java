import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.marvelApi.MainApplication;
import ru.marvelApi.models.data.Data;
import ru.marvelApi.processor.MarvelProcessor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by Khartonov Oleg on 26.04.2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MarvelProcessor.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = MainApplication.class)
public class MarvelProcessorTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    public MarvelProcessor marvelProcessor;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    @Test
    public  void headerTest() throws Exception {
        MockHttpServletRequestBuilder request = get("/");
        ResultActions result = mockMvc.perform(request);
        result.andExpect(content().string("Welcome to Marvel Library!"));
    }

    @Test
    public void returnCharacterDataTest() throws Exception {
               Data ch = marvelProcessor.getInfoForId("characters", 1011175);
        Assert.assertEquals(1011175, ch.getId());
        Assert.assertEquals("http://gateway.marvel.com/v1/public/characters/1011175", ch.getResourceURI());
    }
}
