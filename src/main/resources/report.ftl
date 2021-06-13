<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>

<h2>Report for test results</h2>

<table style="width:100%">
  <tr>
  <th>TestName</th>
  <th>TestData</th>
  <th>Status</th>
  </tr>
  <#list reportHelper as ReportData>
  <tr>
    <td>${ReportData.testName}</td>
    <td>${ReportData.testData}</td>
    <td>${ReportData.status}</td>
    
   </tr>
  </#list>
</table>

</body>
</html>
