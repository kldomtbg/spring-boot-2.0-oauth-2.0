package com.ywsoftware.oa.authserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ywsoftware.oa.authserver.repository.CustomerRepository;
import com.ywsoftware.oa.authserver.util.CustomerTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository repository;

    private String token;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getAccessToken(String username, String password) throws Exception {
        String authorization = "Basic "
                + new String(Base64Utils.encode("spring-security-oauth2-read-write-client:spring-security-oauth2-read-write-client-password1234".getBytes()));
        String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

        // @formatter:off
        String content = mockMvc
                .perform(
                        post("/oauth/token")
                                .header("Authorization", authorization)
                                .contentType(
                                        MediaType.APPLICATION_FORM_URLENCODED)
                                .param("username", username)
                                .param("password", password)
                                .param("grant_type", "password")
                                .param("scope", "read write")
                                .param("client_id", "spring-security-oauth2-read-write-client")
                                .param("client_secret", "spring-security-oauth2-read-write-client-password1234"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.access_token", is(notNullValue())))
                .andExpect(jsonPath("$.token_type", is(equalTo("bearer"))))
                .andExpect(jsonPath("$.refresh_token", is(notNullValue())))
                .andExpect(jsonPath("$.expires_in", is(greaterThan(4000))))
                .andExpect(jsonPath("$.scope", is(equalTo("read write"))))
                .andReturn().getResponse().getContentAsString();

        // @formatter:on

        return content.substring(17, 53);
    }

    @Before
    public void setUp() throws Exception {
        token = getAccessToken("admin", "admin1234");
    }

    @Test
    public void getAllCustomersSuccess() throws Exception {
        this.mockMvc.perform(
                get("/secured/customer")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void searchCustomersSuccess() throws Exception {
        this.mockMvc.perform(
                get("/secured/customer")
                        .param("search", "name:User, email:3")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("User3")));
    }

    @Test
    public void getOneCustomerSuccess() throws Exception {
        this.mockMvc.perform(
                get("/secured/customer/{id}", 1)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("User1")));
    }

    @Test
    public void getOneCustomerFailNotFound() throws Exception {
        this.mockMvc.perform(
                get("/secured/customer/{id}", 6)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isNotFound());
    }

    @Test
    public void postCreateCustomerSuccess() throws Exception {
        this.mockMvc.perform(
                post("/secured/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                asJsonString(
                                        CustomerTestUtil.buildCustomer("newCustomer4",
                                                "mail@mail.com",
                                                "7777777777")
                                )
                        )
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    public void postCreateCustomerFailBadRequest() throws Exception {
        this.mockMvc.perform(
                post("/secured/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                asJsonString(
                                        CustomerTestUtil.buildCustomer(
                                                "newCustomer4",
                                                "mail",
                                                "123"
                                        )
                                )
                        )
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void putUpdateCustomerSuccess() throws Exception {
        String emailBeforeUpdate = repository.findById(2L).get().getEmail();

        this.mockMvc.perform(
                put("/secured/customer/{id}", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                asJsonString(
                                        CustomerTestUtil.buildCustomer(
                                                "User2",
                                                "newEmail@mail.test",
                                                "2222222222"
                                        )
                                )
                        )
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());

        String emailAfterUpdate = repository.findById(2L).get().getEmail();

        assertThat(emailBeforeUpdate).isNotEqualToIgnoringCase(emailAfterUpdate);
    }

    @Test
    public void putUpdateCustomerFailedBadRequest() throws Exception {
        String emailBeforeUpdate = repository.findById(3L).get().getEmail();

        this.mockMvc.perform(
                put("/secured/customer/{id}", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                asJsonString(
                                        CustomerTestUtil.buildCustomer(
                                                "User3",
                                                "newEmail@mail.test",
                                                "invalidPhone"
                                        )
                                )
                        )
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isBadRequest());

        String emailAfterUpdate = repository.findById(3L).get().getEmail();

        assertThat(emailBeforeUpdate).isEqualTo(emailAfterUpdate);
    }

    @Test
    public void deleteCustomerSuccess() throws Exception {
        assertThat(repository.existsById(2L)).isTrue();

        this.mockMvc.perform(
                delete("/secured/customer/{id}", 2)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());

        assertThat(repository.existsById(2L)).isFalse();
    }
}
