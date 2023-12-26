package com.GasBookingApplication.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.GasBookingApplication.CustomerException.CustomerNotFoundException;
import com.GasBookingApplication.Dto.BankDto;
import com.GasBookingApplication.Dto.CustomerDto;
import com.GasBookingApplication.Dto.CylinderDto;
import com.GasBookingApplication.Model.Customer;
import com.GasBookingApplication.OpenFeign.BankClient;
import com.GasBookingApplication.OpenFeign.CylinderClient;
import com.GasBookingApplication.Repository.CustomerRepository;
import com.GasBookingApplication.Service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CylinderClient cylinderClient;
	@Autowired
	private BankClient bankClient;


	@Override
	public CustomerDto insertCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer customer = modelMapper.map(customerDto, Customer.class);
		Customer savedCustomer = customerRepo.save(customer);
		CustomerDto customerDto1 = modelMapper.map(savedCustomer, CustomerDto.class);

		return customerDto1;
	}

	@Override
	public String updateCustomer(int customerId, CustomerDto customerDto) {
		Optional<Customer> cy = customerRepo.findById(customerId);

		if (cy.isPresent()) {
			Customer updateCustomer = cy.get();
			updateCustomer.setAccountNo(customerDto.getAccountNo());
			updateCustomer.setIfscNo(customerDto.getIfscNo());
			updateCustomer.setPan(customerDto.getPan());
			// updateCustomer.setCustomerId(customerDto.getCustomerId());

			customerRepo.save(updateCustomer);
			return "customer with ID " + customerId + " updated successfully";

		} else {
			throw new CustomerNotFoundException("customerId id not found:" + customerId);
		}
	}

	@Override
	public String deleteCustomer(int customerId) {
		// TODO Auto-generated method stub

		Optional<Customer> c = customerRepo.findById(customerId);
		if (c.isPresent()) {

			customerRepo.delete(c.get());
			return "deleted successfully";
		} else {
			throw new CustomerNotFoundException("Customer id not found:" + customerId);
		}
	}

	@Override
	public CustomerDto viewCustomerById(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepo.findById(customerId);
		if (customer.isPresent()) {
			Customer cu = customer.get();
			CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
			// for cylinder
			ResponseEntity<CylinderDto> cylinderResponseEntity = cylinderClient.viewById(customerId);
			CylinderDto cylDto = cylinderResponseEntity.getBody();
			customerDto.setCylinderDto(cylDto);
			// for bank
			ResponseEntity<BankDto> bankResponseEntity = bankClient.viewById(customerId);
			BankDto bankDto = bankResponseEntity.getBody();
			customerDto.setBankDto(bankDto);
	
			

			return customerDto;
		} else {
			throw new CustomerNotFoundException("Customer id not found:" + customerId);

		}
	}

	// I should complete this
	@Override
	public List<CustomerDto> viewCustomers() {
		List<Customer> customers = customerRepo.findAll();

		if (customers.isEmpty()) {
			throw new CustomerNotFoundException("Hey, the customer list is empty");
		}

		// Use ModelMapper to map List<Customer> to List<CustomerDto>
		List<CustomerDto> customerDtoList = customers.stream()
				.map(customer -> modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
		
		return customerDtoList;
	}

}