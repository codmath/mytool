package com.complexapi.aitools.Configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbConfig {
    @Bean
    public CommandLineRunner run(JdbcTemplate jdbcTemplate){
        return args ->{
            // jdbcTemplate.execute("ALTER TABLE Transaction DROP COLUMN transaction_occured");
            //  jdbcTemplate.execute("ALTER TABLE Transaction ADD COLUMN transaction_type VARCHAR(255)");
            //  jdbcTemplate.execute("ALTER TABLE PersonData ADD COLUMN  accountBalance DOUBLE");
            // jdbcTemplate.execute("ALTER TABLE person_data DROP COLUMN account_id");
            //  jdbcTemplate.execute("ALTER TABLE history_transaction DROP COLUMN countAmountDeposit");
            // jdbcTemplate.execute("ALTER TABLE beneficiary_people CHANGE COLUMN receiving_person_id beneficiary_id BIGINT NOT NULL");

        };
    }

}
