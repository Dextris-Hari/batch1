package com.reacive.reactive.fluxandmanoplyaground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndManoTest {
    @Test
    public  void fluxTest(){

       Flux<String> stringFlux= Flux.just("spring","spring Boot","reactive spring boot")
//               .concatWith(Flux.error(new RuntimeException("exception is accured")))
               .log();
          stringFlux.subscribe(System.out::println,
                  (e)-> System.out.println(e),()-> System.out.println("complited"));
    }
    @Test
    public  void fluxTestElements_WithoutError(){
           Flux s= Flux.just("String","Spring Boot","Reactive Spring Boot").log();
        StepVerifier.create(s).expectNext("String").expectNext("Spring Boot")
                .expectNext("Reactive Spring Boot").verifyComplete();

    }
    @Test
    public  void fluxTestElements_WithError(){
        Flux s= Flux.just("String","Spring Boot","Reactive Spring Boot")
                .concatWith(Flux.error(new RuntimeException("exception is accured")))
                .log();
        StepVerifier.create(s).expectNext("String").expectNext("Spring Boot")
                .expectNext("Reactive Spring Boot").
               // expectError(RuntimeException.class).
        expectErrorMessage("exception is accured").
                verify();

    }
    @Test
    public  void fluxTestElements_WithError1(){
        Flux s= Flux.just("String","Spring Boot","Reactive Spring Boot")
                .concatWith(Flux.error(new RuntimeException("exception is accured")))
                .log();
        StepVerifier.create(s).expectNext("String","Spring Boot","Reactive Spring Boot").
                // expectError(RuntimeException.class).
                        expectErrorMessage("exception is accured").
                verify();

    }
    @Test
    public  void fluxTestElementsCount_WithError(){
        Flux s= Flux.just("String","Spring Boot","Reactive Spring Boot")
                .concatWith(Flux.error(new RuntimeException("exception is accured")))
                .log();
        StepVerifier.create(s).expectNextCount(3).

                // expectError(RuntimeException.class).
                        expectErrorMessage("exception is accured").
                verify();

    }
    // for mano junit

    @Test
    public  void monoTest(){

        Mono stringMono= Mono.just("spring");
        StepVerifier.create(stringMono.log()).expectNext("spring").verifyComplete();
    }
    @Test
    public  void monoTest_WithError(){

        Mono stringMono= Mono.just("spring");
        StepVerifier.create(Mono.error(new RuntimeException("error accured")).log())
                .expectError(RuntimeException.class).verify();
    }

}
