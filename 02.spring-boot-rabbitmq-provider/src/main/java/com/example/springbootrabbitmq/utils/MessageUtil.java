package com.example.springbootrabbitmq.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MessageUtil {
    public static Map getMsg(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", String.valueOf(UUID.randomUUID()));
        map.put("messageData", msg);
        map.put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return map;
    }
}
