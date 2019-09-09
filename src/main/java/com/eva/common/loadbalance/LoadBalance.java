package com.eva.common.loadbalance;

import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-09-09
 * @Email g863821569@gmail.com
 */
public interface LoadBalance {
    /**
     * 根据负载均衡算法选择最合适的一个Server
     *
     * @param servers 客户端集合
     * @return result
     */
    Server select(List<Server> servers);
}
