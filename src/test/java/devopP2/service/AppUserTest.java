package devopP2.service;

import devopP2.dto.requests.AppUserRequest;
import devopP2.dto.responses.AppUserResponse;
import devopP2.model.AppUser;
import devopP2.repositories.AppUserRepository;
import devopP2.services.AppUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AppUserTest {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserRepository userRepository;

    @Test
    public void testToRegister(){
        AppUserRequest user = new AppUserRequest();
        user.setEmail("email@example.com");
        user.setPassword("password");
        user.setUsername("username");

        AppUserResponse response = appUserService.register(user);
        assertNotNull(response);
        assertTrue(response.getMessage().contains("Successful"));
        assertEquals(1, userRepository.findAll().size());
    }
}
