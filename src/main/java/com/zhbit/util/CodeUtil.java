package com.zhbit.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CodeUtil {
    public static String toUtf8(String src){
        byte[] bytes= src.getBytes(StandardCharsets.ISO_8859_1);
        return new String(bytes,StandardCharsets.UTF_8);
    }
}
