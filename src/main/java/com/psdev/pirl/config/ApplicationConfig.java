package com.psdev.pirl.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;

@Configuration
@ComponentScan(basePackages = {"com.psdev.pirl"})
@EnableAutoConfiguration
@Slf4j
public class ApplicationConfig {

    @Value("${web3.rpc.pirl}")
    String web3RpcUrl;
    @Value("${default.gas.limit}")
    String gasLimit;
    @Value("${default.gas.price}")
    String gasPrice;

    @Bean
    public Web3j web3j() throws IOException {
        Web3j web3j = Web3j.build(new HttpService(web3RpcUrl));
        log.info("Connected to web3 rpc client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        return web3j;
    }

    @Bean
    BigInteger gasPrice() {
        return new BigInteger(gasPrice);
    }

    @Bean
    BigInteger gasLimit() {
        return new BigInteger(gasLimit);
    }

}
