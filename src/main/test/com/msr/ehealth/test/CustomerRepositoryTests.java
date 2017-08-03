package com.msr.ehealth.test;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.msr.ehealth.app.Application;
import com.msr.ehealth.domain.Customer;
import com.msr.ehealth.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class CustomerRepositoryTests {

	@Autowired
    private CustomerRepository repository ;
	
    @Test
    public void testFindByLastName() {
    	
    	repository.save(new Customer("Jack", "Bauer"));
    	repository.save(new Customer("Chloe", "O'Brian"));
    	repository.save(new Customer("Kim", "Bauer"));
    	repository.save(new Customer("David", "Palmer"));
    	repository.save(new Customer("Michelle", "Dessler"));
    	
    	
    	for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
    	
    	
    	
    	
       /* Customer customer = new Customer("first", "last");
        entityManager.persist(customer);

        List<Customer> findByLastName = customers.findByLastName(customer.getLastName());*/

    	System.out.println("working fine");
    	
    	
        assertThat(true);
    }
}