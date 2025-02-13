<template>
  <div class="middle">
    <Sidebar :posts="viewPosts"/>
    <main>
      <Index v-if="page === 'Index'" :posts="posts"/>
      <Enter v-if="page === 'Enter'"/>
      <Register v-if="page === 'Register'"/>
      <RegisterClient v-if="page === 'RegisterClient'"/>
      <RegisterPsychologist v-if="page === 'RegisterPsychologist'"/>
      <Users v-if="page === 'Users'" :users="users"/>
      <UserPage v-if="page === 'UserPage'" :user="user" :client="client" :psychologist="psychologist"/>
      <WritePost v-if="page === 'WritePost'" :user="user"/>
      <Info v-if="page === 'Info'"/>
      <Materials v-if="page === 'Materials'"/>
    </main>
  </div>
</template>

<script>
import Sidebar from "./sidebar/Sidebar";
import Index from "./main/Index";
import Enter from "./main/Enter";
import Register from "./main/Register";
import Users from "./page/Users";
import WritePost from "./page/WritePost";
import Info from "./page/Info";
import Materials from "./page/Materials";
import RegisterClient from "./main/RegisterClient";
import RegisterPsychologist from "./main/RegisterPsychologist";
import UserPage from "./page/UserPage";

export default {
  name: "Middle",
  data: function () {
    return {
      page: "Index"
    }
  },
  components: {
    UserPage,
    RegisterClient,
    RegisterPsychologist,
    WritePost,
    Users,
    Register,
    Enter,
    Index,
    Sidebar,
    Info,
    Materials
  },
  props: ["user", "posts", "users", "client", "psychologist"],
  computed: {
    viewPosts: function () {
      return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
    }
  },
  beforeCreate() {
    this.$root.$on("onChangePage", (page) => this.page = page)
  }
}
</script>

<style scoped>

</style>
