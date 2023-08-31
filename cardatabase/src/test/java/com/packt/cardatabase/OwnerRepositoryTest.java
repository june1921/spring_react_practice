package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	@Autowired
	private OwnerRepository repos;
	
	
	@Test
	void saveOwner() {
		repos.save(new Owner("Lucy", "Lovegood"));
		assertThat(repos.findByFirstName("Lucy").isPresent()).isTrue();
	}
	
	@Test
	void deleteOwner() {
		repos.save(new Owner("Lisa", "Manobal"));
		repos.deleteAll();
		assertThat(repos.count()).isEqualTo(0);
	}

}
