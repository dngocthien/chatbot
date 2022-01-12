<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alien Bot | thiendinh</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/alienBot.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<header> <jsp:include page="menu.jsp" /> </header>

	<main>
	<div class="wrapper">
		<div class="grid">
			<div class="chatbox">
				<div class="wrapperchatbox">
					<div class="containbox">
						<div class="chatbox-overlay"></div>
						<div class="chatbox-logs"></div>
					</div>
					<div class="inforbox">
						<h6></h6>
					</div>
					<div class="enterbox">
						<form action="Answers" method="get">
							<input type="text" id="chat-input" name="uText" autofocus
								placeholder="Send a message..." />
							<button type="submit" class="chat-submit" id="chat-submit">
								<i class="material-icons">send</i>
							</button>
						</form>
					</div>
				</div>
			</div>
			<div class="intro">
				<div class="wrapperintro">
					<h2>Alien Bot</h2>
					<h6>Bot's created by Student, for Student</h6>
				</div>
			</div>
			<div class="tips">
				<div class="wrappertips">
					<h4>tips</h4>
					<h6>For the better support, please don't make me confused.</h6>
					<h6>Just ask me about Nong Lam University Information
						Technology faculty's enrollment questions.</h6>
					<h6>You can use command "clear" to clear chat content.</h6>
				</div>
			</div>
		</div>
	</div>
	<div style="dispay:none">google-site-verification: google5b841f97e4370b38.html</div>
	</main>
	<%-- <p id="ask"><%=request.getAttribute("uText")%></p> --%>

	<footer> <jsp:include page="footer.jsp" /> </footer>




	<!--  
	JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT 
	JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT 
	JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT 
	JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT 
	JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT 
	JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT JAVASCRIPT 
	 -->

	<script type="text/javascript">
		var INDEX =0;
		var chat = '${chat}';
		
		var input= "";
		var answer= "";
		
		var array = chat.split('>>>');
		var i=0;
		for(v of array){
		    text = v;
		    if(i==0){
		    	generate_message("Alien chat bot welcome you", 'user', i/2);
		    }
		    else if(i%2==1){
				generate_message(text+"", 'self', i/2);  // output
			}
		    else if(i%2==0){
				generate_message(text+"", 'user', i/2);  // input
			}
			i++;
		}

		function generate_message(msg, type, INDEX) {
			var str = "";
			str += "<div id='cm-msg-"+INDEX+"' class=\"chat-msg "+type+"\">";
			str += "      <span class=\"msg-avatar\">";
			str += "      <\/span>";
			str += "      <div class=\"cm-msg-text\">";
			str += msg;
			str += "      <\/div>";
			str += "<\/div>";
			$(".chatbox-logs").append(str);
			$("#cm-msg-" + INDEX).hide().fadeIn(300);
			/* if (type == 'user') {
				$("#chat-input").val('');
			} */
			$(".chatbox-logs").stop().animate({
				scrollTop : $(".chatbox-logs")[0].scrollHeight
			}, -1000);
		}
	</script>

</body>
</html>