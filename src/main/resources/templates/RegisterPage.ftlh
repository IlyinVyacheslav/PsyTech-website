<#import "commons.ftlh" as c>
<#import "/spring.ftl" as spring>

<#macro error field>
    <@spring.bind field/>
    <#if spring.status.errorMessage??>
        <div class="error">
            ${spring.status.errorMessage}
        </div>
    </#if>
</#macro>

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
                <@error "registerForm.login"/>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="register-email">Email:</label>
                </div>
                <div class="value">
                    <input type="email" id="register-email" name="email" value="${registerForm.email!}"/>
                </div>
                <@error "registerForm.email"/>
            </div>
            <div class="form-group">
                <div class="name">
                    <label for="register-password">Password:</label>
                </div>
                <div class="value">
                    <input type="password" id="register-password" name="password"/>
                </div>
                <@error "registerForm.password"/>
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
                <@error "registerForm.phone"/>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn register-btn">Register</button>
            </div>
        </form>
    </div>
</@c.page>