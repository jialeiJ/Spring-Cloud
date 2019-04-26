**一、搭建服务消费者一service-customer-one步骤**

	①、引入依赖spring-cloud-starter-openfeign  
	②、添加@EnableDiscoveryClient注解启用注册中心
		添加@EnableFeignClients注解开启Feign的功能  
	③、配置文件  
	④、feign调用实现
		@FeignClient(name = "service-provider")
		public interface HelloRemote {
			@GetMapping(value = "/hello/say/{name}")
    		public String hello(@PathVariable String name);
		}
	⑤、web层调用远程服务
		@RestController
		@RequestMapping("/hello")
		@Api(value="/hello", tags="Hello Consumer 控制器")
		public class HelloConsumerController {
			@Autowired
    		HelloRemote helloRemote;
	
    		@GetMapping("/say/{name}")
    		public String index(@PathVariable String name) {
        		return helloRemote.hello(name);
    		}
		}
		
	⑥、引入依赖feign-okhttp
		feign替换JDK默认的URLConnection为okhttp
		使用okhttp，能提高qps，因为okhttp有连接池和超时时间进行调优
		
	⑦、在配置文件中，禁用默认的http，启用okhttp
	  #禁用默认的http，启用okhttp
		feign: 
		  httpclient:
    	    enabled: false
    	  okhttp:
    	    enabled: true
		
**集成断路器**
	
	③、配置文件添加如下内容开启熔断
			#打开断路器(开启熔断)
			feign: 
			  hystrix: 
			    enabled: true
	④、创建HelloRemoteHystric回调类如下
		注：创建HelloRemoteHystrix类继承与HelloRemote实现回调的方法
		@Service
		public class HelloRemoteHystric implements HelloRemote {
			@Override
			public String hello(String name) {
				return "hello" +name+", this messge send failed ";
			}
		}
	⑤、HelloRemote修改如下
		注：在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容
		@FeignClient(name = "service-provider", fallback = HelloRemoteHystric.class)
		public interface HelloRemote {
			@GetMapping(value = "/hello/say/{name}")
    		public String hello(@PathVariable String name);
		}
		
**启动服务命令**

	一、nohup java -jar service-consumer-one.jar >/dev/null 2>&1 &
	
**调用**

	http://localhost:5001/hello/say/Jaray
	
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

**下接配置中心jaray-config-center**