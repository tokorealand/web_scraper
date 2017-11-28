package com.company;
import com.gargoylesoftware.htmlunit.WebClient;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class PhoneNumberFinder {

    ArrayList<String> foundNumbers = new ArrayList<>();

    private static String findNumber(String page)
    {

        Pattern p = Pattern.compile("(?!Fax$)\\(?\\d{3}\\)?[-\\s\\.]?\\d{3}[-\\s\\.]?\\d{4}\n");
        Matcher m = p.matcher(page);

        if (m.find()) {
            System.out.println(m.group());
            return  m.group();
        }
        return "No phone numbers found!";
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
            return  findNumber(str);






        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }
    }


