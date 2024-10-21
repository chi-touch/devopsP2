package devopP2.services;

import devopP2.dto.requests.AppUserRequest;
import devopP2.dto.responses.AppUserResponse;

public interface AppUserService {

    AppUserResponse register(AppUserRequest appUserRequest);
}
