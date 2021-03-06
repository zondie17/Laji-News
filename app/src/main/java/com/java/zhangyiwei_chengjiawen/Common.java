package com.java.zhangyiwei_chengjiawen;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

class Common {
    static ArrayList<String> history = new ArrayList<>();
    static int currentItem = 0;
    final static String[] category = {"收藏", "娱乐", "军事", "教育", "文化", "健康", "财经", "体育", "汽车", "科技", "社会"};
    static ArrayList<Integer> added = new ArrayList<>(Arrays.asList(0, 2, 3, 4));
    static ArrayList<Integer> deleted = new ArrayList<>(Arrays.asList(1, 5, 8, 6, 7, 9, 10));

    static String encodingToUrl(String size, String startDate, String endDate, String words, String categories) {
        String[] args = new String[]{size, startDate, endDate, words, categories};
        String[] encoded = new String[5];
        for (int i = 0; i < args.length; ++i) {
            try {
                encoded[i] = URLEncoder.encode(args[i], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                encoded[i] = null;
            }
        }
        return String.format(
                "https://api2.newsminer.net/svc/news/queryNewsList?size=%s&startDate=%s&endDate=%s&words=%s&categories=%s",
                encoded[0], encoded[1], encoded[2], encoded[3], encoded[4]);
    }
}
