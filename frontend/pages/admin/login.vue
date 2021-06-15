<template>
  <v-app id="inspire">
    <v-container fill-height>
      <v-layout align-center justify-center>
        <v-flex xs12 sm8 md4>
          <v-card class="elevation-12">
            <v-toolbar dark color="primary">
              <v-toolbar-title> {{ $local.vn_admin.login }}</v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form>
                <v-text-field
                  v-model="email"
                  label="Email"
                  type="email"
                ></v-text-field>
                <v-text-field
                  v-model="password"
                  label="Password"
                  type="password"
                ></v-text-field>
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="primary" @click="submit">{{
                $local.vn_admin.login
              }}</v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
export default {
  layout: 'loginAdmin',
  middleware: 'isauthenticated',
  data() {
    return {
      email: '',
      password: '',
    }
  },
  methods: {
    async submit(e) {
      e.preventDefault()
      try {
        await this.$auth
          .loginWith('local', {
            data: { email: this.email, password: this.password },
          })
          .then(() => {
            this.$router.push({ name: 'admin' })
          })
      } catch (ex) {
        alert(this.$local.vn_admin.error_login)
      }
    },
  },
}
</script>
<style lang="scss" scoped></style>
