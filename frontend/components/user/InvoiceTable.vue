<template>
  <v-container fluid>
    <v-row
      v-for="(data, index) in invoice"
      v-show="invoice.length > 0"
      :key="index"
    >
      <v-dialog v-model="dialog" max-width="500px">
        <v-card
          ><v-card-title>{{ message }}</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="closeDialog">{{
              $local.vn_admin_general.BTN_CANCEL
            }}</v-btn>
            <v-btn color="blue darken-1" text @click="save(data)">{{
              $local.vn_admin_general.BTN_SUBMIT
            }}</v-btn></v-card-actions
          ></v-card
        >
      </v-dialog>
      <v-row class="mt-1">
        <v-col cols="12" md="4">
          <h5 style="cursor: pointer">
            <strong>{{ $local.vn.billCode }}</strong>
            [{{ data.billCode }}]
          </h5>
        </v-col>
        <v-col
          ><h5>
            <strong>{{ $local.vn.createBillDate }}</strong>
            {{ data.createDate }}
          </h5></v-col
        >
      </v-row>
      <v-row v-for="(item, indexitem) in data.invoiceDetails" :key="indexitem">
        <v-col cols="12" md="12">
          <v-row>
            <v-col cols="12" md="3" sm="3">
              <v-img
                contain
                max-height="150"
                width="100%"
                :src="item.image"
                position="left"
                style="cursor: pointer"
                @click="productdetail(item)"
              />
            </v-col>
            <v-col cols="12" md="9" sm="9">
              <v-row>
                <v-col cols="12" md="5">
                  <h6>{{ item.name }}</h6>
                </v-col>
                <v-col cols="12" md="3">
                  <h6>
                    Giá:
                    {{ parseInt(item.price).toLocaleString() }}
                    {{ $local.vn.currency }}
                  </h6>
                </v-col>
                <v-col cols="12" md="3">
                  <h6>Số lượng: {{ item.amount }}</h6>
                </v-col>
              </v-row>
              <v-row>
                <v-col class="d-flex">
                  Số tiền:
                  <h5 class="money">
                    {{ parseInt(item.price * item.amount).toLocaleString() }}
                    {{ $local.vn.currency }}
                  </h5>
                </v-col>
              </v-row>
            </v-col>
          </v-row>
        </v-col>
      </v-row>
      <div class="d-flex">
        <div
          v-for="(t, indextotal) in total"
          :key="indextotal"
          class="d-flex total"
        >
          <div v-show="index === indextotal">
            <v-img
              contain
              max-height="25"
              width="100%"
              :src="require('@/assets/logo/money.png')"
              position="left"
              style="margin-right: -12px"
            />
          </div>
          <h5 v-show="index === indextotal">
            Tổng tiền:
            <strong class="money"
              >{{ parseInt(t).toLocaleString() }}
              {{ $local.vn.currency }}</strong
            >
            <br />
            <span v-show="data.payment === 'COD' && data.status <= 2">
              Thanh toán khi nhận hàng
            </span>
            <span v-show="data.status == 2">
              Đơn hàng đang được chuyển đến bạn.
            </span>
            <br />
            <router-link :to="{ name: 'contact' }">
              <span v-show="data.status == 2">
                Nếu bạn muốn hủy đơn vui lòng liên hệ trực tiếp
              </span>
            </router-link>
          </h5>
        </div>
      </div>
      <div v-show="data.status <= 1">
        <b-button class="btn" type="submit" @click="billDel"
          >Hủy đơn hàng
        </b-button>
      </div>
      <div
        v-show="data.status === 3"
        @click="productdetail(data.invoiceDetails[0])"
      >
        <b-button class="btn">Đánh giá </b-button>
      </div>
    </v-row>
    <v-row v-show="invoice.length === 0">
      <v-col>
        <v-img
          contain
          max-height="220"
          width="100%"
          position="top center"
          :src="require('@/assets/logo/404.svg')"
        />
        <h5 class="d-flex justify-content-center mt-3">Chưa có đơn hàng</h5>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  props: ['invoice', 'total'],
  data() {
    return {
      detailsDialog: false,
      dialog: false,
      message: '',
    }
  },
  watch: {
    billDel(val) {
      val || this.closeDialog()
    },
  },
  methods: {
    productdetail(item) {
      this.$router.push({
        name: 'productdetail-id',
        params: {
          id: item.productId,
        },
      })
    },
    closeDialog() {
      this.message = ''
      this.dialog = false
    },
    billDel() {
      this.action = 'del'
      this.message = 'Bạn muốn hủy đơn hàng ?'
      this.detailsDialog = false
      this.dialog = true
    },
    async save(item) {
      if (this.action === 'del') {
        await this.$store.dispatch(this.$constant.user.ACTION_INVOICE_DEL, item)
      }
      this.closeDialog()
    },
  },
}
</script>

<style lang="scss" scoped>
.btn {
  display: block;
  height: 35px;
  width: 180px;
  border-radius: 20px;
  outline: none;
  border: none;
  background: rgb(255, 0, 0);
  color: white;
  background-size: 200%;
  text-transform: uppercase;
  cursor: pointer;
  transition: 0.5s;
  margin: -5px 0px 0px 20px;
}
.btn:hover {
  background: rgb(110, 110, 110);
}
.money {
  color: red;
  margin-left: 5px;
}
h6 {
  font-size: 18px;
}
@media screen and (max-width: 600px) {
  h6 {
    font-size: 14px;
  }
}
</style>
