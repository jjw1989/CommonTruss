package com.powervision.powersdk;

/**
 * 连接配置文件
 * Created by Sundy on 2017/8/31.
 */

public class PVConnConfig {
    //ip地址
    private String ip;
    //端口
    private int port;

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    /**
     * 默认为飞机地址
     */
    public static class Builder {
        private String ip = "192.168.1.12";
        private int port = 20002;

        public Builder() {

        }

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        private void applyConfig(PVConnConfig config) {
            config.ip = this.ip;
            config.port = this.port;
        }

        public PVConnConfig builder() {
            PVConnConfig config = new PVConnConfig();
            applyConfig(config);
            return config;
        }
    }
}
