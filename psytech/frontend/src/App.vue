<template>
  <div id="app">
    <Header :user="user"/>
    <Middle :user="user" :posts="posts" :users="users" :client="client" :psychologist="psychologist"/>
    <Footer/>
  </div>
</template>

<script>
import Header from "./components/Header";
import Middle from "./components/Middle";
import Footer from "./components/Footer";
import axios from "axios"

export default {
  name: 'App',
  components: {
    Footer,
    Middle,
    Header
  },
  data: function () {
    return {
      user: null,
      client: null,
      psychologist: null,
      posts: [],
      users: []
    }
  },
  beforeMount() {
    if (localStorage.getItem("jwt") && !this.user) {
      this.$root.$emit("onJwt", localStorage.getItem("jwt"));
    }

    axios.get("/api/1/users").then(response => {
      this.users = response.data;
    });

    axios.get("/api/1/posts").then(response => {
      this.posts = response.data;
    });
    setInterval(() => {
      axios.get("/api/1/users").then(response => {
        this.users = response.data;
      });
      axios.get("/api/1/posts").then(response => {
        this.posts = response.data;
      });
    }, 3000);
  },
  beforeCreate() {
    this.$root.$on("onEnter", (email, password) => {
      if (password === "") {
        this.$root.$emit("onEnterValidationError", "Password is required");
        return;
      }

      axios.post("/api/1/jwt", {
        email, password
      }).then(response => {
        localStorage.setItem("jwt", response.data);
        this.$root.$emit("onJwt", response.data);
      }).catch(error => {
        this.$root.$emit("onEnterValidationError", error.response.data);
      });
    });

    this.$root.$on("onRegister", (email, name, password, passwordConfirmation) => {
      if (email === "") {
        this.$root.$emit("onRegisterValidationError", "Email is required");
        return;
      }
      if (name === "") {
        this.$root.$emit("onRegisterValidationError", "Name is required");
        return;
      }
      if (password === "") {
        this.$root.$emit("onRegisterValidationError", "Password is required");
        return;
      }
      if (passwordConfirmation === "") {
        this.$root.$emit("onRegisterValidationError", "Password confirmation is required");
        return;
      }


      axios.post("/api/1/users/register", {
        email, name, password, passwordConfirmation
      }).then(response => {
        localStorage.setItem("jwt", response.data);
        this.$root.$emit("onUpdateUsers");
        this.$root.$emit("onJwt", response.data);
      }).catch(error => {
        this.$root.$emit("onRegisterValidationError", error.response.data);
      });
    });

    this.$root.$on("onRegisterClient", (age, info) => {
      const user = this.user
      if (user === null) {
        this.$root.$emit("onRegisterValidationError", "You should login before choosing role");
        return;
      }
      if (age === "") {
        this.$root.$emit("onRegisterValidationError", "Age is required");
        return;
      }
      if (info === "") {
        this.$root.$emit("onRegisterValidationError", "Info is required");
        return;
      }

      const jwt = localStorage.getItem("jwt")
      axios.post("/api/1/users/registerClient", {
        age, info
      }, {
        params: {
          jwt
        }
      }).then((response) => {
        this.client = response.data;
        this.$root.$emit("onChangePage", "UserPage");
      }).catch(error => {
        this.$root.$emit("onRegisterValidationError", error.response.data);
      });
    });

    this.$root.$on("onRegisterPsychologist", (age, experience, diplomaNumber) => {
      const user = this.user
      alert(diplomaNumber);
      if (user === null) {
        this.$root.$emit("onRegisterValidationError", "You should login before choosing role");
        return;
      }
      if (age === "") {
        this.$root.$emit("onRegisterValidationError", "Age is required");
        return;
      }
      if (experience === "") {
        this.$root.$emit("onRegisterValidationError", "Experience is required");
        return;
      }
      if (diplomaNumber === "") {
        this.$root.$emit("onRegisterValidationError", "Diploma is required");
        return;
      }

      const jwt = localStorage.getItem("jwt")
      axios.post("/api/1/users/registerPsychologist", {
        age, experience, diplomaNumber
      }, {
        params: {
          jwt
        }
      }).then((response) => {
        this.psychologist = response.data;
        this.$root.$emit("onChangePage", "UserPage");
      }).catch(error => {
        this.$root.$emit("onRegisterValidationError", error.response.data);
      });
    });

    this.$root.$on("onJwt", (jwt) => {
      localStorage.setItem("jwt", jwt);

      axios.get("/api/1/users/auth", {
        params: {
          jwt
        }
      }).then(response => {
        this.user = response.data;
        if (this.user.roles) {
          if (this.user.roles.some(role => role.name === 'CLIENT')) {
            axios.get(`/api/1/users/client/${this.user.id}`).then(response => {
              this.client = response.data;
            })
          }
          if (this.user.roles.some(role => role.name === 'PSYCHOLOGIST')) {
            axios.get(`/api/1/users/psychologist/${this.user.id}`).then(response => {
              this.psychologist = response.data;
            })
          }
        }
        this.$root.$emit("onChangePage", "Index");
      }).catch(() => this.$root.$emit("onLogout"))
    });

    this.$root.$on("onDeleteAccount", (user) => {
      axios.delete(`/api/1/users/${user.id}`,).then(() => {
        this.$root.$emit("onUpdateUsers");
        this.$root.$emit("onLogout");
      }).catch(() => alert("Error while deleting"))
    });

    this.$root.$on("onLogout", () => {
      localStorage.removeItem("jwt");
      this.user = null;
      this.client = null;
      this.psychologist = null;
      this.$root.$emit("onChangePage", "Index");
    });

    this.$root.$on("onWritePost", (title, text) => {
      const user = this.user
      if (user === null) {
        this.$root.$emit("onWritePostValidationError", "You should login before write post");
        return;
      }
      if (title === "") {
        this.$root.$emit("onWritePostValidationError", "title is required");
        return;
      }
      if (text === "") {
        this.$root.$emit("onWritePostValidationError", "text is required");
        return;
      }

      const jwt = localStorage.getItem("jwt")
      axios.post("/api/1/posts/writePost", {
        title, text
      }, {
        params: {
          jwt
        }
      }).then(() => {
        this.$root.$emit("onUpdatePosts");
      }).catch(error => {
        this.$root.$emit("onWritePostValidationError", error.response.data);
      });
    });

    this.$root.$on("onUpdateUsers", () => {
      axios.get("/api/1/users").then(response => {
        this.users = response.data;
      });
    });

    this.$root.$on("onUpdatePosts", () => {
      axios.get("/api/1/posts").then(response => {
        this.posts = response.data;
      });
    });

    this.$root.$on("onRequestRoleInfo", (id, role) => {
      axios.get(`/api/1/users/${role}/${id}`).then(response => {
        return response;
      })
    });
  }
}
</script>

<style>
#app {

}
</style>
