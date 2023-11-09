<#import "commons.ftlh" as c>

<@c.page>
    <div class="auth-form">
        <form action="/login" method="post">
            <h2>Login</h2>
            <div class="form-group">
                <div class="name">
                    <label for="login-username">Username:</label>
                </div>
                <div class="value">
                    <input type="text" id="login-username" name="username" required>
                </div>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="login-password">Password:</label>
                </div>
                <div class="value">
                    <input type="password" id="login-password" name="password" required>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn login-btn">Login</button>
            </div>
        </form>
    </div>
</@c.page>