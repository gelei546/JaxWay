package com.gateway.jaxway.server;

import com.gateway.jaxway.core.authority.JaxwayServerAuthenticationDataStore;
import com.gateway.jaxway.core.authority.server.LocalJaxwayAuthenticationServerDataStore;
import com.gateway.jaxway.core.utils.http.OpType;
import com.gateway.jaxway.core.vo.JaxServerAuthentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author huaili
 * @Date 2019/5/6 18:39
 * @Description JaxServerApplication
 **/
@SpringBootApplication
public class JaxServerApplication {



    public static void main(String[] ags) {
        SpringApplication.run(JaxServerApplication.class);
    }

    @PostConstruct
    void initTestAuthenInfo(){
        Set<String> uriRegSet = new HashSet<>();
        uriRegSet.add("/sohu/**");
        uriRegSet.add("/sohu");

        JaxServerAuthentication jaxServerAuthentication = new JaxServerAuthentication();
        jaxServerAuthentication.setAppId("test");
        jaxServerAuthentication.setOpType(OpType.ADD);
        jaxServerAuthentication.setUriRegxSet(uriRegSet);

        JaxwayServerAuthenticationDataStore jaxwayServerAuthenticationDataStore = LocalJaxwayAuthenticationServerDataStore.create();
        jaxwayServerAuthenticationDataStore.updateAppAuthentications(jaxServerAuthentication);
    }
}
