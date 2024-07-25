package com.example.final_project.service;


import com.currencyServer.grpc.Currency;
import com.currencyServer.grpc.CurrencyRequest;
import com.currencyServer.grpc.CurrencyResponse;
import com.currencyServer.grpc.CurrencyServerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangerService {

    public List<Currency> getCurrency(LocalDate date) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9092").usePlaintext().build();
        CurrencyServerGrpc.CurrencyServerBlockingStub stub = CurrencyServerGrpc.newBlockingStub(channel);

        CurrencyRequest request = CurrencyRequest
                .newBuilder().setDate(date.toString()).build();
        CurrencyResponse response =  stub.cur(request);
        List<com.currencyServer.grpc.Currency> currencies = response.getCurrencyList();
        channel.shutdown();
        currencies.forEach(System.out::println);
        return currencies;
    }
}
