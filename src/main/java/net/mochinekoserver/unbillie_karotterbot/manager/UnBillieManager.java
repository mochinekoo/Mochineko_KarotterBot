package net.mochinekoserver.unbillie_karotterbot.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnBillieManager {

    public static final String baseText = "奇跡体験！アンビリバボー！";
    public static List<String> front_list = Arrays.asList("奇", "跡", "体", "験");
    public static List<String> back_list = Arrays.asList("ア", "ン", "ビ", "リ", "バ", "ボ");

    public static String getRandomText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ArrayList<String> copy_front = new ArrayList<>(front_list);
            Collections.shuffle(copy_front);
            stringBuilder.append(copy_front.getFirst());
        }
        stringBuilder.append("！");
        for (int i = 0; i < 6; i++) {
            ArrayList<String> copy_back = new ArrayList<>(back_list);
            Collections.shuffle(copy_back);
            stringBuilder.append(copy_back.getFirst());
        }
        stringBuilder.append("ー").append("！");

        return stringBuilder.toString();
    }
}
