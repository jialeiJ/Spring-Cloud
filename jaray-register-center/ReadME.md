**一、搭建注册中心jaray-register-center步骤**

	#一、引入依赖spring-cloud-starter-netflix-eureka-server  

	#二、添加@EnableEurekaServer注解启用注册中心  

	#三、配置文件  
	
**Eureka的基本架构，由3个角色组成**   

	1、Eureka Server
		提供服务注册和发现  
	2、Service Provider  
		服务提供方  
		将自身服务注册到Eureka，从而使服务消费方能够找到  
	3、Service Consumer  
		服务消费方  
		从Eureka获取注册服务列表，从而能够消费服务  
		
**启动服务命令**

	一、nohup java -jar jaray-register-center.jar --spring.profiles.active=8761 >/dev/null 2>&1 &
	二、nohup java -jar jaray-register-center.jar --spring.profiles.active=8762 >/dev/null 2>&1 &
	
	访问URL：http://localhost:8761/
	访问URL：http://localhost:8762/
		
**下接服务提供者一service-provider-one**