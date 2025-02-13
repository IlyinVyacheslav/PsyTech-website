<template>
  <div class="auth-form">
    <form class="register-form" @submit.prevent="onRegister">
      <h2>Register</h2>
      <div class="form-group">
        <div class="name">
          <label for="email">Email:</label>
        </div>
        <div class="value">
          <input id="email" name="email" v-model="email"/>
        </div>
      </div>
      <div class="form-group">
        <div class="name">
          <label for="name">Name:</label>
        </div>
        <div class="value">
          <input id="name" name="name" v-model="name"/>
        </div>
      </div>
      <div class="form-group">
        <div class="name">
          <label for="register-password">Password:</label>
        </div>
        <div class="value">
          <input type="password" id="register-password" name="password" v-model="password"/>
        </div>
      </div>
      <div class="form-group">
        <div class="name">
          <label for="register-confirm-password">Confirm Password:</label>
        </div>
        <div class="value">
          <input type="password" id="register-confirm-password" name="passwordConfirmation"
                 v-model="passwordConfirmation"/>
        </div>
      </div>
<!--      <div class="form-group">
        <div class="name">
          <label>Register as:</label>
        </div>
        <div class="value">
          <div class="variant">
          <input type="radio" id="user-role" name="role" value="client" v-model="role"/>
          <label for="user-role">Client</label>
          </div>
          <div class="variant">
          <input type="radio" id="user-role" name = "roll" value="psychologist" v-model="role"/>
          <label for="user-role">Psychologist</label>
          </div>
        </div>
      </div>-->
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
      email: "",
      name: "",
      password: "",
      passwordConfirmation: "",
      role: "",
      error: ""
    }
  },
  methods: {
    onRegister: function () {
      this.$root.$emit("onRegister", this.email, this.name, this.password, this.passwordConfirmation, this.role);
    }
  },
  beforeCreate() {
    this.$root.$on("onRegisterValidationError", (error) => this.error = error);
  }
}
</script>

<style scoped>

</style>