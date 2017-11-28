package com.company;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class PhoneNumberFinder {

    ArrayList<String> foundNumbers;

    private  ArrayList<String> findNumber(String page)
    {

        foundNumbers= new ArrayList<>();
        Pattern p = Pattern.compile("(?!Fax$)\\(?\\d{3}\\)?[-\\s\\.]?\\d{3}[-\\s\\.]?\\d{4}\n");
        Matcher m = p.matcher(page);

        while (m.find()) {
            System.out.println(m.group());
            foundNumbers.add(m.group());
        }
        if(foundNumbers.isEmpty())
        {
             foundNumbers.add("No numbers found!");
             return foundNumbers;
        }
        return  foundNumbers;
    }

    private String beautifulNumberArray(ArrayList<String> phoneNumbers)
    {
        String numbers="";
        for (String number:phoneNumbers) {
            numbers+=number+"\n";
        }
        return  numbers;
    }

    String searchPageForNumber(String address)
    {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {

            HtmlPage page = client.getPage(address);
            System.out.println(page.asText());
            String str = page.asText().replace(")", "");
            str = str.replace("(", "");
            str = str.replace("-", "");
            str = str.replace(" ", "");
            str = str.replace(".", "");

            System.out.println(str);
            return  beautifulNumberArray(findNumber(str));






        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    }


