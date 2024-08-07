package com.example.tenement.core.common.constant;

/**
 * AMQP 相关常量
 */
public class AmqpConsts {

    /**
     *信息改变 MQ
     */
    public static class HorseMq {

        /**
         * 信息改变交换机
         */
        public static final String EXCHANGE_NAME = "EXCHANGE-HORSE-CHANGE";

        /**
         * Elasticsearch索引更新的队列
         */
        public static final String QUEUE_ES_UPDATE = "QUEUE-ES-HORSE-UPDATE";

        /**
         * Redis 缓存更新的队列
         */
        public static final String QUEUE_REDIS_UPDATE = "QUEUE-REDIS-HORSE-UPDATE";

    }

}
