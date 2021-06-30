<template>
  <b-container class="register">
    <b-row>
      <b-col id="title">
        <p>{{ $local.vn.register_title }}</p>
      </b-col>
      <b-col md="7">
        <b-form
          v-if="show"
          class="form"
          @submit.prevent="register(form)"
          @reset="onReset"
        >
          <b--form-group>
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
          </b--form-group>
          <b-form-group>
            <b-form-input
              id="name"
              v-model="form.name"
              type="text"
              :state="form.name.length >= 5"
              :placeholder="$local.vn.user_name"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-input
              id="uername"
              v-model="form.userName"
              type="text"
              :state="form.userName.length >= 3"
              :placeholder="$local.vn.account_name"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-form-input
              id="address"
              v-model="form.address"
              type="text"
              :placeholder="$local.vn.address"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-form-input
              id="numberPhone"
              v-model="form.numberPhone"
              type="number"
              :state="
                form.numberPhone.length >= 10 && form.numberPhone.length <= 11
              "
              :placeholder="$local.vn.numberPhone"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group>
            <b-form-input
              id="password"
              v-model.trim="$v.form.password.$model"
              :state="form.password.length >= 6"
              type="password"
              :placeholder="$local.vn.password"
              required
            ></b-form-input>
          </b-form-group>

          <div v-if="!$v.form.password.minLength" class="mes_error">
            {{ $local.vn.err_password[0] }}
            {{ $v.form.password.$params.minLength.min }}
            {{ $local.vn.err_password[1] }}
          </div>

          <b-form-group>
            <b-form-input
              id="repeatPassword"
              v-model.trim="$v.form.repeatPassword.$model"
              :state="form.repeatPassword === form.password"
              type="password"
              :placeholder="$local.vn.repeatPassword"
              required
            ></b-form-input>
          </b-form-group>

          <div v-if="!$v.form.repeatPassword.sameAsPassword" class="mes_error">
            {{ $local.vn.err_password[2] }}
          </div>

          <Button :text="$local.vn.register_title" />
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
        userName: '',
        address: '',
        numberPhone: '',
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
    register(form) {
      this.$store.dispatch(this.$constant.user.ACTIONS_USER_REGISTER, form)
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.email = ''
      this.form.name = ''
      this.form.userName = ''
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
  #title {
    font-size: 60px;
    justify-content: center;
  }
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
@media screen and (max-width: 600px) {
  .register {
    #title {
      margin-top: 0px;
      font-size: 40px;
    }
  }
}
</style>
