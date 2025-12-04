package com.bitabit.banco.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoverRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/main/java/com/bitabit/banco/camel/filesFrom?noop=false&delete=true")
        .log("Moving file ${file:name} to filesTo")
        .log("File size is ${file:size}")
        .log("Headers are ${headers}")
        .log("Body is ${body}")
        .to("file:src/main/java/com/bitabit/banco/camel/filesTo");
    }
    
}
