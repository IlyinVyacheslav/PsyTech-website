<template>
  <div>
    <div class="main-content">
      <section class="content">
        <h2>Плюсы работы с нами</h2>
        <p>Тут бесконечное количество преимуществ я устала писать на англисйком дааа лол а еще выравнивание по правой
          границе
          текста видимо надо это пофиксить будет!</p>
      </section>
    </div>
    <div class="auth-form" v-if="user">
      <form class="register-form" @submit.prevent="onPsychoRegister">
        <h2>Register</h2>

        <div class="form-group">
          <div class="name">
            <label for="age">Возраст:</label>
          </div>
          <div class="value">
            <input type="number" id="age" name="age" v-model="age"/>
          </div>
        </div>

        <div class="form-group">
          <div class="name">
            <label for="diploma-number">Номер диплома:</label>
          </div>
          <div class="value">
            <input type="text" id="diploma-number" name="diplomaNumber" v-model="diplomaNumber"/>
          </div>
        </div>

        <div class="form-group">
          <div class="name">
            <label for="work-experience">Опыт работы (в годах):</label>
          </div>
          <div class="value">
            <input type="number" id="work-experience" name="workExperience" v-model="workExperience"/>
          </div>
        </div>
        <div class="error">{{ error }}</div>
        <div class="form-actions">
          <button type="submit" class="btn register-btn">Register</button>
        </div>
      </form>
    </div>

    <div class="auth-form" v-else>
      <p>Пожалуйста, что бы зарегистрировать как психолог, для начала войдите в аккаунт!</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "PsychoRegister",
  props: ["user"],
  data: function () {
    return {
      age: "",
      diplomaNumber: "",
      workExperience:"",
      error: ""
    }
  },
  methods: {
    onPsychoRegister: function () {
      this.$root.$emit("onPsychoRegister", this.age, this.diplomaNumber, this.workExperience);
    }
  },
  beforeCreate() {
    this.$root.$on("onRegisterValidationError", (error) => this.error = error);
  }
}
</script>

<style scoped>

</style>