# kafka-demo

link: https://viblo.asia/p/007-simple-kafka-producer-client-api-voi-java-WAyK86PplxX

1. chạy ZooKeeper :
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

2. Start the Kafka broker service:
bin\windows\kafka-server-start.bat config\server.properties

3.CREATE A TOPIC TO STORE YOUR EVENTS
 bin\windows\kafka-topics.bat --create --topic topic-demo --bootstrap-server localhost:9092 --partitions 5 --replication-factor 3

3.1, Danh sách các topic
bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

4. Kiểm tra số phân vùng của topic
 bin\windows\kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092

4.Kiểm tra consumer
bin\windows\kafka-consumer-groups.bat --describe --bootstrap-server localhost:9093 -group test

5. ghi 1 sự kiện vào topic
bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
> ...

6.Read 1 sự kiện từ topic
bin\windows\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

--from-beginning: để nhận được tất cả tin nhắn từ trước.
