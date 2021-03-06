package com.topweshare;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author mongoding
 * @create 2017/7/25.
 * @blog https://mongoding.github.io
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCollapser(
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            batchMethod = "findByIds",
            collapserProperties = {
                @HystrixProperty(name="timerDelayInMilliseconds", value = "100")
            }
    )
    public Future<String> findById(Long id) {
        log.info("findById : " + id);
        return null;
    }

    @HystrixCommand(commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"))
    public List<String> findByIds(List<Long> ids) {
        log.info("findByIds : " + ids);
        /*List<String> result = restTemplate.getForObject("http://hystrix-collapser-provider/users?ids={1}",
                List.class, StringUtils.join(ids, ","));*/
        List<String> serializables = Lists.asList("dingzhenhao", new String[]{"ding", "zhen"});
        log.info(serializables.toString());
        return serializables;
    }

}
