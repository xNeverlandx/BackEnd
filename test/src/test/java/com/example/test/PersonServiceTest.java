package com.example.test;

import com.example.test.model.Person;
import com.example.test.model.enums.Gender;
import com.example.test.repository.PersonRepository;
import com.example.test.services.PersonService;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class PersonServiceTest {

	@Mock
	PersonRepository personRepository;

	@InjectMocks
	PersonService personService;

	@Test
	public void getPersonByIdAndDate() {
		var id = 7L;
		var date = "1997-06-02";
		LocalDate localDate = LocalDate.parse(date);
		List<Person> person = new ArrayList<>();
		person.add(new Person(7L, "Erik", "Kirves", Gender.Male, localDate));

		doReturn(person).when(personRepository).findAll();

		List<Person> expected = personService.findPerson(id, localDate);

		assertEquals(expected, person);
	}

}
