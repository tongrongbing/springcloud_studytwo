package com.home.springcloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author：tongrongbing
 * @date：created in 2020/6/9 14:10
 * @description：
 */
public class MyIRule extends AbstractLoadBalancerRule {

    private AtomicInteger serverIndexIncrement; // 记录服务index

    private AtomicInteger countFlag;  // 计数器

    private Vector<Server> vector = new Vector<>();
    private static Logger log = LoggerFactory.getLogger(MyIRule.class);
    public MyIRule(){
        serverIndexIncrement = new AtomicInteger(0);
        countFlag = new AtomicInteger(0);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        int nexIndexServer = 0;
        //修改成每五次换一个机器
        while (server == null) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }
            if (Thread.interrupted()) {
                return null;
            }

            if (serverCount == 0) {
                return null;
            }

            //获取服务索引值
            if(countFlag.getAndIncrement() % 5 == 0){
                vector.clear();
                nexIndexServer = incrementAndGetModulo(serverCount);
                server = allServers.get(nexIndexServer);
                vector.add(server);
            }else{
                server = vector.get(0);
            }
            if (server.isAlive()) {
                return (server);
            }
            if (server == null) {
                Thread.yield();
                continue;
            }
            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    private int incrementAndGetModulo(int serverCount){
        for(;;){
            int current = serverIndexIncrement.get();
            int next = (current+1) % serverCount;
            //当前线程获取到的值current，和当前内存中value的值进行比较.如果相同，则将value值设置为next
            if(serverIndexIncrement.compareAndSet(current,next))
                return next;
        }
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

}