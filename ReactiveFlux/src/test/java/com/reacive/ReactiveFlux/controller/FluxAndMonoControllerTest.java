package com.reacive.ReactiveFlux.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebFluxTest
public class FluxAndMonoControllerTest {


@Autowired
WebTestClient webFluxTest;
@Test
public  void flux_approach1(){


 Flux<Integer> integerFlux= webFluxTest
            .get()
            .uri("/flux").accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange().expectStatus().isOk()
            .returnResult(Integer.class)
            .getResponseBody();
    StepVerifier.create(integerFlux.log()).expectSubscription()
            .expectNext(1).expectNext(2)
            .expectNext(3)
            .expectNext(4)
            .verifyComplete();

}
@Test
    public  void flux_Approach2(){
     webFluxTest
            .get()
            .uri("/flux").accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange().expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
            .expectBodyList(Integer.class).hasSize(4);

}
@Test

public void flux_Approach3(){
    List<Integer> expected = Arrays.asList(1,2,3,4);

  EntityExchangeResult<List<Integer> > listEntityExchangeResult= webFluxTest
            .get()
            .uri("/flux").accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange().expectStatus().isOk()
            .expectBodyList(Integer.class)
            .returnResult();





  assertEquals(expected,listEntityExchangeResult.getResponseBody());
}

    @Test

    public void flux_Approach4(){
        List<Integer> expected = Arrays.asList(1,2,3,4);


        EntityExchangeResult<List<Integer> > listEntityExchangeResult= webFluxTest
                .get()
                .uri("/flux").accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange().expectStatus().isOk()
                .expectBodyList(Integer.class)
                .consumeWith((response)->
                {
                    assertEquals(expected,response.getResponseBody());
                });




    }

}