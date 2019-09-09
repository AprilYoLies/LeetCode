package com.eva.common.loadbalance;

/**
 * @Author EvaJohnson
 * @Date 2019-09-09
 * @Email g863821569@gmail.com
 */
public class Server {
    /**
     * 服务器地址
     */
    private String address;
    /**
     * 服务器权重
     */
    private Integer weight;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Server{" +
                "address='" + address + '\'' +
                ", weight=" + weight +
                '}';
    }
}
