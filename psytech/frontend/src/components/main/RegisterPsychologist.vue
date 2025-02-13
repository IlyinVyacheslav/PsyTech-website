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
        <div class="name">
          <label for="age">Experience:</label>
        </div>
        <div class="value">
          <input id="experience" name="experience" v-model="experience"/>
        </div>
      </div>
      <div class="form-group">
        <div class="name">
          <label for="age">Diploma number:</label>
        </div>
        <div class="value">
          <input id="diplomaNumber" name="diplomaNumber" v-model="diplomaNumber"/>
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
      experience: "",
      diplomaNumber: "",
      error: ""
    }
  },
  methods: {
    onRegister: function () {
      this.$root.$emit("onRegisterPsychologist", this.age, this.experience, this.diplomaNumber);
    }
  },
  beforeCreate() {
    this.$root.$on("onRegisterValidationError", (error) => this.error = error);
  }
}
</script>

<style scoped>

</style>