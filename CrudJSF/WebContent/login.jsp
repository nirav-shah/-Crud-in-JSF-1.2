<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<f:view>
	<h1><h:outputText value="User Login"></h:outputText></h1>
<h:form>
	<h:panelGrid id="panel" columns="3" border="0" cellpadding="10" cellspacing="3">
	
	<h:outputText value="Username : "></h:outputText>
	<h:inputText id="username" value="#{studentBean.username}"></h:inputText>
	<h:message for="username"></h:message>
	
	<h:outputText value="Password : "></h:outputText>
	<h:inputSecret id="password" value="#{studentBean.password}"></h:inputSecret>
	<h:message for="password"></h:message>
	
	
	<h:commandButton id="login" value="Login" action="#{studentBean.login}"></h:commandButton>
 	<h:panelGrid columns="2">
	<h:commandButton id="reset" value="Reset" type="reset"></h:commandButton>
	<h:commandButton id="register" value="New User?" action="#{studentBean.register}"></h:commandButton>
	</h:panelGrid>
	
	</h:panelGrid>
	<h:messages></h:messages>
</h:form>
</f:view>
</body>
</html>