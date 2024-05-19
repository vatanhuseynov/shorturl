package urlsh.example.demo.repo;

import urlsh.example.demo.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepo extends JpaRepository<UrlModel,String> {


    Optional<UrlModel> findUrlModelByLongUrl(String s);

    Optional<UrlModel> findUrlModelByShortUrl(String s);
}
