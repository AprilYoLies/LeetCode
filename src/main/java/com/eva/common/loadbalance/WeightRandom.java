package com.eva.common.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author EvaJohnson
 * @Date 2019-09-09
 * @Email g863821569@gmail.com
 */
public class WeightRandom implements LoadBalance {
    public static void main(String[] args) {
        List<Server> servers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Server server = new Server();
            server.setAddress("ip: " + i);
            server.setWeight(i);
            servers.add(server);
        }
        LoadBalance lb = new WeightRandom();
        System.out.println(lb.select(servers));
    }

    @Override
    public Server select(List<Server> servers) {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        // 计算总比重
        int totalWeight = 0;
        for (Server server : servers) {
            totalWeight += server.getWeight();
        }
        // 按照权重选择
        int randomWeight = localRandom.nextInt(totalWeight);
        for (Server server : servers) {
            randomWeight -= server.getWeight();
            if (randomWeight < 0) {
                return server;
            }
        }
        // default
        int length = servers.size();
        return servers.get(localRandom.nextInt(length));
    }
}
