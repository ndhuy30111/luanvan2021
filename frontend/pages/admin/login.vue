<template>
  <div class="container signin">
    <b-row class="signin-content">
      <b-col class="signin-image">
        <figure><img src="~/assets/signin-image.jpg" /></figure>
      </b-col>
      <b-col class="signin-form">
        <h2>Sign up</h2>
        <form @submit.prevent="submit">
          <div class="form-group">
            <input v-model="username" type="text" placeholder="Your Email" />
          </div>
          <div class="form-group">
            <input type="password" placeholder="Password" />
          </div>
          <div class="form-group">
            <input type="submit" value="Log in" class="form-submit" />
          </div>
        </form>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  layout: 'loginAdmin',
  middleware: 'isauthenticated',
  data() {
    return {
      username: '',
    }
  },
  methods: {
    submit(e) {
      e.preventDefault()
      this.$store.commit('authName', this.username)
      this.$router.push({ name: 'admin' })
    },
  },
}
</script>
<style lang="scss" scoped>
html {
  background: #f8f8f8;
  padding: 150px 0;
  height: 100%;
  .login {
    background: #f8f8f8;
  }
}
.signin {
  padding-top: 15px;
}
.container {
  border-radius: 20px;
  width: 900px;
  background: #fff;
  margin: 0 auto;
  box-shadow: 0 15px 16.83px 0.17px rgb(0 0 0 / 5%);
  .signin-content {
    display: -webkit-flex;
    padding-top: 5%;
    padding-bottom: 5%;
    @media only screen and (max-width: 600px) {
      .signin-image {
        display: none;
      }
    }

    .signin-image {
      width: 50%;
      overflow: hidden;
      margin-left: 110px;
      margin-right: 20px;
      margin-top: 10px;
    }
    .signin-form {
      form {
        .form-group {
          position: relative;
          margin-bottom: 25px;
          overflow: hidden;
          .form-submit {
            display: inline-block;
            background: #6dabe4;
            color: #fff;
            border-bottom: none;
            width: auto;
            padding: 15px 39px;
            border-radius: 5px;
            cursor: pointer;
          }
          .form-submit:active {
            background: #1862c9;
          }
        }
        input {
          width: 100%;
          display: block;
          border: none;
          border-bottom: 1px solid #999;
          padding: 6px 30px;
          font-family: Poppins;
          box-sizing: border-box;
        }
        input:focus,
        select:focus,
        textarea:focus {
          outline: none;
          box-shadow: none !important;
          -moz-box-shadow: none !important;
          -webkit-box-shadow: none !important;
          -o-box-shadow: none !important;
          -ms-box-shadow: none !important;
        }
        input:focus {
          border-bottom: 1px solid #222;
        }
      }
    }
  }
}
</style>
