<template>
  <div class="middle">
    <Sidebar :posts="viewPosts"/>
    <main>
      <Index v-if="page === 'Index'" :posts="posts"/>
      <Enter v-if="page === 'Enter'"/>
      <Register v-if="page === 'Register'"/>
      <Users v-if="page === 'Users'" :users="users"/>
      <WritePost v-if="page === 'WritePost'" :user="user"/>
      <Info v-if="page === 'Info'"/>
      <Materials v-if="page === 'Materials'"/>
      <PsychoRegister v-if="page === 'PsychoRegister'" :user="user"/>
    </main>
  </div>
</template>

<script>
import Sidebar from "./sidebar/Sidebar";
import Index from "./main/Index";
import Enter from "./main/Enter";
import Register from "./main/Register";
import Users from "@/components/page/Users.vue";
import WritePost from "@/components/page/WritePost.vue";
import Info from "@/components/page/Info.vue";
import Materials from "@/components/page/Materials.vue";
import PsychoRegister from "@/components/main/PsychoRegister.vue";

export default {
  name: "Middle",
  data: function () {
    return {
      page: "Index"
    }
  },
  components: {
    PsychoRegister,
    WritePost,
    Users,
    Register,
    Enter,
    Index,
    Sidebar,
    Info,
    Materials
  },
  props: ["user", "posts", "users"],
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
