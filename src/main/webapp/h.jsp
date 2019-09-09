<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>h.jsp</h3>
	
	<script>
		$(function() {
			$("button:eq(0)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/f1.do",
					headers: {
						"Accept":"a/b"
					}
				});
			});

			$("button:eq(1)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/f2.do",
					data:'{"id":2,"name":"xyz","birthday":"2012/12/21 6:50:55","money":55.5}',
					//data:{"id":2,"name":"xyz"},  
					headers: {
						"Content-Type":"application/json"
					}
				});
			});


			$("button:eq(2)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/f3.do",
					headers: {
						"Accept":"a/b"
					},
					success:function(data) {
						alert(data);
					}
				});
			});

			$("button:eq(3)").click(function() {
				$.ajax({
					type:"post",
					url:"/springmvc/user/f4.do",
					headers: {
						"Accept":"application/json"
					},
					success:function(data) {
						for(var i = 0; i < data.length; i++) {
							alert(data[i].id + " " + data[i].name);
						}
					}
				});
			});
		});
	</script>
	
	<button>b1</button>
	<button>b2</button>
	
	<button>b3</button>
	<button>b4</button>
</body>
</html>