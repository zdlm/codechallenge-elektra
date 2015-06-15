package com.tradeshift;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Created by zhangleo on 09/06/15.
 */
public class MyApplication extends ResourceConfig {
    /**
     * Register JAX-RS application components.
     */
    public MyApplication() {
        register(RequestContextFilter.class);
        register(MessageResource.class);
    }

}
