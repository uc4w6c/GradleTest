package ocitest;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerTest {
    public static void main(String... args) {
        System.out.println("Start.");

        // 接続時の設定値を Properties インスタンスとして構築する
        final Properties properties = new Properties();

        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,
                "cell-1.streaming.ap-tokyo-1.oci.oraclecloud.com:9092");
        properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        properties.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        properties.put(SaslConfigs.SASL_JAAS_CONFIG,
            "");
        properties.put(CommonClientConfigs.RETRIES_CONFIG, 5);
        properties.put("max.request.size", 1024 * 1024);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // Producer を構築する
        final KafkaProducer<String, String> producer = new KafkaProducer<>(properties, new StringSerializer(),
                new StringSerializer());

        try {
            // トピックを指定してメッセージを送信する
            for (int i = 0; i < 2; i++) {
                producer.send(new ProducerRecord<String, String>("teststream10", String.format("message%02d", i)));
            }
        } catch (final Exception e) {
            System.out.println("例外が発生しました。");
            System.out.println(e);
        } finally {
            producer.close();
        }

        System.out.println("End.");
    }
}
