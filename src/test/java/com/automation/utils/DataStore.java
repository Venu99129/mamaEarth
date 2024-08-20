package com.automation.utils;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static List<String> faceCategories = new ArrayList<>();
    public static List<String> hairCareProducts = new ArrayList<>();
    public static List<String> makeupProducts = new ArrayList<>();
    public static List<String> bodyCareProducts = new ArrayList<>();
    public static List<String> babyCareProducts = new ArrayList<>();



    static {
        // Add strings to the list
        faceCategories.add("Serum");
        faceCategories.add("Sunscreen");
        faceCategories.add("Wash");
        faceCategories.add("Cream");
        faceCategories.add("Combo");
        faceCategories.add("Mask");
        faceCategories.add("Moisturizer"); // Corrected spelling
        faceCategories.add("Kit");
        faceCategories.add("Lip Balm");
        faceCategories.add("Pack");
        faceCategories.add("Glow");
        faceCategories.add("Scrub");
        faceCategories.add("Toner");

        hairCareProducts.add("Shampoo");
        hairCareProducts.add("Oil");
        hairCareProducts.add("Conditioner");
        hairCareProducts.add("Hair");
        hairCareProducts.add("Combo");
        hairCareProducts.add("Serum");
        hairCareProducts.add("Kit");

        makeupProducts.add("Foundation");
        makeupProducts.add("Kajal");
        makeupProducts.add("Lipstick");
        makeupProducts.add("Eyeliner");
        makeupProducts.add("Mascara");
        makeupProducts.add("Tint");
        makeupProducts.add("Blurring Primer");
        makeupProducts.add("Cream");
        makeupProducts.add("Compact");
        makeupProducts.add("Illuminating");

        bodyCareProducts.add("Perfume"); // Assuming 'perfume' is the correct term
        bodyCareProducts.add("Soap");
        bodyCareProducts.add("Perfum");
        bodyCareProducts.add("Gel");
        bodyCareProducts.add("Scrub");
        bodyCareProducts.add("Wash");
        bodyCareProducts.add("Cream");
        bodyCareProducts.add("Lotion");

        babyCareProducts.add("Shampoo");
        babyCareProducts.add("Oil");
        babyCareProducts.add("Powder");
        babyCareProducts.add("Balm");
        babyCareProducts.add("Toothpaste");
        babyCareProducts.add("Spray");
        babyCareProducts.add("Bar");
        babyCareProducts.add("Kit");
        babyCareProducts.add("Gel");
        babyCareProducts.add("Wash");
        babyCareProducts.add("Cream");
        babyCareProducts.add("Soap");
        babyCareProducts.add("Lotion");
        babyCareProducts.add("Sunscreen");
        babyCareProducts.add("Patches");
        babyCareProducts.add("Roll");

    }

}
