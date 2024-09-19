package com.example.test.test.integration;

import com.example.test.test.models.entities.Employee;
import com.example.test.test.models.enums.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManagerFactory;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest2 {

    @Autowired
    private DatabaseStepProvider databaseStepProvider;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        databaseStepProvider.deleteEmployees();
    }

    @ParameterizedTest
    @MethodSource("employeeProvider")
    void test(Employee employee) throws Exception {
        databaseStepProvider.saveEntity(employee);
        //Когда
        var response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/employee/all")
                ).andDo(print())
                //Тогда
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse();
        var actualResponse = new ObjectMapper().readValue(response.getContentAsString(), new TypeReference<List<Employee>>() {
        });
        assertThat(actualResponse).usingRecursiveComparison()
                .isEqualTo(List.of(employee));
    }

    private static Stream<Arguments> employeeProvider() {
        var employeeWithEmptyName = Instancio.create(Employee.class);
        employeeWithEmptyName.setEmployeeName("");
        return Stream.of(
                Arguments.of(
                        Instancio.create(Employee.class)
                ),
                Arguments.of(
                        Instancio.create(Employee.class)
                ),
                Arguments.of(
                        Instancio.create(Employee.class)
                ),
                Arguments.of(
                        employeeWithEmptyName
                )
        );
    }
}
