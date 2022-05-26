package com.bootcamp.reactive.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootcamp.reactive.entity.CustomerBusiness;
import com.bootcamp.reactive.entity.CustomerPersonal;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService service;

	@Test
	public void when_saveCustomerPersonal_ok() {

		CustomerPersonal customer = new CustomerPersonal();

		// ESTO SE LE MANDA AL SERVICE
		customer.setFirstName("Raul");
		customer.setLastName("Castro");
		customer.setDni(76865456);
		customer.setPhoneNumber(939393239);
		
		StepVerifier.create(service.saveCustomerPersonal(Mono.just(customer)))
        .expectNext(customer)
        .expectComplete()
        .verify();
	}
	
	@Test
	public void when_saveCustomerBusiness_ok() {

		CustomerBusiness customer = new CustomerBusiness();

		// ESTO SE LE MANDA AL SERVICE
		customer.setFirstName("Raul");
		customer.setLastName("Castro");
		customer.setDni(76865456);
		customer.setPhoneNumber(939393239);
		
		StepVerifier.create(service.saveCustomerBusiness(Mono.just(customer)))
        .expectNext(customer)
        .expectComplete()
        .verify();
	}
	
	@Test
    public void when_getCustomerPersonal_ok(){
		CustomerPersonal customer = new CustomerPersonal();

		// ESTO SE LE MANDA AL SERVICE
		customer.setFirstName("Raul");
		customer.setLastName("Castro");
		customer.setDni(76865456);
		customer.setPhoneNumber(939393239);

        StepVerifier.create(service.getCustomerByDni(76865456))
            .expectNext(customer)
            .expectComplete()
            .verify();
    }
}
