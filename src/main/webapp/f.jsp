<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>f.jsp</h3>
	
	<fieldset>
		<legend>8种基本类型</legend>
		<form action="/springmvc/user/f1.do" method="post">
			byte: <input type="text" name="b" /> <br />
			short: <input type="text" name="s" /> <br />
			int: <input type="text" name="i" /> <br />
			long: <input type="text" name="l" /> <br />
			float: <input type="text" name="f" /> <br />
			double: <input type="text" name="d" /> <br />
			boolean: <input type="text" name="bb" /> <br />
			char: <input type="text" name="c" /> <br />
			<button type="submit">Go</button>
		</form>
	</fieldset>
	
	<!-- 
		提价字符串类型的参数时，难免会提交中文，为了解决中文乱码，需要在web.xml中
		配置一个CharacterEncodingFilter。
	 -->
	<fieldset>
		<legend>java.lang.String类型</legend>
		<form action="/springmvc/user/f2.do" method="post">
			str: <input type="text" name="str" /> <br />
			<button type="submit">Go</button>
		</form>
	</fieldset>
	
	
	<fieldset>
		<legend>类类型</legend>
		<form action="/springmvc/user/f3.do" method="post">
			id: <input type="text" name="id" /> <br />
			name: <input type="text" name="name" /> <br />
			<!-- 注意，springmvc要求日期格式为yyyy/MM/dd -->
			birthday: <input type="text" name="birthday" /> <br />
			money: <input type="text" name="money" /> <br />
			<button type="submit">Go</button>
		</form>
	</fieldset>
	
	<fieldset>
		<legend>List类型</legend>
		<form action="/springmvc/user/f4.do" method="post">
			爱好: 
			<label>
				<input type="checkbox" name="hobby" value="game" />游戏
			</label>
			<label>
				<input type="checkbox" name="hobby" value="film" />电影
			</label>
			<label>
				<input type="checkbox" name="hobby" value="program" />编程
			</label>
			<button type="submit">Go</button>
		</form>
	</fieldset>
	
	
	<fieldset>
		<legend>Set类型</legend>
		<form action="/springmvc/user/f5.do" method="post">
			爱好: 
			<label>
				<input type="checkbox" name="hobby" value="climb" />爬山
			</label>
			<label>
				<input type="checkbox" name="hobby" value="swim" />游泳
			</label>
			<label>
				<input type="checkbox" name="hobby" value="run" />跑步
			</label>
			<button type="submit">Go</button>
		</form>
	</fieldset>

	<fieldset>
		<legend>Map类型</legend>
		<form action="/springmvc/user/f6.do" method="post">
			爱好: 
			<label>
				<input type="checkbox" name="a" value="hotpot" />火锅
			</label>
			<label>
				<input type="checkbox" name="b" value="maocai" />冒菜
			</label>
			<label>
				<input type="checkbox" name="c" value="chuanchuan" />串串
			</label>
			<button type="submit">Go</button>
		</form>
	</fieldset>
	
	
	
	
	
</body>
</html>