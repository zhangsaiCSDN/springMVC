springmvc��������裺
1. ����������
	spring-webmvc
	servlet
	jstl
	
2. ��web.xml�У����springmvc��ǰ�˿�����������
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
	��ǰ�˿������������ǣ�
	a. ר�������ԡ�.do����β������
	b. ���ص������Ժ󣬾ͻ��������ķַ���
	c. ���Կ��������springmvc��ǰ�˿���������һ��Servlet����
	   Servletֻ���ڵ�һ�α�����ʱ���Żᱻʵ������������ ��ʵ����DispatcherServletʱ��
	   DispatcherServlet�ͻ�ȥ����spring ioc���������Ѹ�ioc��������application�У�
	   ����ǡǡ����ssh�����е�ContextLoaderListener�������������飩
	       ���ԣ��������DispatcherServlet��spring�������ļ����ģ��Ͼ�����spring ioc������ʱ��һ��Ҫ����spring�������ļ���
	       
	���䣬���������servlet��ʱ�򣬼�����
		<load-on-startup>1</load-on-startup>
	servlet�ͻ���webӦ�ñ������ʱ�򣬾�ֱ�ӱ�ʵ����������
	
3. ����һ��UserController��ע��springmvc�еĿ���������������"Controller"��β��
	
	��Ŀǰ���ԣ�springmvc�Ŀ�����������ʵ��Controller�ӿڣ� �������Ͳ���springmvc�Ŀ��������ˣ�
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
	
4. ����springmvc���������ļ����������:spring-servlet.xml���������£�
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
		<!-- ӳ���������� -->
		<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
		
		<!-- ������������ -->
		<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"></bean>
		
		<!-- ��ͼ������ -->
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/" />
			<property name="suffix" value=".jsp" />
		</bean>
		
		<!-- ���ÿ����� -->
		<bean id="/user.do" class="com.woniuxy.a_hello.UserController"></bean>
	
	</beans>
	
	
5. ���ԣ�
	���������http://localhost/springmvc/user.do

=============================================================================================

springmvc����ԭ�� ������Ҫ����Ӳ���� Ӧ�ý������ͼ����ԭ��
1. �ͻ��˷������󣬸�����springmvc��ǰ�˿���������ס��DispatcherServlet��
2. ǰ�˿�����������ס������ת����ӳ������������ 
3. ӳ�������������ܵ�����֮�󣬾ͻ�����������ҵ�һ�������handler(��ʱ���Ϊcontroller)
4. ӳ�������������ҵ���handler(��ʱ���Ϊcontroller)���ٽ���ǰ�˿��ơ�
5. ǰ�˿������ѽ��ܵ���handler���ٽ�����������������
6. ����������������ִ�������ܵ���handler���ͻ�õ�һ��ModelAndView��ModelAndView�����з�װ���߼���ͼ
         �������������ٰ�ModelAndView���󴫸�ǰ�˿�������
7. ǰ�˿��������յ�ModelAndView���ٽ�����ͼ��������
8. ��ͼ���������ܵ�ModelAndView���ͻ�ȡ�����е��߼���ͼ��������Ϊ������ͼ���ٰѵõ���������ͼ����ǰ�˿�����
9. ǰ�˿���������ͻ���������Ӧ��

	
	
	