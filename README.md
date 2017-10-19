# Flymvc
一个简易MVC框架，正在完善
###  使用
1. 启动配置
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

