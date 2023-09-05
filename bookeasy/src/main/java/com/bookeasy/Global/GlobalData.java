package com.bookeasy.Global;

import com.bookeasy.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    private static List<Item> card = new ArrayList<>();
    public static List<Item> getCart() {
        return card;
    }

    public static void setCard(List<Item> card) {
        GlobalData.card = card;
    }
}
