<template>
    <header class="header">
      <a href="#" @click.prevent="changePage('Index')">
        <img src="../assets/img/ico.png" alt="Logo" class="logo"/>
      </a>
      <div class="header-content">
        <h1>PsyTech</h1>
        <h5>Gamification of psychological help</h5>
      </div>
      <nav>
        <ul class="nav-menu">
          <li><a href="#" @click.prevent="changePage('Psychologists')">For psychologists</a></li>
          <li><a href="#" @click.prevent="changePage('Users')">Users</a></li>
          <li><a href="#" @click.prevent="changePage('Info')">Info</a></li>
          <li><a href="#" @click.prevent="changePage('Materials')">Materials</a></li>
          <li><a href="#" @click.prevent="changePage('Partners')">For partners</a></li>
          <li v-if="user"><a href="#" @click.prevent="changePage('UserPage')">User's page</a></li>
        </ul>
      </nav>
      <div class="auth-buttons">
        <template v-if="user">
          {{user.name}}
          <a href="#" @click.prevent="onLogout">Logout</a>
        </template>
        <template v-else>
          <a href="#" @click.prevent="changePage('Enter')">Enter</a>
          <a href="#" @click.prevent="changePage('Register')">Register</a>
        </template>
      </div>
    </header>
</template>

<script>
export default {
    name: "Header",
    props: ["user"],
    methods: {
        changePage: function (page) {
            this.$root.$emit("onChangePage", page);
        },
        onLogout: function () {
            this.$root.$emit("onLogout");
            this.changePage("Index");
        }
    }
}
</script>

<style scoped>
  .flag {
    margin-left: 0.3rem;
  }
  .logo {
    max-width: 15rem;
  }
</style>
