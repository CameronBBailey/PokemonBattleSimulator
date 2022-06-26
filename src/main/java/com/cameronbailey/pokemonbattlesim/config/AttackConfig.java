//package com.cameronbailey.pokemonbattlesim.config;
//
//import com.cameronbailey.pokemonbattlesim.models.Attack;
//import com.cameronbailey.pokemonbattlesim.repository.AttackRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class AttackConfig {
//    @Bean
//    CommandLineRunner commandLineRunner5(AttackRepository repository) {
//        return args -> {
//            Attack megaPunch = new Attack(
//                    1L,
//                    "Mega Punch",
//                    "Punches really hard",
//                    "Normal",
//                    "Physical",
//                    100L,
//                    "100%",
//                    10L
//            );
//            Attack megaKick = new Attack(
//                    2L,
//                    "Mega Kick",
//                    "Kicks really hard",
//                    "Normal",
//                    "Physical",
//                    100L,
//                    "100%",
//                    10L
//            );
//            Attack megaPuncher = new Attack(
//                    3L,
//                    "Mega Puncher",
//                    "Punches really hard",
//                    "Normal",
//                    "Physical",
//                    100L,
//                    "100%",
//                    10L
//            );
//            Attack megaKicker = new Attack(
//                    4L,
//                    "Mega Kicker",
//                    "Kicks really hard",
//                    "Normal",
//                    "Physical",
//                    100L,
//                    "100%",
//                    10L
//            );
//            repository.saveAll(
//                    List.of(megaPunch, megaKick, megaPuncher, megaKicker)
//            );
//        };
//    }
//}
