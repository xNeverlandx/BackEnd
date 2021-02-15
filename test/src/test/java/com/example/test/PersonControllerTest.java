package com.example.test;

import com.example.test.model.Person;
import com.example.test.model.enums.Gender;
import com.example.test.repository.PersonRepository;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void getAllPersons() throws Exception {
        List<Person> personList = new ArrayList<>();
        var date = "1997-06-02";
        var date1 = "1548-03-01";
        var date2 = "1666-05-04";
        LocalDate localDate = LocalDate.parse(date);
        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);
        personList.add(new Person(7L, "Erik", "Kirves", Gender.Male, localDate));
        personList.add(new Person(23L, "asd", "dasa", Gender.Female, localDate1));
        personList.add(new Person(65L, "ety", "kjh", Gender.Male, localDate2));

        doReturn(personList).when(personRepository).findAll();

        this.mockMvc
                .perform(get("/person/getAllPerson"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(personList.size())))
                .andExpect(jsonPath("$[0].id", is(7)));
    }
}
