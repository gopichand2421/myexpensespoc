package com.expenses.userservice;

import com.expenses.userservice.util.Payloadinitializer;
import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserserviceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Description("Test for create user with ADMIN")
	@DisplayName("Test for create user with ADMIN")
	@Test
	void createUserWithAdminRole() throws Exception {
		ResultActions resultActions = mockMvc.perform(post("/v1/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Payloadinitializer.createUserWithRoleNameOnlyData()));
		resultActions.andExpect(status().isCreated());
	}

	@Test
	@DisplayName("Test for create user with USER")
	void createUserWithUserRole() throws Exception {
		ResultActions resultActions = mockMvc.perform(post("/v1/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Payloadinitializer.creatUserWithOnlyUserRole()));
		resultActions.andExpect(status().isCreated());
	}


}
