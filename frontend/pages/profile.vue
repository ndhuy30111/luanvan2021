<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <v-card class="mx-auto" outlined>
          <v-list-item three-line>
            <v-list-item-content>
              <v-list-item-title>
                <h4 class="title">{{ $local.vn.profile }}</h4>
              </v-list-item-title>
              <v-list-item-subtitle>
                <v-form v-model="valid">
                  <v-container>
                    <v-row>
                      <v-col cols="12" md="4">
                        <v-text-field
                          v-model="user.email"
                          label="E-mail"
                          readonly
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" md="4">
                        <v-text-field
                          v-model="user.userName"
                          :rules="userNameRules"
                          :label="$local.vn.account_name"
                          readonly
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" md="4">
                        <v-text-field
                          v-model="user.name"
                          :rules="nameRules"
                          :label="$local.vn.user_name"
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" md="8">
                        <v-text-field
                          v-model="user.address"
                          :rules="addressRules"
                          :label="$local.vn.address"
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col cols="12" md="4">
                        <v-text-field
                          v-model="user.numberPhone"
                          :rules="numberPhoneRules"
                          type="number"
                          :label="$local.vn.numberPhone"
                          required
                        ></v-text-field>
                      </v-col>
                    </v-row>
                  </v-container>
                </v-form>
              </v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-avatar
              class="hidden-sm-and-down mt-16"
              rounded-circle
              size="120"
              color="blue"
            >
              <span class="white--text text-h4">{{ avatar }}</span>
            </v-list-item-avatar>
          </v-list-item>

          <v-card-actions>
            <v-btn class="btn_update" outlined rounded text @click="update()">
              Sửa
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    valid: false,
    nameRules: [
      (v) => !!v || 'Tên người dùng không được để tróng',
      (v) => v.length > 6 || 'Tên người dùng ít nhất 6 kí tự',
    ],
    numberPhoneRules: [(v) => !!v || 'Số điện thoại không được để trống'],
    userNameRules: [
      (v) => !!v || 'Tên tài khoản không được để tróng',
      (v) => v.length > 6 || 'Tên tài khoản ít nhất 6 kí tự',
    ],
    addressRules: [(v) => !!v || 'Đại chỉ không được để trống'],
    emailRules: [
      (v) => !!v || 'E-mail không được để trống',
      (v) => /.+@.+/.test(v) || 'Không phải email',
    ],
    avatar: '',
    user: {
      email: '',
      name: '',
      userName: '',
      address: '',
      numberPhone: '',
    },
  }),
  watch() {
    this.editItem(this.$auth.user)
  },
  created() {
    const item = this.$auth.user
    this.editItem(item)
  },
  mounted() {
    const splitName = this.$auth.user.name.split(' ')
    this.avatar = this.$auth.user.name
      .charAt(0)
      .toUpperCase()
      .concat(splitName[splitName.length - 1].charAt(0).toUpperCase())
  },
  methods: {
    editItem(item) {
      this.user = Object.assign({}, item)
    },
    update() {
      this.$store.dispatch(this.$constant.user.ACTIONS_USER_UPDATE, this.user)
    },
  },
}
</script>

<style lang="scss" scoped>
.title {
  color: rgb(24, 149, 221);
}
.btn_update {
  background-color: rgb(24, 149, 221);
  color: aliceblue;
}
</style>
