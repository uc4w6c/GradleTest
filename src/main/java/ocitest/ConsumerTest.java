package ocitest;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerTest {
    public static void main(String... args) {
        System.out.println("Start.");

        // 接続時の設定値を Properties インスタンスとして構築する
        final Properties properties = new Properties();

        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,
                // "cell-1.streaming.ap-tokyo-1.oci.oraclecloud.com:9092");
                "cell-1.streaming.ap-tokyo-1.oci.oraclecloud.com:9092");
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        properties.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        properties.put(SaslConfigs.SASL_JAAS_CONFIG,
                "");
        properties.put(CommonClientConfigs.RETRIES_CONFIG, 5);
        properties.put("max.request.size", 1024 * 1024);
        // properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_DOC, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "testgroup1");

        final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties, new StringDeserializer(),
                new StringDeserializer());
        consumer.subscribe(Collections.singletonList("teststream10"));
        try {
            while (true) {
                System.out.println("wile start");
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1_000));

                records.forEach(record -> {
                    System.out.println("topic:" + record.topic() + ", value:" + record.value() + record.toString());
                });
                Thread.sleep(1_000L);
            }
        } catch (final Exception e) {
            e.printStackTrace();
            System.out.println("例外が発生しました。");
            System.out.println(e);
        } finally {
            consumer.close();
        }

        System.out.println("End.");
    }
}
