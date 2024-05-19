package urlsh.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShortUrl {
    private final Map<String, String> mapShorUrl;
    private static final String elements ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public ShortUrl(){
        this.mapShorUrl = new HashMap<>();
    }
    private String shortentUrl(String longUrl){
        if(mapShorUrl.containsKey(longUrl)){
            return mapShorUrl.get(longUrl);
        }
        String url = makeShortUrl();
        mapShorUrl.put(longUrl,url);
        return url;
    }


    private String makeShortUrl(){
        StringBuilder s = new StringBuilder();
        Random r =new Random();
        for(int i = 0; i < 4; i++){
            s.append(elements.charAt(r.nextInt(elements.length())));
        }

        return s.toString();
    }



    public static void main(String[] args) {
        ShortUrl shortObj = new ShortUrl();
        String longUrl = "http://www.example.com/example";
        System.out.println(shortObj.shortentUrl(longUrl));

    }
        }

