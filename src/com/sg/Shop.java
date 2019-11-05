package com.sg;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;



public class Shop {
     private final String name;
        private final Random random;

        public Shop(String name) {
            this.name = name;
            random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
        }

        public double getPrice(String product) {
            return calculatePrice(product);
        }

        private double calculatePrice(String product) {
            delay();
            return random.nextDouble() * product.charAt(0) + product.charAt(1);
        }

        public Future<Double> getPriceAsync(String product) {
            CompletableFuture<Double> futurePrice = new CompletableFuture<>();
            new Thread( () -> {
                        double price = calculatePrice(product);
                        futurePrice.complete(price);
            }).start();
            return futurePrice;
        }

        public String getName() {
            return name;
        }
        
        public   Future<Double> findPricesInUSD(String product) {
                return CompletableFuture
                .supplyAsync(() -> this.getPrice(product))
                .thenCombine(
                    CompletableFuture.supplyAsync(
                        ()-> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.RS)),
                         (price,rate) -> price*rate);
        }

        private void delay() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
