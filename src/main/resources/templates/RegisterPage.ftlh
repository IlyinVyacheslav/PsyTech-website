<#import "commons.ftlh" as c>

<@c.page>
    <div class="auth-form">
        <form class="register-form" method="post" action="">
            <h2>Register</h2>
            <div class="form-group">
                <div class="name">
                    <label for="login">Login:</label>
                </div>
                <div class="value">
                    <input id="login" name="login" value="${registerForm.login!}"/>
                </div>
                <@c.error "registerForm.login"/>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="register-email">Email:</label>
                </div>
                <div class="value">
                    <input type="email" id="register-email" name="email" value="${registerForm.email!}"/>
                </div>
                <@c.error "registerForm.email"/>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="register-password">Password:</label>
                </div>
                <div class="value">
                    <input type="password" id="register-password" name="password"/>
                </div>
                <@c.error "registerForm.password"/>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="register-confirm-password">Confirm Password:</label>
                </div>
                <div class="value">
                    <input type="password" id="register-confirm-password" name="confirm_password">
                </div>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="register-phone">Phone Number:</label>
                </div>
                <div class="value">
                    <input type="tel" id="register-phone" name="phone" value="${registerForm.phone!}"/>
                </div>
                <@c.error "registerForm.phone"/>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn register-btn">Register</button>
            </div>
        </form>
    </div>
</@c.page>