<%--
  Created by IntelliJ IDEA.
  User: kalaiselvan
  Date: 5/14/2018
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>ticket Details - Struts2 Dynamic Table Example</title>

    <script type ="text/javascript">

        function addMorePassengerRow(tableID) {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount); //to insert blank row

            var cell1 = row.insertCell(0);   //to insert first column
            var snoCol = document.createElement("input");
            snoCol.type = "text";
            snoCol.name="ticket.passengerDetail["+(rowCount-1)+"].sno";
            snoCol.value=rowCount;
            cell1.appendChild(snoCol);

            var cell2 = row.insertCell(1); //to insert second column
            var nameCol = document.createElement("input");
            nameCol.type = "text";
            nameCol.name="ticket.passengerDetail["+(rowCount-1)+"].name";
            cell2.appendChild(nameCol);

            var cell3 = row.insertCell(2); // to insert 3rd column
            var genderCol = document.createElement("input");
            genderCol.type = "text";
            genderCol.name="ticket.passengerDetail["+(rowCount-1)+"].gender";
            cell3.appendChild(genderCol);

            var cell4 = row.insertCell(3);  //to insert 4th column
            var ageCol = document.createElement("input");
            ageCol.type = "text";
            ageCol.name="ticket.passengerDetail["+(rowCount-1)+"].age";
            cell4.appendChild(ageCol);

            var cell5 = row.insertCell(4);   // to insert 5th column
            var rowRemoveCol = document.createElement("a");
            var text = document.createTextNode("Delete");
            rowRemoveCol.appendChild(text);
            rowRemoveCol.setAttribute("href","javascript:goSubmit("+(rowCount-1)+")");
            rowRemoveCol.name="reqlink[]";
            cell5.appendChild(rowRemoveCol);

            return false;

        }

        function goSubmit(rowindex)
        {
            document.ticketForm.rowindex.value=rowindex;
            document.ticketForm.action="delete";
            document.ticketForm.submit();

        }

    </script>

</head>
<body>

<h3>Ticket Booking</h3>
<s:actionerror/>

<s:form name="ticketForm" action="ticketBook" method="post" theme="%{currentTheme}">
    <s:hidden name="rowindex"/>

    <TABLE id="ticketTable" width="350px" border="1">
        <TR>
            <td>
                Bus Number : <s:textfield name="ticket.busNo" label="Bus Number"/>
            </td>
            <td>
                Bus Name : <s:textfield name="ticket.busName" label="Bus Name"/>
            </td>
        </TR>
        <TR>
            <td>
                From Number : <s:textfield name="ticket.fromStation" label="From Station"/>
            </td>
            <td>
                To Station : <s:textfield name="ticket.toStation" label="To Station"/>
            </td>
        </TR>

        <TR>
            <td>
                Fare : <s:textfield name="ticket.fare" label="Fare (to be displayed Automatically)"/>
            </td>
            <td>
                Journey Date : <s:textfield name="ticket.journeyDate" label="Journey Date"/>
            </td>
        </TR>

    </TABLE>

    Add / Remove Passenger Details :
    <TABLE id="pdTable" border="1">
        <TR>
            <TD>S.No.</TD>
            <TD>Name</TD>
            <TD>Gender</TD>
            <TD>Age</TD>
            <TD>Action</TD>
        </TR>

        <s:iterator value="ticket.passengerDetail" status="cnt" var="passgrList">
            <tr>
                <TD> <s:textfield name="ticket.passengerDetail[%{#cnt.count-1}].sno" /> </TD>
                <TD> <s:textfield name="ticket.passengerDetail[%{#cnt.count-1}].name" /> </TD>
                <TD> <s:textfield name="ticket.passengerDetail[%{#cnt.count-1}].gender" /> </TD>
                <TD> <s:textfield name="ticket.passengerDetail[%{#cnt.count-1}].age" /> </TD>
                <td><a href="javascript:goSubmit(<s:property value='#cnt.count-1'/>)">delete</a></td>
            </tr>
        </s:iterator>

    </TABLE>
    <table>
        <tr>
            <td align="right">
                <input type="button" value="Add More Passenger" onclick="addMorePassengerRow('pdTable')"/>
            </td>
        </tr>
        <tr>
            <td align="center">
                <s:submit value="Book Ticket" align="center"/>
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
