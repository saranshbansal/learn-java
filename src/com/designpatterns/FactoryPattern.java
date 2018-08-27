package com.designpatterns;

/**
 * Factory pattern (C) demo
 */
interface Country
{
    String getCountryName();


    String getSymbol();
}


class India implements Country
{

    @Override
    public String getCountryName()
    {
        return "India";
    }


    @Override
    public String getSymbol()
    {
        return "INR";
    }

}


class Australia implements Country
{

    @Override
    public String getCountryName()
    {
        return "Australia";
    }


    @Override
    public String getSymbol()
    {
        return "$";
    }

}


public class FactoryPattern
{
    public static Country getCurrencyByCountry(String country) throws Exception
    {
        if ("India".equalsIgnoreCase(country))
        {
            return new India();
        }
        else if ("Australia".equalsIgnoreCase(country))
        {
            return new Australia();
        }
        throw new Exception("Invalid Country");
    }


    public static void main(String[] args)
    {
        try
        {
            Country country = FactoryPattern.getCurrencyByCountry("India");
            System.out.println("Country: " + country.getCountryName());
            System.out.println("Currency: " + country.getSymbol());
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
