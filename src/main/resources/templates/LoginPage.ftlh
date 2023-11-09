<#import "commons.ftlh" as c>

<@c.page>
    <div class="auth-form">
        <form class="login-form" method="post" action="">
            <h2>Login</h2>
            <div class="form-group">
                <div class="name">
                    <label for="login">Username:</label>
                </div>
                <div class="value">
                    <input id="login" name="login" value="${loginForm.login!}">
                </div>
                <@c.error "loginForm.login"/>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="login-password">Password:</label>
                </div>
                <div class="value">
                    <input type="password" id="login-password" name="password">
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn login-btn">Login</button>
            </div>
        </form>
    </div>
</@c.page>