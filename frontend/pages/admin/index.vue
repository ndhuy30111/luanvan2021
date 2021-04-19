<template>
  <div class="container">
    <div class="signin-content">
      <div class="signin-image">
        <figure><img src="~/assets/signin-image.jpg" /></figure>
      </div>
      <div class="signin-form">
        <h2>Sign up</h2>
        <form @submit.prevent="submit">
          <div class="form-group">
            <input type="email" placeholder="Your Email" />
          </div>
          <div class="form-group">
            <input type="password" placeholder="Password" />
          </div>
          <div class="form-group">
            <input type="submit" value="Log in" class="form-submit" />
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  layout: 'loginAdmin',
  methods: {
    submit(e) {
      e.preventDefault()
    },
  },
}
</script>
<style lang="scss">
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
    .signin-image {
      width: 50%;
      overflow: hidden;
      margin-left: 110px;
      margin-right: 20px;
      margin-top: 10px;
    }
    .signin-form {
      width: 100%;
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
