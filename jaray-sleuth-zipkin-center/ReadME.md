**一、搭建链路追踪jaray-sleuth-zipkin-center步骤**
	
	#注：2.0以后官方不再支持使用自建Zipkin Server的方式进行服务链路追踪，而是直接提供了编译好的 jar 包来给我们使用
	地址：https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/

	#一、Windows下安装Erlang
		下载安装包：//www.erlang.org/
		运行 otp_win64_21.3.exe 
	
	#二、Windows下安装RabbitMQ 
		下载安装包：https://www.rabbitmq.com/download.html
		运行 rabbitmq-server-3.7.14.exe
		安装后就能访问了。需要在cmd窗口执行一个命令：
			rabbitmq-plugins enable rabbitmq_management
		访问URL：http://localhost:15672/   用户名密码：guest:guest
		
	#三、Windows下安装Elasticsearch 
		下载安装包：https://www.elastic.co/downloads/elasticsearch
		解压缩文件运行 elasticsearch.bat 
		http://localhost:9200 ，显式以下画面，说明ES安装成功。
		
		注：ElasticsearchException[X-Pack is not supported and Machine Learning is not available for [windows-x86]; 
		解决：在config/elasticsearch.yml添加一条配置：
			xpack.ml.enabled: false
		
	#四、安装zipkin
		从springboot2开始推荐使用zipkin官方网站提供的jar包启动zipkin。
		启动命名如下：
			在zipkin-server-2.11.8-exec目录下执行
			java -DKAFKA_BOOTSTRAP_SERVERS=localhost:9092 -DSTORAGE_TYPE=elasticsearch
			-DES_HOSTS=http://127.0.0.1:9200 -jar zipkin-server-2.11.8-exec.jar

	备注：安装并运行Kafka
		2.1 下载安装文件： http://kafka.apache.org/downloads.html

		2.2 解压文件（本文解压到 D:\kafka_2.11-0.10.2.0）

		2.3 打开D:\kafka_2.11-0.10.2.0\config\ server.properties

		2.4 把 log.dirs的值改成 log.dirs=D:\data\logs\kafka

		2.5 D:\kafka_2.11-0.10.2.0\bin文件夹下的.sh命令脚本是在shell下运行的，此文件夹下还有个 windows文件夹，里面是windows下运行的.bat命令脚本

		2.6 在D:\kafka_2.11-0.10.2.0文件夹中”Shift+鼠标右键”点击空白处打开命令提示窗口

		2.7 输入并执行一下命令以打开kafka:
		.\bin\windows\kafka-server-start.bat .\config\server.properties

			1
	
			显示的信息如下，则表示正常运行
		
**启动服务命令**

	在zipkin-server-2.11.8-exec目录下执行
	使用Kafka
	nohup java -DKAFKA_BOOTSTRAP_SERVERS=localhost:9092 -DSTORAGE_TYPE=elasticsearch
	 -DES_HOSTS=http://127.0.0.1:9200 -jar zipkin-server-2.11.8-exec.jar >/dev/null 2>&1 &
	
	使用Rabbit
	java -DRABBIT_ADDRESSES=localhost:5672 -DSTORAGE_TYPE=elasticsearch
	 -DES_HOSTS=http://127.0.0.1:9200 -jar zipkin-server-2.11.8-exec.jar
	RABBIT_ADDRESSES
	参数说明：
	KAFKA_BOOTSTRAP_SERVERS：kafka的ip和端口
	STORAGE_TYPE 存储数据方式可以为 mem, mysql, cassandra, elasticsearch
	ES_HOSTS  es的url 
	官方文档 githup https://github.com/openzipkin/zipkin/tree/master/zipkin-server
	启动后访问url ：
	访问URL：http://***:9411/zipkin
	访问URL：http://***:9411
	
**客户端整合sleuth**

	需要整合跟踪的项目pom中加入spring-cloud-starter-zipkin、spring-rabbit
	配置文件增加rabbitmq相关配置
	#rabbitmq配置
	spring.rabbitmq.host=127.0.0.1
	spring.rabbitmq.port=5672
	spring.rabbitmq.username=guest
	spring.rabbitmq.password=guest
	spring.rabbitmq.virtual-host=/dev
	
	注：控制器中必须添加Logger日志，否则无法进行追踪管理。

**下接聚合监控jaray-hystrix-turbine-dashboard-center**