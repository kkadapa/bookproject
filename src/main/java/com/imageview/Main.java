package com.imageview;

/**
 * Created by karthik on 2/15/16.
 */
public class Main {

    public static void main(String[] args) {

        Model model = new Model();

        model.setSameValueCount(1);
        model.setWordOccurenceInFiles(4609);

        App app = new App();
        String string = app.getTextData("Project");

        System.out.println(string);
    }

}
