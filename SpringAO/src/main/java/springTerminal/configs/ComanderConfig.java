package springTerminal.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springTerminal.lib.Comander;

@Component
public class ComanderConfig {
    @Bean
    @Scope("prototype")
    public Comander comander(){
        return new Comander();
    }
}
