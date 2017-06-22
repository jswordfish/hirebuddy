<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="*"%>
    <%@ page import="java.util.*" %>
     <%@ page import="com.v2crm.web.forms.*" %>
     <%@ page import="com.v2crm.domain.Lead" %>
     
     <%
     LeadsForm leadsForm = new LeadsForm();
     
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GridView for Java - jQuery Data Table</title>
<!-- CSS -->
<link href="css/demo_page.css" rel="stylesheet" type="text/css" />
<link href="css/demo_table.css" rel="stylesheet" type="text/css" />       
<link href="css/demo_table_jui.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.8.24.custom.css" rel="stylesheet" type="text/css" media="all" />
<!-- Scripts -->
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.js" type="text/javascript"></script>
 <script type="text/javascript">
        $(document).ready(function () {
            $("#sales").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true               
            });
        });
 </script>
</head>
<body id="dt_example">
<div id="container">
<h1>Leads</h1>
<div id="demo_jui">
<table id="sales" class="display">
              <thead>
                  <tr>
                      <th><u>First Name</u></th>
                      <th><u>Last Name</u></th>
                      <th><u>Industry</u></th>
                      <th><u>Mobile</u></th>
                      <th><u>Email</u></th>
                      <th><u>Phone</u></th>
                  </tr>
              </thead>
              <tbody>
              <% for(Lead c: leadsForm.getLeads()){ %>
        <tr>
          <td><%=c.getFirstName()()%></td>
          <td><%=c.getLastName()%></td>
          <td><%=c.getIndustry().toString()%></td>
          <td><%=c.getMobile()%></td>
          <td><%=c.getPrimaryEmail()%></td>
          <td><%=c.getPrimaryPhone()%></td>
        </tr>
      <% } %>
              </tbody>
          </table>
          </div>
 </div>
</body>
</html>