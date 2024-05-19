package urlsh.example.demo.service;

import urlsh.example.demo.model.UrlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlsh.example.demo.repo.UrlRepo;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {
    private static final String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final UrlRepo urlRepo;

    @Autowired
    public UrlService(UrlRepo urlRepo){
        this.urlRepo = urlRepo;
    }

    public String saveUrl(String longUrl) {
     Optional<UrlModel> optionalUrlModel  = urlRepo.findUrlModelByLongUrl(longUrl);
       if (optionalUrlModel.isPresent()) {
            return optionalUrlModel.get().getShortUrl();
        }
        String shortUrl = makeShortUrl();
        UrlModel urlModel = new UrlModel(longUrl,shortUrl);

        urlRepo.save(urlModel);
        return shortUrl;
    }
    private String makeShortUrl(){
        StringBuilder s = new StringBuilder();
        Random r =new Random();
        for(int i = 0; i < 4; i++){
            s.append(elements.charAt(r.nextInt(elements.length())));
            }
        return s.toString();
        }

    public String findUrlByShorUrl(String shortUrl){
      Optional<UrlModel> optionalUrlModel = urlRepo.findUrlModelByShortUrl(shortUrl);

        return optionalUrlModel.get().getLongUrl();


    }


    }


