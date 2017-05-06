package com.example.gregoryesrig24.finalproject;

/**
 * Created by michaelpenny on 4/11/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Item {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("Shirt");
        cricket.add("Shorts");
        cricket.add("Pants");
        cricket.add("Coats");
        cricket.add("Socks");
        cricket.add("Shoes");

        List<String> football = new ArrayList<String>();
        football.add("Ham ");
        football.add("Turkey");
        football.add("Cheese");
        football.add("Beans");
        football.add("Rice");

        List<String> basketball = new ArrayList<String>();
        basketball.add("Electronics");
        basketball.add("Video Games");
        basketball.add("Legos");
        basketball.add("Blocks");
        basketball.add("Books");

        expandableListDetail.put("  Clothing", cricket);
        expandableListDetail.put("  Food", football);
        expandableListDetail.put("  Children's Toys", basketball);
        return expandableListDetail;
    }
}
