<template>
  <v-container fluid>
    <v-card flat>
      <v-tabs vertical>
        <v-tab> Chờ xác nhận </v-tab>
        <v-tab> Đang chuẩn bị hàng </v-tab>
        <v-tab> Vận chuyển </v-tab>
        <v-tab> Hoàn thành </v-tab>
        <v-tab> Đơn đã hủy </v-tab>
        <v-tab>
          {{ $local.vn.profile }}
        </v-tab>

        <v-tab-item> <InvoiceTable :invoice="not" /> </v-tab-item>
        <v-tab-item> <InvoiceTable :invoice="accuracy" /> </v-tab-item>
        <v-tab-item> <InvoiceTable :invoice="transport" /> </v-tab-item>
        <v-tab-item> <InvoiceTable :invoice="complete" /> </v-tab-item>
        <v-tab-item> <InvoiceTable :invoice="cancel" /> </v-tab-item>

        <v-tab-item>
          <v-card>
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
            </v-list-item>

            <v-card-actions class="d-flex justify-content-end">
              <v-btn class="btn_update" outlined rounded text @click="update()">
                Sửa
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-tab-item>
      </v-tabs>
    </v-card>
  </v-container>
</template>

<script>
import InvoiceTable from '../components/user/InvoiceTable.vue'
export default {
  components: { InvoiceTable },
  data: () => ({
    valid: false,
    nameRules: [(v) => !!v || 'Tên người dùng không được để tróng'],
    numberPhoneRules: [(v) => !!v || 'Số điện thoại không được để trống'],
    userNameRules: [(v) => !!v || 'Tên tài khoản không được để tróng'],
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
  computed: {
    not() {
      return this.$store.state.user.invoice.not
    },
    accuracy() {
      return this.$store.state.user.invoice.accuracy
    },
    transport() {
      return this.$store.state.user.invoice.transport
    },
    complete() {
      return this.$store.state.user.invoice.complete
    },
    cancel() {
      return this.$store.state.user.invoice.cancel
    },
  },
  watch() {
    this.editItem(this.$auth.user)
  },
  created() {
    const item = this.$auth.user
    this.editItem(item)
    this.$store.dispatch(this.$constant.user.ACTION_INVOICE_INIT_NOT)
    this.$store.dispatch(this.$constant.user.ACTION_INVOICE_INIT_ACCURACY)
    this.$store.dispatch(this.$constant.user.ACTION_INVOICE_INIT_TRANSPORT)
    this.$store.dispatch(this.$constant.user.ACTION_INVOICE_INIT_COMPLETE)
    this.$store.dispatch(this.$constant.user.ACTION_INVOICE_INIT_CANCEL)
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
.member {
  display: block;
  height: 32px;
  border-radius: 30px;
  outline: none;
  border: none;
  background: rgb(241, 16, 16);
  color: white;
  background-size: 200%;
  padding: 3px 9px;
  cursor: pointer;
  transition: 0.5s;
}
.listmenu {
  cursor: pointer;
}
</style>
