package devopP2.repositories;

import devopP2.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository< AppUser, Long> {
}
