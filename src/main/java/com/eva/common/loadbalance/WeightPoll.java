package com.eva.common.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author EvaJohnson
 * @Date 2019-09-09
 * @Email g863821569@gmail.com
 */
public class WeightPoll implements LoadBalance {
    private static final ConcurrentMap<Server, AtomicInteger> ServerMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Server server = new Server();
            server.setAddress("ip: " + i);
            server.setWeight(i);
            servers.add(server);
        }
        LoadBalance lb = new WeightPoll();
        System.out.println(lb.select(servers));
    }

    @Override
    public Server select(List<Server> servers) {
        Server best = null;
        int totalWeight = 0;

        for (Server server : servers) {
            AtomicInteger weightServer = ServerMap.get(server);
            if (null == weightServer) {
                weightServer = new AtomicInteger(0);
                ServerMap.putIfAbsent(server, weightServer);
            }
            int weight = server.getWeight();
            // 加权
            weightServer.addAndGet(weight);

            totalWeight += weight;
            // 根据权选择
            if (null == best || weightServer.get() > ServerMap.get(best).get()) {
                best = server;
            }
        }

        if (null == best) {
            throw new IllegalStateException("can't select client");
        }

        // 降权
        AtomicInteger bestWeightServer = ServerMap.get(best);
        bestWeightServer.set(totalWeight - bestWeightServer.get());

        return best;
    }
}
