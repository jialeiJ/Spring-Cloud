**一、搭建分布式定时任务jaray-scheduled-shedlock步骤**

	#一、引入依赖shedlock-spring、shedlock-provider-jdbc-template  

	#二、添加@EnableEurekaServer注解启用注册中心  

	#三、配置文件  
		
**启动服务命令**

	一、nohup java -jar jaray-scheduled-shedlock.jar --server.port=8001 >/dev/null 2>&1 &
	二、nohup java -jar jaray-scheduled-shedlock.jar --server.port=8002 >/dev/null 2>&1 &
	
	注：多个服务时定时任务执行一个任务时其他定时任务将不执行
	但并不是只在一个服务中执行，第一次是一个服务中执行，下次可能是在另一个服务中执行
		
**下接服务提供者一service-provider-one**