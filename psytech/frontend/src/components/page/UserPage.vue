<template>
  <div class="main-content">
    <section class="content">
      <div class="caption">User's information</div>
      <p><strong>Name:</strong> {{ user.name }}</p>
      <p><strong>Email:</strong> {{ user.email }}</p>
      <div class="auth-buttons">
        <a href="#" @click.prevent="deleteAccount">Delete account</a>
      </div>
    </section>
    <div v-if="client">
      <section class="content">
        <div class="caption">Client's information</div>
        <p><strong>Age:</strong> {{ client.age }}</p>
        <p><strong>Personal information:</strong> {{ client.info }}</p>
      </section>
    </div>
    <div v-if="psychologist">
      <section class="content">
        <div class="caption">Psychologist's information</div>
        <p><strong>Age:</strong> {{ psychologist.age }}</p>
        <p><strong>Experience:</strong> {{ psychologist.experience }}</p>
        <p><strong>Diploma:</strong> {{ psychologist.diplomaNumber }}</p>
      </section>
    </div>
    <div v-if="!client && !psychologist" class="auth-buttons">
      <a href="#" @click.prevent="registerAsPsychologist">Register as Psychologist</a>
      <a href="#" @click.prevent="registerAsClient">Register as Client</a>
    </div>
  </div>
</template>

<script>

export default {
  name: "UserPage",
  props: ["user", "client", "psychologist"],
  methods: {
    deleteAccount: function () {
      if (confirm("Are you sure to delete account?")) {
        this.$root.$emit("onDeleteAccount", this.user);
        alert("yeees");
      }
    },
    registerAsPsychologist: function () {
      this.$root.$emit("onChangePage", "RegisterPsychologist");
    },
    registerAsClient: function () {
      this.$root.$emit("onChangePage", "RegisterClient");
    }
  }
}
</script>

<style scoped>
.auth-buttons {
  flex-direction: column;
  justify-content: center;
  align-items: center; /* Центрирование содержимого по горизонтали */
}
.auth-buttons a {
  margin-right: 200px;
}

</style>