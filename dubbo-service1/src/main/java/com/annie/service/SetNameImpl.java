package com.annie.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.annie.inteface.SetName;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Service(version = "1.0.0", timeout = 10000, interfaceClass = SetName.class)
@Component
public class SetNameImpl implements SetName {
    @Override
    public String setName(String name) {
        String uuid = String.valueOf(UUID.randomUUID());
        return "你的名字是：" + uuid.substring(0, 4) + name;
    }
}
