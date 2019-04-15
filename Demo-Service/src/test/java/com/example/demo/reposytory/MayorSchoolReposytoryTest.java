package com.example.demo.reposytory;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
public class MayorSchoolReposytoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private MayorSchoolReposytory schoolRepository;
	
//	@Autowired
//	private SchoolDirectorKlassReposytory schoolDirectorKlassReposytory;
	
	static Klass klass;
	
	static School school;
	
	//@BeforeClass
	static public void setUpBeforeClass() {
		ArrayList<Klass> list = new ArrayList<Klass>();
		school = new School();
		school.setIndex("111111");
		school.setName("SCHOOL");
		school.setCountry("Russia");
		klass = new Klass();
		klass.setSchool(school);
		list.add(klass);
		school.setКlass(list);
		
	}
	
	//@Before
	public void setUpBefore() {
		entityManager.merge(school);	
	}
	//@org.junit.After
	public void setUpAfter() {
		entityManager.remove(school);
	}

	@Test
	@Commit
	public void testFindByCountry() {
		ArrayList<Klass> list = new ArrayList<Klass>();
		school = new School();
		school.setIndex("111111");
		school.setName("SCHOOL");
		school.setCountry("Russia");
		klass = new Klass();
		klass.setSchool(school);
		list.add(klass);
		school.setКlass(list);
		entityManager.persist(klass);
		
		
	}

	//@Test
	public void testFindByIndex() {
		School school2 = schoolRepository.findByIndex("111111").get(0);
		assertThat(school2.getIndex()).isEqualTo("111111");
	}

	//@Test
	public void testFindByName() {
		School school2 = schoolRepository.findByName("SCHOOL").get(0);
		assertThat(school2.getName()).isEqualTo("SCHOOL");
	}

}
