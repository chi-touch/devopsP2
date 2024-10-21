package devopP2.services;

import devopP2.dto.requests.AppUserRequest;
import devopP2.dto.responses.AppUserResponse;
import devopP2.model.AppUser;
import devopP2.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService{


    private final ModelMapper mapper;
    private  final AppUserRepository appUserRepository;
    @Override
    public AppUserResponse register(AppUserRequest appUserRequest) {
        AppUser appUser = mapper.map(appUserRequest, AppUser.class);
        appUserRepository.save(appUser);
        AppUserResponse response = mapper.map(appUser, AppUserResponse.class);
        response.setMessage("Successful");
        return response;

    }
}
