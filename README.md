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
4. demo <br>
	https://github.com/zhougaojun618/flymvc-demo
4. 申明  <br>
	<font color="red">本项目纯属个人兴趣学习需要，如有不妥，请高抬贵手。</font>
