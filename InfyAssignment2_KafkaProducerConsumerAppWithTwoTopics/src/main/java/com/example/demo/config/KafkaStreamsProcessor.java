package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsProcessor {

	  @Bean(name = "defaultKafkaStreamsBuilder")
	    public StreamsBuilderFactoryBean defaultKafkaStreamsBuilder() {
		  Map<String, Object> config = new HashMap<>();
	        config.put(org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG, "streams-app");
	        config.put(org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
	        config.put(org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
	        return new StreamsBuilderFactoryBean(new KafkaStreamsConfiguration(config));
	    }

	    @Bean
	    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
	        KStream<String, String> stream = streamsBuilder.stream("pal_case_source");
	        stream.to("pal_case_destination");
	        return stream;
	    }
}
