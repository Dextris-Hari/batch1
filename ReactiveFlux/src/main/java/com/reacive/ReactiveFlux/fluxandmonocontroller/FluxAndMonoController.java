package com.reacive.ReactiveFlux.fluxandmonocontroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;

@RestController
public class FluxAndMonoController {


    @GetMapping("/flux")
    public Flux<Integer> getFlux(){

        return Flux.just(1,2,3,4)
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
    @GetMapping(value = "/fluxstream",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> returnFluxStream(){

        return Flux.just(1,2,3,4)
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
