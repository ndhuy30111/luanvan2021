<template>
  <b-container class="login">
    <b-alert :show="message != ''" variant="danger">{{ message }}</b-alert>
    <b-row>
      <b-col md="3"></b-col>
      <b-col md="6">
        <b-form v-if="show" @submit="onSubmit" @reset="onReset">
          <b-form-group>
            <b-form-input
              id="uername"
              v-model="form.uername"
              type="text"
              placeholder="Tên tài khoản"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group>
            <b-form-input
              id="password"
              v-model="form.password"
              type="password"
              placeholder="Mật khẩu"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
            <b-form-checkbox-group
              id="checkboxes"
              v-model="form.checked"
              :aria-describedby="ariaDescribedby"
            >
              <b-form-checkbox value="remember">Remenber me</b-form-checkbox>
            </b-form-checkbox-group>
          </b-form-group>

          <Button :text="$local.vn.login" />
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
        username: '',
        password: '',
      },
      message: '',
      isActive: false,
      show: true,
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
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
}
</style>
