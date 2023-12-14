<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Audit</title>
</head>
<body>
<h1>User Audit</h1>

<table>
    <thead>
    <tr>
        <th>User ID</th>
        <th>Active</th>
        <th>Color</th>
        <th>Number</th>
        <th>Message</th>
    </tr>
    </thead>
    <tbody>
    <#list userAuditList as userAudit>
        <tr>
            <td>${userAudit.userId}</td>
            <td>${userAudit.active}</td>
            <td>${userAudit.color}</td>
            <td>${userAudit.number}</td>
            <td>${userAudit.message}</td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
