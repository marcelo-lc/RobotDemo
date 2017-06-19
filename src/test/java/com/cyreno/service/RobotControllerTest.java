package com.cyreno.service;

import com.cyreno.exception.InvalidCommandException;
import com.cyreno.exception.OutOfBoundsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.cyreno.model.Direction.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Reference: https://spring.io/guides/tutorials/bookmarks/#_testing_a_rest_service
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RobotControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        RobotCommandExecutor.setDebug(true);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testInvalidCommands() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/rest/mars/AAA"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(mvcResult.getResolvedException(), instanceOf(InvalidCommandException.class));

    }

    @Test
    public void testOutOfSurfaceBounds() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(mvcResult.getResolvedException(), instanceOf(OutOfBoundsException.class));

    }

    @Test
    public void testOutOfSurfaceBoundsByOneMove() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/rest/mars/MMMMM"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(mvcResult.getResolvedException(), instanceOf(OutOfBoundsException.class));

    }

    @Test
    public void testRegularRouteMMRMMRMM() throws Exception {

        String expectedResponse = RobotResponseFormatter.getResponseAsText(2, 0, SOUTH);

        mockMvc.perform(post("/rest/mars/MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));

    }

    @Test
    public void testRegularRouteMML() throws Exception {

        String expectedResponse = RobotResponseFormatter.getResponseAsText(0, 2, WEST);

        mockMvc.perform(post("/rest/mars/MML"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));

    }

    @Test
    public void testRegularFullLapOverTheEdgesClockwise() throws Exception {

        String expectedResponse = RobotResponseFormatter.getResponseAsText(0, 0, NORTH);

        String commands = "MMMM" + "RMMMM" + "RMMMM" + "RMMMM" + "R";

        mockMvc.perform(post("/rest/mars/" + commands))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));


    }

    @Test
    public void testRegularFullLapOverTheEdgesAntiClockwise() throws Exception {

        String expectedResponse = RobotResponseFormatter.getResponseAsText(0, 0, NORTH);

        String commands = "RMMMM" + "LMMMM" + "LMMMM" + "LMMMM" + "RR";

        mockMvc.perform(post("/rest/mars/" + commands))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));


    }

}