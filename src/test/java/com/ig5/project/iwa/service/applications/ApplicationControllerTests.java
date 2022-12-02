package com.ig5.project.iwa.service.applications;

import com.ig5.project.iwa.service.applications.jpa.entity.Application;
import com.ig5.project.iwa.service.applications.jpa.repository.ApplicationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApplicationControllerTests {

    private static final String ENDPOINT = "/applications/";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Mock
    private ApplicationRepository applicationRepository;

    @BeforeEach
    public void init() throws Exception {
        Application application = new Application();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    /**
     * Test getApplication_whenApplicationIDexistsinBDD_returnapplication_httpok()
     * Suppose that there is an existing application in the database with the following attributes
     * Application_id:1
     * Applicant_id:1
     * Offer_id:1
     * Created_at:2022-11-11
     * Status:AWAITING
     * Resume: A==
     * Recommendation:1
     *
     *@throws Exception
     */
    @Test
    void getApplication_whenApplicationIDexistsinBDD_returnapplication_httpok() throws Exception {

        int app_id = 1;
        // Local postgresql database
        mockMvc .perform(get("/applications/"+app_id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("application_id").value(app_id))
                .andExpect(jsonPath("applicant_id").value("1"))
                .andExpect(jsonPath("offer_id").value("1"))
                .andExpect(jsonPath("created_at").value("2022-11-11"))
                .andExpect(jsonPath("status").value("AWAITING"))
                .andExpect(jsonPath("resume").value("A=="))
                .andExpect(jsonPath("recommendation").value("1"));
    }

    @AfterEach
    public void afterTest() throws Exception {
        SecurityContextHolder.clearContext();
    }
}
