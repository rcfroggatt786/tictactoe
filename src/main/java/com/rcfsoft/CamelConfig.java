package com.rcfsoft;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {

            @Override
            public void beforeApplicationStart(CamelContext context) {
                try {
                    context.addRoutes(new RouteBuilder() {
                        @Override
                        public void configure() throws Exception {
                            restConfiguration()
                                    .component("servlet")
                                    .contextPath("/")
                                    .host("localhost")
                                    .port(9876);
                            rest("/")
                                    .get()
                                    .to("direct:root");
                            from("direct:root")
                                    .setHeader("Content-Type", constant("text/plain"))
                                    .setBody(constant("Tic Tac Toe"));
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
            }
        };
    }
}