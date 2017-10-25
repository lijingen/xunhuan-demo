package com.yy.xunhuan.activity.demo.swift;

import com.facebook.swift.codec.ThriftEnumValue;

public enum PWerwolfEGameMode
{
    WERWOLF_PLAYER9(0), WERWOLF_PLAYER12(1), WERWOLF_PLAYER6_HAPPY(2), WERWOLF_PLAYER9_HAPPY(3), WERWOLF_PLAYER9_BOMBER(4), WERWOLF_PLAYER12_NO_INTERPOSE(5), WERWOLF_PLAYER9_AVENGER(6), WERWOLF_PLAYER10_HAPPY(7), WERWOLF_PLAYER6_PROPHET2(8), WERWOLF_PLAYER6_HUNTER4(9), WERWOLF_GAME_MODE_MAX(10);

    private final int value;

    PWerwolfEGameMode(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }

    private static PWerwolfEGameMode[] values = PWerwolfEGameMode.values();
    public static PWerwolfEGameMode valueOf(int value)
    {
        for(PWerwolfEGameMode val :values){
            if (val.getValue()==value){
                return val;
            }
        }
        return null;
    }
}
