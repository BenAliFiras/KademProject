package tn.agena3000.edi.kademproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
public class KademProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KademProjectApplication.class, args);
    }

}
