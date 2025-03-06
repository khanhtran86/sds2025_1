package com.samsung.finalproject.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppSettings {
    @Value("${app.dataSource}")
    public String dataSource;
}
