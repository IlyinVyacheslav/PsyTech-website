<template>
  <div class="auth-form">
    <form class="register-form" @submit.prevent="onRegister">
      <h2>Register</h2>
      <div class="form-group">
        <div class="name">
          <label for="age">Age:</label>
        </div>
        <div class="value">
          <input id="age" name="age" v-model="age"/>
        </div>
      </div>
      <div class="form-group">
        <div class="information">
          <label for="information">Information about yourself:</label>
        </div>
        <div class="value">
          <input id="information" name="information" v-model="information"/>
        </div>
      </div>
      <div class="error">{{ error }}</div>
      <div class="form-actions">
        <button type="submit" class="btn register-btn">Register</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "RegisterClient",
  data: function () {
    return {
      age: "",
      information: "",
      error: ""
    }
  },
  methods: {
    onRegister: function () {
      this.$root.$emit("onRegisterClient", this.age, this.information);
    }
  },
  beforeCreate() {
    this.$root.$on("onRegisterValidationError", (error) => this.error = error);
  }
}
</script>

<style scoped>

</style>