package com.tencent.bk.core;

public class BkEnum {

    public enum Lang {
        chinese("zh-cn"), english("en"), all("all");

        public final String name;

        Lang(String name) {
            this.name = name;
        }
    }
}
