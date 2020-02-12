package com.evertonluissp.wirecardchallenge.controllers.v1;

import com.evertonluissp.wirecardchallenge.services.BracketsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.evertonluissp.wirecardchallenge.controllers.v1.BracketsController.PATH;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BracketsController.class)
public class BracketsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BracketsService service;

    @Test
    public void GET_validInput_Returns200() throws Exception {
        var validInput = RandomStringUtils.random(1);

        when(service.isBalancedBrackets(any())).thenReturn(true);

        mockMvc
                .perform(get(PATH).param("input", validInput))
                .andExpect(status().is(200));
    }

    @Test
    public void GET_invalidInput_Returns204() throws Exception {
        var validInput = RandomStringUtils.random(1);

        when(service.isBalancedBrackets(any())).thenReturn(false);

        mockMvc
                .perform(get(PATH).param("input", validInput))
                .andExpect(status().is(204));
    }

    @Test
    public void GET_withoutInput_Returns400() throws Exception {
        mockMvc
                .perform(get(PATH))
                .andExpect(status().is(400));
    }

}
