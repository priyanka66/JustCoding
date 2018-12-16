package Medium;

import java.util.*;

public class TinyURL {
    public static void main(String[] args){
        String givenURL = "https://leetcode.com/problems/design-tinyurl";
        String givenURL2 = "https://leetcode.com/problems/ngised-tinyurl";
        HashMap<String,String> tinyURL = new HashMap<String, String>();
        HashMap<String,String> longURL = new HashMap<String, String>();

        String shortURL = encode(givenURL,tinyURL,longURL);
        System.out.println("shortURL: "+shortURL);
        String decodedURL = decode(shortURL,tinyURL);
        System.out.println("decodedURL: "+decodedURL);

        shortURL = encode(givenURL2,tinyURL,longURL);
        System.out.println("shortURL: "+shortURL);
        decodedURL = decode(shortURL,tinyURL);
        System.out.println("decodedURL: "+decodedURL);

    }

    private static String encode(String givenURL, HashMap<String, String> tinyURL, HashMap<String, String> longURL) {
        if(longURL.containsKey(givenURL)) return longURL.get(givenURL);
        String baseURL = "http://sujaycode.com/";
        String myCharacterSet = "priyanka";
        String key = null;
        do{
            StringBuilder url = new StringBuilder();
            for(int i=0;i<10;i++){
                int random = (int) (Math.random() *myCharacterSet.length());
                url.append(myCharacterSet.charAt(random));
            }
            key = url.toString();
        }while (tinyURL.containsKey(key));

        tinyURL.put(key,givenURL);
        longURL.put(givenURL,key);
        return baseURL+key;
    }
    private static String decode(String shortURL, HashMap<String, String> tinyURL){
        shortURL = shortURL.replace("http://sujaycode.com/","");
        return tinyURL.get(shortURL);
    }
}
