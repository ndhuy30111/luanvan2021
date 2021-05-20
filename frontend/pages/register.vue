<template>
  <b-container class="register">
    <b-row>
      <b-col md="12">
        <b-form v-if="show" class="form" @submit="onSubmit" @reset="onReset">
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
              id="name"
              v-model="form.name"
              type="text"
              :state="form.name.length >= 5"
              placeholder="Name"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-input
              id="uername"
              v-model="form.uername"
              type="text"
              :state="form.uername.length >= 5"
              placeholder="User name"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-form-input
              id="password"
              v-model.trim="$v.form.password.$model"
              :state="form.password.length >= 6"
              type="password"
              placeholder="Password"
              required
            ></b-form-input>
          </b-form-group>

          <div v-if="!$v.form.password.minLength" class="mes_error">
            Password phai it nhat
            {{ $v.form.password.$params.minLength.min }} ky tu.
          </div>

          <b-form-group>
            <b-form-input
              id="repeatPassword"
              v-model.trim="$v.form.repeatPassword.$model"
              :state="form.repeatPassword === form.password"
              type="password"
              placeholder="Repeat Password"
              required
            ></b-form-input>
          </b-form-group>

          <div v-if="!$v.form.repeatPassword.sameAsPassword" class="mes_error">
            Passwords phai trung nhau.
          </div>
          <b-form-group id="checkboxes" v-slot="{ ariaDescribedby }">
            <b-form-checkbox-group
              id="checked"
              v-model="form.checked"
              :aria-describedby="ariaDescribedby"
            >
              <b-form-checkbox value="remember">Remenber me</b-form-checkbox>
            </b-form-checkbox-group>
          </b-form-group>

          <div class="d-flex justify-content-center">
            <Button text="Đăng ký" />
          </div>
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { sameAs, minLength } from 'vuelidate/lib/validators'
import Button from '../components/Button'

export default {
  name: 'Register',
  components: { Button },
  data() {
    return {
      form: {
        email: '',
        name: '',
        uername: '',
        password: '',
        repeatPassword: '',
      },
      show: true,
      isActive: false,
    }
  },
  validations: {
    form: {
      password: { minLength: minLength(6) },
      repeatPassword: { sameAsPassword: sameAs('password') },
    },
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.email = ''
      this.form.name = ''
      this.form.username = ''
      this.form.password = ''
      this.form.repeatPassword = ''

      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
  },
}
</script>
<style lang="scss" scope>
.register {
  .mes_error {
    font-size: 15px;
    color: red;
  }
  .form {
    position: relative;
    .form-group {
      input {
        font-size: 18px;
        padding: 20px;
        display: block;
        width: 100%;
        border: solid 1px #f3f3f3;
        background-color: #fff;
      }
    }
  }
}
</style>
