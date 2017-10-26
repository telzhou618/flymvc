# Flymvc
一个简易MVC框架，正在完善
###  使用
1. 启动配置类
```Java
	
	public class App extends BootStrap{
	/**
	 * 默认配置
	 */
	@Override
	public void config(Config config) {}
	/**
	 * 路由
	 */
	@Override
	public void route(Routes routes) {
		routes.addRoute("/user", new UserController());
		routes.addRoute("/", new IndexController());
		routes.addRoute("/", new IndexController(),"index");
	}
	/**
	 * 插件
	 */
	@Override
	public void plugin(Plugins plugins) {}
	
	/**
	 * 全局拦截,执行顺序遵循spring的规则，先进后出
	 */
	@Override
	public void interceptor(Interceptors interceptors) {
		
		interceptors.add(new LoginInterceptor());
		interceptors.add(new PayInterceptor());
		
	}
	
    }
```
2. web.xml

```Xml
	
	<!-- 核心servlet -->
	<servlet>
		<servlet-name>flyMvcServlet</servlet-name>
		<servlet-class>com.flymvc.FlyMvcServlet</servlet-class>
		<init-param>
			<param-name>bootstrap</param-name>
			<param-value>com.flymvc.demo.App</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>flyMvcServlet</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>
```
3. 实例
```Java
	
	public class IndexController {
	public String index(Req req) {
		req.addAttr("str", "hello World");
		return "index";
	 }
    }
 
```
```Java
	
	public class UserController {

	/**
	 * 接收参数
	 * @param name
	 * @param age
	 * @return
	 */
	public String test(String name,Integer age){
		System.out.println(name);
		System.out.println(age);
		return "user/test";
	}
	/**
	 * 第二种接收参数的方法
	 * @param name
	 * @param age
	 * @return
	 */
	public String test2(Req req){
		System.out.println(req.getPara("name"));
		System.out.println(req.getParaToInt("age"));
		return "user/test";
	}
	/**
	 * 第三种接收参数的方法
	 * @param name
	 * @param age
	 * @return
	 */
	public String test3(HttpServletRequest request){
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		return "user/test";
	}
	/**
	 * 返回Json数据
	 */
	@RespJson
	public User json(){
		return new User("1", "zhangsan", "xxxxx", 18);
	}
	
	/**
	 * 响应自定义视图 javascript
	 */
	public void javascript(HttpServletRequest request,HttpServletResponse response){
		new JavaScriptRender().render(request, response, "hello world");
	 }
    } 
```
```
	
	#UserController控制器对应的http请求
	http://localhost:8080/user/test?name=zhangsan&age=10
	http://localhost:8080/user/test2?name=zhangsan&age=10
	http://localhost:8080/user/test3?name=zhangsan&age=10
	http://localhost:8080/user/json
	http://localhost:8080/user/javascript
```

4. 拦截器
```Java
	
	/**
	* 实现全局拦截器和以继承AbstractInterceptor或实现Interceptor接口来完成
	*
	**/
	public class LoginInterceptor extends AbstractInterceptor{

	/**
	* 方法执行前执行
	**/
	@Override
	public boolean before(HttpServletRequest request, HttpServletResponse response, Object object)
			throws InterceptorException {
		
		System.out.println("Login interceptor before");
		
		if(object instanceof ModelRender){
			
			ModelRender modelRender = (ModelRender) object;
			
			System.out.println("Controller:"+modelRender.getController());
			System.out.println("Method:"+modelRender.getMethod());
			System.out.println("Render:"+modelRender.getRender());
			
		}
		
		return true;
	}

	/**
	* 方法执行后执行
	**/
	@Override
	public boolean after(HttpServletRequest request, HttpServletResponse response, Object object)
			throws InterceptorException {
		
		System.out.println("Login interceptor after");
		return true;
	}	
    }
```

5. demo <br>
	https://github.com/zhougaojun618/flymvc-demo
6. 申明  <br>
	本项目纯属个人兴趣学习需要，如有不妥，请大神高抬贵手。
