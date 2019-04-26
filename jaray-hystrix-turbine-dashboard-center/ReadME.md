**一、搭建链路追踪jaray-sleuth-zipkin-center步骤**

	注：熔断监控只作用于消费者端

	#一、引入依赖spring-boot-starter-actuator、spring-cloud-starter-netflix-hystrix、
			spring-cloud-starter-netflix-hystrix-dashboard、spring-cloud-starter-netflix-turbine
	
	#二、添加@EnableDiscoveryClient启用注册中心
			添加@EnableHystrix
			添加@EnableHystrixDashboard
			添加@EnableCircuitBreaker
			添加@EnableTurbine
		注：新增时需要向配置文件添加对应服务名
			app-config: service-provider-one,service-customer-one
		
	#三、消费者端引入依赖spring-boot-starter-actuator、spring-cloud-starter-netflix-hystrix、
			spring-cloud-starter-netflix-hystrix-dashboard、spring-cloud-starter-netflix-turbine
		
	#四、消费者端添加@EnableHystrixDashboard注解
			@EnableCircuitBreaker注解
			
	访问URL：http://localhost:7000/hystrix
		注：方式一：监控单个应用http://hystrix-app:port/actuator/hystrix.stream
					hystrix-app：需要监控应用的IP
					port：需要监控应用的端口号
			方式二：监控集群引用http://turbine-hostname:port/turbine.stream
					turbine-hostname：需要监控集群的IP 与http://localhost:7000/hystrix对应   即localhost
					port：需要监控集群的端口号  与http://localhost:7000/hystrix对应   即7000
			方式三：监控自定义集群http://turbine-hostname:port/turbine.stream?cluster=[clusterName]
			

**下接聚合监控jaray-hystrix-turbine-dashboard-center**