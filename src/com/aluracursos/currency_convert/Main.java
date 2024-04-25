package com.aluracursos.currency_convert;

import com.aluracursos.currency_convert.api.API;
import com.aluracursos.currency_convert.api.ExchangeRate;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner keyboard = new Scanner(System.in);
        API request = new API();


        String menu = """
                *****************************************************
                Welcome to currency converter.
                
                Example of use:
                [Base currency] [currencies] [Amount];
                USD             EUR          250.00
                
                
                Note: Write "Help" to see all available codes"
                Write "Exit" to end the program :)
                *****************************************************
                """;

        String helpMenu = """
                ------------------------------------------------------
                            All Supported Currencies
                Currency Code | Currency Name | Country
                AED             UAE Dirham      United Arab Emirates
                MXN             Mexican Peso    Mexico
                NGN             Nigerian Naira  Nigeria
                CLP             Chilean Peso    Chile
                EUR             Euro            European Union
                UYU             Uruguayan Peso  Uruguay
                VES             Venezuelan Bol  Venezuela
                YER             Yemeni Rial     Yemen
                .....
                ------------------------------------------------------
                """;



        while (true){

            System.out.println(menu);
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("Exit")){
                System.out.println("Thank you for using our application");
                break;
            }

            if(input.equalsIgnoreCase("Help")){
                System.out.println(helpMenu);
                continue;
            }


            //converts user input in case it was entered in lower case
            String upperCaseInput = input.toUpperCase();

            // Split the input to obtain base currency, currencies and amount
            String[] words = upperCaseInput.split(" ");

            try{
                ExchangeRate exchangeRate = request.getExchangeRate(words[0]);
                String result = exchangeRate.converter(words[1], Double.parseDouble(words[2]));
                System.out.println(result);
            }catch (NullPointerException e){
                //In case the user enters an unavailable base currency
                System.out.println("currency not available, please check base currency");
            }

        }

    }

}
