<template>
  <b-container class="login">
    <b-alert :show="message != ''" variant="danger">{{ message }}</b-alert>
    <b-row>
      <b-col id="title">
        <p>{{ $local.vn.login_title }}</p>
      </b-col>
      <b-col md="6">
        <b-form v-if="show" @submit="onSubmit" @reset="onReset">
          <b-form-group>
            <b-form-input
              id="email"
              v-model="form.email"
              type="email"
              :state="
                /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(form.email)
                  ? true
                  : false
              "
              placeholder="Email"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-form-input
              id="password"
              v-model="form.password"
              type="password"
              :placeholder="$local.vn.password"
              required
            ></b-form-input>
          </b-form-group>

          <div class="d-flex">
            <div>
              <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
                <b-form-checkbox-group
                  id="checkboxes"
                  v-model="form.checked"
                  :aria-describedby="ariaDescribedby"
                >
                  <b-form-checkbox value="remember">{{
                    $local.vn.remember_password
                  }}</b-form-checkbox>
                </b-form-checkbox-group>
              </b-form-group>
            </div>
            <div>
              <a href="#" class="forget_password">{{
                $local.vn.forget_password
              }}</a>
              <router-link :to="{ name: 'register' }" class="forget_password">{{
                $local.vn.register_title
              }}</router-link>
            </div>
          </div>
          <Button :text="$local.vn.login_title" @click="onFacebook" />
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import Button from '../components/Button'
export default {
  components: { Button },
  data() {
    return {
      form: {
        email: '',
        password: '',
      },
      message: '',
      isActive: false,
      show: true,
    }
  },
  methods: {
    async onSubmit(event) {
      event.preventDefault()
      try {
        await this.$auth
          .loginWith('local', {
            data: {
              email: this.form.email,
              password: this.form.password,
            },
          })
          .then(() => {
            this.$router.push({ name: 'index' })
          })
      } catch (ex) {
        alert('Bạn không thể truy cập')
      }
    },
    async onFacebook() {
      await this.$auth.loginWith('facebook')
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.email = ''
      this.form.password = ''

      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
  },
}
</script>
<style lang="scss" scoped>
.login {
  #title {
    font-size: 60px;
    justify-content: center;
  }
  .form {
    position: relative;
    input {
      font-size: 18px;
      padding: 20px;
      display: block;
      width: 100%;
      border: solid 1px #f3f3f3;
      background-color: #fff;
      border-radius: 25px !important;
    }
  }
  .forget_password:nth-child(2) {
    margin-left: 10px;
  }
  .forget_password:hover {
    color: red;
  }
}
@media screen and (max-width: 600px) {
  .login {
    #title {
      margin-top: 0px;
      font-size: 40px;
    }
  }
}
</style>
