<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<f:view>
	<h1><h:outputText value="Registration"></h:outputText></h1>
	<h:form>
		<h:panelGrid id = "panel" columns = "2" border = "1"
            cellpadding = "10" cellspacing = "1">
		
		<h:outputText value="Roll No : "></h:outputText>
		<h:inputText  value="#{studentBean.roll}"></h:inputText>
		
		<h:outputText value="Name : "></h:outputText>
		<h:inputText  value="#{studentBean.name}"></h:inputText>
		
		<h:outputText value="Email : "></h:outputText>
		<h:inputText  value="#{studentBean.email}"></h:inputText>
		
		<h:outputText value="Phone : "></h:outputText>
		<h:inputText  value="#{studentBean.phone}"></h:inputText>
		
		<h:outputText value="UserName : "></h:outputText>
		<h:inputText  value="#{studentBean.username}"></h:inputText>
		
		<h:outputText value="Password"></h:outputText>
		<h:inputSecret value="#{studentBean.password}"></h:inputSecret>
		 
		 <h:commandButton id = "submit" value = "Submit" action="#{studentBean.addUser(studentBean)}" />
			
		 <table>
		 <tr>
		 <td>
		  <h:commandButton id = "reset" value = "Reset" type="reset" />
		  <h:commandButton id = "login" value = "Back to Login" action="#{studentBean.backLogin}"></h:commandButton>
		 
		 </td>
		 </tr>
		 </table>
		 
		</h:panelGrid>
		
	</h:form>
</f:view>
</body>
</html>