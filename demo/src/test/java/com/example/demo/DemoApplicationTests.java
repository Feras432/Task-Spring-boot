package com.example.demo;

import com.example.demo.entity.GuestEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.GuestSuggestionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.suggestions.SuggestionService;
import com.example.demo.service.user.UserService;
import com.example.demo.util.enums.SuggestionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@MockBean
	private GuestSuggestionRepository guestSuggestionRepository;

	@Autowired
	private SuggestionService suggestionService;

	@Test
	public void passLargerThanEight(){
		UserEntity user1 = new UserEntity();
		user1.setName("feras");
		user1.setPassword("254534535");

		UserEntity user2 = new UserEntity();
		user2.setName("mubarak");
		user2.setPassword("456356356");

		UserEntity user3 = new UserEntity();
		user3.setName("manal");
		user3.setPassword("453460");

		List<UserEntity> mockUsers = Arrays.asList(user1, user2, user3);

		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

		assertEquals(Arrays.asList("feras", "mubarak"), userService.getAllUsers());
	}
	@Test
	public void whenGetCreateStatusSuggestions_thenSuccess(){
		List<GuestEntity> suggestions = Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.CREATE));
		Mockito.when(guestSuggestionRepository.findAll()).thenReturn(suggestions);

		Assertions.assertEquals(Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus(), new GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus(), new GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus()), suggestionService.findSuggestions("CREATE").stream().map(GuestEntity::getStatus).collect(Collectors.toList()));
	}

	@Test
	public void whenGetRemoveStatusSuggestions_thenSuccess(){
		List<GuestEntity> suggestions = Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.CREATE));
		Mockito.when(guestSuggestionRepository.findAll()).thenReturn(suggestions);

		Assertions.assertEquals(Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.REMOVE).getStatus(), new GuestEntity("text", 5, SuggestionStatus.REMOVE).getStatus()), suggestionService.findSuggestions("REMOVE").stream().map(GuestEntity::getStatus).collect(Collectors.toList()));
	}

}

