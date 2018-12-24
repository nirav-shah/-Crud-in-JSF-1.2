<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Details</title>
</head>
<body>
<f:view>
	<h1><h:outputText value="Edit Details"></h:outputText></h1>
	<h:form>
		<h:panelGrid id = "panel" columns = "2" border = "1"
            cellpadding = "10" cellspacing = "1">
		
		<h:outputText value="Roll No : "></h:outputText>
		<h:inputText  value="#{editBean.roll}"></h:inputText>
		
		<h:outputText value="Name : "></h:outputText>
		<h:inputText  value="#{editBean.name}"></h:inputText>
		
		<h:outputText value="Email : "></h:outputText>
		<h:inputText  value="#{editBean.email}"></h:inputText>
		
		<h:outputText value="Phone : "></h:outputText>
		<h:inputText  value="#{editBean.phone}"></h:inputText>
		
		<h:outputText value="UserName : "></h:outputText>
		<h:inputText  value="#{editBean.username}"></h:inputText>
		
		<h:outputText value="Password"></h:outputText>
		<h:inputText value="#{editBean.password}"></h:inputText>
		 
		 <h:commandButton id = "submit" value = "Submit" action="#{studentBean.updateList(editBean)}" ></h:commandButton>
			
		 <table>
		 <tr>
		 <td>
		  <h:commandButton id = "reset" value = "Reset" type="reset" />
		  <h:commandButton id = "view" value = "Cancel" action="#{studentBean.backView}"></h:commandButton>
		 
		 </td>
		 </tr>
		 </table>
		 
		 
			
		 </h:panelGrid>
		
	</h:form>
</f:view>
</body>
</html>
</jsp:root>