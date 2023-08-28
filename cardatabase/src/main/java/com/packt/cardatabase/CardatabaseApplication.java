package com.packt.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		// 이 주석을 추가하면 애플리케이션이 재시작됨
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("애플리케이션이 시작됨.");
		logger.trace("애플리케이션이 시작됨. trace");
	}

	@Override
	public void run(String... args) throws Exception {
		// 이곳에 코드를 추가.

		Owner owner1 = new Owner("John", "Doe");
		Owner owner2 = new Owner("Mary", "Sue");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		repository.save(new Car("Hyundai", "Sonata", "White", "AEF-3002", 2019, 29000, owner1));
		repository.save(new Car("Kia", "Forte", "Black", "AFF-1230", 2020, 23000, owner2));

		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
		// user 사용자 등록
		urepository.save(new User("user", "$2a$10$WnXHM1xgxA6.BJBZeDCTK.Cix9fbJEl4MVXU7o2ZZEPRD5KJJPafO", "USER"));
		urepository.save(new User("admin", "$2a$10$0irZWy28ya6cPML43TH2AOEu5vzBZXAsa9Zcn.DpjgA2T48OqacX.", "ADMIN"));
	}

}