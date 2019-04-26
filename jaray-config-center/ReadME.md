**一、搭建配置中心高可用一jaray-config-center步骤**
	
	#注：可以启多个修改启动端口即可

	#一、引入依赖spring-cloud-config-server  

	#二、添加@EnableConfigServer注解启用配置中心服务

	#三、配置文件如下
		spring:
		  profiles:
		    active: native
		  #配置文件存放位置
		  cloud:
		    config: 
    	      server:
        	     native:
        	       #search-locations: ${user.home}/config,${user.home}/config/{application}
        	       search-locations: classpath:/config/{application}  

	#四、客户端配置bootstrap.yml文件
		spring: 
		  cloud: 
		    config: 
		      #name: jaray-config   name存在后不能从配置中心获取文件
		      profile: dev
		      label: master
		      discovery: 
		        enabled: true
		        service-id: jaray-config-center   #通过服务名读取配置文件实现高可用
		
**启动服务命令**

	一、nohup java -jar jaray-config-center.jar >/dev/null 2>&1 &
	
**调用**

	http://localhost:8888/
	
**集成Swagger**

	①、引入依赖springfox-swagger2、springfox-swagger-ui
	②、配置SwaggerConfig
	③、在Controller中使用注解添加文档内容
	@Api：用在类上，说明该类的作用。
	@ApiOperation：注解来给API增加方法说明。
	@ApiImplicitParams : 用在方法上包含一组参数说明。
	@ApiImplicitParam：用来注解来给方法入参增加说明。
	@ApiResponses：用于表示一组响应
	@ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
	  l   code：数字，例如400
	  l   message：信息，例如"请求参数没填好"
	  l   response：抛出异常的类   
	@ApiModel：描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
	  l   @ApiModelProperty：描述一个model的属性
	  
	**注意：@ApiImplicitParam的参数说明：**
		paramType：指定参数放在哪个地方
			header：请求参数放置于Request Header，使用@RequestHeader获取
			query：请求参数放置于请求地址，使用@RequestParam获取
			path：（用于restful接口）-->请求参数的获取：@PathVariable
			body：（不常用）
			form（不常用）
		name：参数名
		dataType：参数类型
		required：参数是否必须传        true | false
		value：说明参数的意思
		defaultValue：参数的默认值
	**注意：每个方法需要使用@GetMapping、@PostMapping(不能使用@RequestMapping)**
	
	访问URL：http://localhost:7001/swagger-ui.html

**下接链路追踪jaray-sleuth-zipkin-center**