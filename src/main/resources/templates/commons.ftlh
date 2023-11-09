<#-- @ftlvariable name="message" type="java.lang.String" -->
<#-- @ftlvariable name="user" type="wp.psyTech.domain.User" -->

<#macro page>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <title>PsyTech</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/png" href="/img/favicon.png">
</head>
<body>
<div class="page-wrapper">
    <header class="header">
        <img src="/img/ico.png" alt="Logo" class="logo">
        <div class="header-content">
            <h1>PsyTech</h1>
            <h5>Gamification of psychological help</h5>
        </div>
        <nav>
            <ul class="nav-menu">
                <li><a href="/psychologists">For psychologists</a></li>
                <li><a href="/info">About us</a></li>
                <li><a href="/materials">Materials</a></li>
                <li><a href="/partners">For partners</a></li>
            </ul>
        </nav>
        <div class="auth-buttons">
            <#if user??>
                <a>${user.login!}</a>
                <a class="logout-btn" href="/logout">Logout</a>
            <#else >
                <a class="login-btn" href="/login">Login</a>
                <a class="register-btn" href="/register">Register</a>
            </#if>
        </div>
    </header>
    <main class="main-content">
        <#nested/>
    </main>
</div>
<script>
    $(function () {
        <#if message??>
        $.notify("${message?js_string}", {position: "right bottom", className: "success"});
        </#if>
    })
</script>
</body>
</html>
</#macro>
