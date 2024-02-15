package com.example.demo;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	public void whenUsersPasswordIsLargerThan8Digit_thenSuccess(){
//		List<UserEntity> mockUsersPassword = Arrays.asList(
//				new UserEntity("")
//		);
	}
}
