package com.dextris.Resttemplteconsume.client;

import com.dextris.Resttemplteconsume.entity.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {
private static  final String POST_USER_API="http://localhost:1234/m";
private static final String GET_ALL_USER_API="http://localhost:1234/";
private static final String GET_USER_BY_ID_API="http://localhost:1234/{id}";
private static final String UPDATE_USER_BY_ID_API="http://localhost:1234/{id}";
private static  final  String DELETE_USER_BY_ID_API="http://localhost:1234/{id}";
   private static RestTemplate restTemplate= new RestTemplate();
    public static void main(String[] args) {
        getAllUser();
        getUserById();
        createUser();
        updateUserById();
        deleteUserById();
    }
    private static  void getAllUser(){
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity httpEntity= new HttpEntity("parameter" , httpHeaders);

       ResponseEntity result =restTemplate.exchange(GET_ALL_USER_API, HttpMethod.GET,httpEntity,String.class);
        System.out.println(result);

    }
    private  static  void  getUserById(){

        Map<String,Integer> param = new HashMap<>();
        param.put("id",2);
      User user=  restTemplate.getForObject(GET_USER_BY_ID_API, User.class,param);
        System.out.println(user);


    }

private static  void createUser(){
        User user= new User("manoj","manoj@123");
      ResponseEntity responseEntity=  restTemplate.postForEntity(POST_USER_API,user, User.class);
    System.out.println(responseEntity.getBody());
}
private  static  void updateUserById(){

        Map<String,Integer> param= new HashMap<>();
        param.put("id",52);
        User user = new User("m","m@123");
       restTemplate.put(UPDATE_USER_BY_ID_API,user, param);
}

private  static  void deleteUserById(){

        Map param = new HashMap();
        param.put("id",2);
        restTemplate.delete(DELETE_USER_BY_ID_API,param);

}
}
