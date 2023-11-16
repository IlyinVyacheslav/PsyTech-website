<template>
    <div class="auth-form">
      <form class="register-form" @submit.prevent="onRegister">
        <h2>Register</h2>
        <div class="form-group">
          <div class="name">
            <label for="login">Username:</label>
          </div>
          <div class="value">
            <input id="login" name="login" v-model="login"/>
          </div>
        </div>
<!--        <div class="form-group">-->
<!--          <div class="name">-->
<!--            <label for="register-email">Email:</label>-->
<!--          </div>-->
<!--          <div class="value">-->
<!--            <input type="email" id="register-email" name="email" v-model="email"/>-->
<!--          </div>-->
<!--        </div>-->
        <div class="form-group">
          <div class="name">
            <label for="register-password">Password:</label>
          </div>
          <div class="value">
            <input type="password" id="register-password" name="password" v-model="password"/>
          </div>
        </div>
<!--        <div class="form-group">-->
<!--          <div class="name">-->
<!--            <label for="register-confirm-password">Confirm Password:</label>-->
<!--          </div>-->
<!--          <div class="value">-->
<!--            <input type="password" id="register-confirm-password" name="confirm_password" v-model="confirm_password"/>-->
<!--          </div>-->
<!--        </div>-->
<!--        <div class="form-group">-->
<!--          <div class="name">-->
<!--            <label for="register-phone">Phone Number:</label>-->
<!--          </div>-->
<!--          <div class="value">-->
<!--            <input type="tel" id="register-phone" name="phone" v-model="phone"/>-->
<!--          </div>-->
<!--        </div>-->
        <div class="error">{{ error }}</div>
        <div class="form-actions">
          <button type="submit" class="btn register-btn">Register</button>
        </div>
      </form>
    </div>
</template>

<script>
export default {
    name: "Register",
    data: function () {
        return {
            login: "",
            name: "",
            password: "",
            error: ""
        }
    },
    methods: {
        onRegister: function () {
            this.$root.$emit("onRegister", this.login, this.name, this.password);
        }
    },
    beforeCreate() {
        this.$root.$on("onRegisterValidationError", (error) => this.error = error);
    }
}
</script>

<style scoped>

</style>