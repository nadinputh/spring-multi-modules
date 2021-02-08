package dev.kolabot.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void isOdd() throws Exception {
        Integer number = 11;

        mvc.perform(get("/validate")
            .param("number", String.valueOf(number)))
            .andDo(print())
            .andExpect(status().is(200))
            .andExpect(jsonPath("$").value("Odd"));
    }

    @Test
    public void isEven() throws Exception {
        Integer number = 12;

        mvc.perform(get("/validate")
            .param("number", String.valueOf(number)))
            .andDo(print())
            .andExpect(status().is(200))
            .andExpect(jsonPath("$").value("Even"));
    }

    @Test
    public void isNotFound() throws Exception {
        mvc.perform(get("/validate/not_found"))
            .andDo(print())
            .andExpect(status().is(404));
    }


}
