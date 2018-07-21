package com.simplycoolest.utils.tags;

/**
 * Created by Marcin on 28.04.2018.
 */
import com.simplycoolest.entities.SocialMediaData;
import lombok.Setter;

import java.io.IOException;
import java.util.stream.IntStream;

public class NavbarTag extends MainTag {

    private static final String NAV = "<nav class=\"navbar navbar-default navbar-fixed-top\"> \n";
    private static final String CONTAINER = "<div class=\"container\"> \n";
    private static final String LOGO = "<div class=\"navbar-header page-scroll\">\n" +
            "            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n" +
            "                <span class=\"sr-only\">Toggle navigation</span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "                <span class=\"icon-bar\"></span>\n" +
            "            </button>\n" +
            "            <a class=\"navbar-brand page-scroll\" href=\"#page-top\"><img src=\"images/logo.png\" alt=\"Lattes theme logo\"></a>\n" +
            "        </div>";
    private static final String LI_START = "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n" +
            "            <ul class=\"nav navbar-nav navbar-right\">\n" +
            "                <li class=\"hidden\">\n" +
            "                    <a href=\"#page-top\"></a>\n" +
            "                </li>";
    private static final String LI = "<li>\n" +
            "                    <a class=\"page-scroll\" href=\"%s\">%s</a>\n" +
            "                </li>";
    private static final String USER = "<div class=\"userComponent\">\n" +
            "                    <span class=\"userSpanText\"> You are currently logged as: </span>\n" +
            "                   <span class=\"userSpanName\"> %s</span>\n" +
            "                </div>";
    private static final String SOCIAL_MEDIA = "<div class=\"userComponent\">\n" +
            "                    <span class=\"userSpanText\"> <img class=\"socialMediaPhoto\" src=\"%s\" " +
            "                           alt=\"You are currently logged as: \"></span>\n" +
            "                   <span class=\"userSpanName\"> %s</span>\n" +
            "                </div>";
    private static final String LI_END = "</ul>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</nav>";

    @Setter private String names;
    @Setter private String hrefs;

    @Override
    protected void createTag() throws IOException {
        out.print(NAV);
        out.print(CONTAINER);
        out.print(LOGO);
        out.print(LI_START);
        printLi();
        out.print(LI_END);
        printUserComponent();
    }

    private void printUserComponent(){
        if(currentInfo != null && currentInfo.getCurrentUser() != null){
            try {
                out.print(formatUserLi());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String formatUserLi(){
        if(currentInfo.getCurrentUser() instanceof SocialMediaData){
            String[] datas = {((SocialMediaData) currentInfo.getCurrentUser()).getImageUrl(), currentInfo.getCurrentUser().getUsername()};
            return String.format(SOCIAL_MEDIA, datas);
        }
        String datas = currentInfo.getCurrentUser().getUsername();
        return String.format(USER, datas);
    }

    private void printLi(){
        String[] namesTable = names.split(",");
        String[] hrefsTable = hrefs.split(",");
        IntStream.range(0, namesTable.length).forEach(i -> printOneLi(hrefsTable[i], namesTable[i]));
    }

    private void printOneLi(String href, String name){
        try {
            out.print(formatOneLi(href, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatOneLi(String href, String name){
        String[] datas = { href, name };
        return String.format(LI, datas);
    }
}