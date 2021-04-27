<template>
  <v-app id="inspire">
    <v-content>
      <v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs12 sm8 md4>
            <v-card class="elevation-12">
              <v-toolbar dark color="primary">
                <v-toolbar-title>Đăng nhập</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                    v-model="username"
                    label="Email"
                    type="text"
                  ></v-text-field>
                  <v-text-field label="Password" type="password"></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" @click="submit">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </v-app>
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
<style lang="scss" scoped></style>
