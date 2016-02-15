package com.imageview;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by karthik on 2/11/16.
 */
@Path("/home")
public class App {

    static Map<String,Integer> map = new HashMap<String,Integer>();
    /**
     *
     * @param input English text in the URL
     * @return  Json format of no of occurences and same value count
     */
    @GET
    @Produces("application/json")
    @Path("/inputString/{input}")
    public String getTextData(@PathParam("input") String input) {

        Model model = new Model();
        URL path = this.getClass().getResource("/txtfiles");
        File file = new File(path.getPath());
        int length = file.listFiles().length;
        File[] files = file.listFiles();
        int count = 0;
        Integer countInput = map.get(input);

        if (countInput==null){
            map.put(input,1);
        }else {
            map.put(input,++countInput);
        }

        try {
        for(int k=0;k<length;k++){
            if (files[k].isFile()){
                String fileIO = IOUtils.toString(new FileReader(files[k]));
                count+= StringUtils.countMatches(fileIO,input);
            }
        }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        model.setWordOccurenceInFiles(count);
        model.setSameValueCount(map.get(input));
        Gson gson = new Gson();
        String response = gson.toJson(model);
        return response;
    }
}
