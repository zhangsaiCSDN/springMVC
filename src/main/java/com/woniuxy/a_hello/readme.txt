springmvc环境搭建步骤：
1. 导入依赖：
	spring-webmvc
	servlet
	jstl
	 !!!!!!!!!!!
2. 在web.xml中，添加springmvc的前端控制器的配置
	<servlet>
		<servlet-name>DispatcherServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:com/woniuxy/a_hello/spring-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>DispatcherServlet</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
	该前端控制器的作用是：=========
	a. 专门拦截以“.do”结尾的请求。
	b. 拦截到请求以后，就会进行请求的分发。
	c. 可以看出，这个springmvc的前端控制器就是一个Servlet！！
	   Servlet只有在第一次被请求时，才会被实例化出来！！ 而实例化DispatcherServlet时，
	   DispatcherServlet就会去创建spring ioc容器，并把该ioc容器存入application中！
	   （这恰恰就是ssh环境中的ContextLoaderListener监听器做的事情）
	       所以，必须告诉DispatcherServlet，spring的配置文件在哪，毕竟创建spring ioc容器的时候，一定要加载spring的配置文件！
	       
	补充，如果在配置servlet的时候，加上了
		<load-on-startup>1</load-on-startup>
	servlet就会在web应用被部署的时候，就直接被实例化出来！
	
3. 创建一个UserController，注意springmvc中的控制器命名都是以"Controller"结尾！
	
	就目前而言，springmvc的控制器，必须实现Controller接口！ 否则该类就不是springmvc的控制器类了！
	public class UserController implements Controller {
		public UserController() {
			System.out.println("UserController.UserController()");
		}
		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			System.out.println("UserController.handleRequest() ......");
			
			return null;
		}
	}
	
4. 创建springmvc的主配置文件，建议叫做:spring-servlet.xml，内容如下：
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
		<!-- 映射器处理器 -->
		<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
		
		<!-- 适配器处理器 -->
		<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>
		
		<!-- 视图解析器 -->
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/" />
			<property name="suffix" value=".jsp" />
		</bean>
		
		<!-- 配置控制器 -->
		<bean id="/user.do" class="com.woniuxy.a_hello.UserController"></bean>
	
	</beans>
	
	
5. 测试：
	打开浏览器，http://localhost/springmvc/user.do

=============================================================================================
=================

springmvc运行原理： （不需要死记硬背， 应该结合流程图背出原理）
1. 客户端发起请求，该请求被springmvc的前端控制器拦截住（DispatcherServlet）
2. 前端控制器把拦截住的请求，转发给映射器处理器。 
3. 映射器处理器接受到请求之后，就会根据请求，来找到一个具体的handler(暂时理解为controller)
4. 映射器处理器把找到的handler(暂时理解为controller)，再交给前端控制。
5. 前端控制器把接受到的handler，再交给适配器处理器。
6. 适配器处理器负责执行所接受到的handler，就会得到一个ModelAndView，ModelAndView对象中封装了逻辑视图
         适配器处理器再把ModelAndView对象传给前端控制器。
7. 前端控制器接收到ModelAndView，再交给视图解析器。
8. 视图解析器接受到ModelAndView，就会取出其中的逻辑视图，并解析为物理视图，再把得到的物理视图交给前端控制器
9. 前端控制器再向客户端做出响应！

	
	
	
