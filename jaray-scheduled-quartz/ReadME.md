**一、搭建分布式定时任务jaray-scheduled-quartz步骤**

	#一、引入依赖spring-boot-starter-quartz、quartz、quartz-jobs、spring-context-support  

	#二、添加@EnableEurekaServer注解启用注册中心  

	#三、配置文件  
		
**启动服务命令**

	一、nohup java -jar jaray-scheduled-quartz.jar --server.port=8001 >/dev/null 2>&1 &
	二、nohup java -jar jaray-scheduled-quartz.jar --server.port=8002 >/dev/null 2>&1 &
	
	注：多个服务时定时任务执行一个任务时其他定时任务将不执行
	但是只在一个服务中执行，只有当第一个服务中停止时，才会在另一个服务中执行
		
**下接服务提供者一service-provider-one**