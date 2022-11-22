package com.crud.tasks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ContributorConfig implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder){
    Map<String, String> applicationInfo = new HashMap<>();
    applicationInfo.put("name","John");
    applicationInfo.put("surname","Doe");
   // builder.withDetail("owner", applicationInfo);
    }
}
