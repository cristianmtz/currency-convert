package com.aluracursos.currency_convert.api;

import java.util.Map;

public record ExchangeRate(String base_code, Map<String, Double> conversion_rates) {

    public String converter(String currency, double amount){


        if( conversion_rates.containsKey(currency) ){

            double conversion = amount * conversion_rates.get(currency);
            return "The value of " + amount + "[" + base_code + "]" + " corresponds to " + conversion + "[" + currency +  "]" ;

        }

        return "currency not available, please check currency";
    }
}
