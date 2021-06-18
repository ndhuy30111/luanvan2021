<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12" md="6" sm="6">
        <v-card>
          <v-card-title>
            <span class="text-h5">{{ $local.vn.user_profile }}</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12">
                  <v-text-field
                    :label="$local.vn.user_name"
                    :value="user.name"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    :label="$local.vn.account_name"
                    :value="user.userName"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    label="Email*"
                    :value="user.email"
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    :label="$local.vn.phone"
                    :value="user.numberPhone"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    :label="$local.vn.address"
                    :value="user.address"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="12" md="6" sm="6">
        <v-card>
          <v-card-title>
            <span class="text-h5">Thông tin đơn hàng</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12">
                  <div class="cart-table">
                    <table>
                      <tbody>
                        <tr v-for="(item, index) in checkout" :key="index">
                          <td class="cart-pic" style="width: 21%">
                            <a
                              data-tip="Xem chi tiết"
                              @click="productdetail(item)"
                            >
                              <img :src="item.img" alt="" style="width: 50%" />
                            </a>
                          </td>
                          <td class="cart-title">
                            <h6>
                              {{ item.name }} / {{ item.color.name }} /
                              {{ item.size.name }}
                            </h6>
                          </td>
                          <td class="p-price" aria-readonly="readonly">
                            {{ parseInt(item.price).toLocaleString() }} x
                            {{ item.quantity }}
                          </td>
                          <td
                            class="close-td"
                            @click="removeProductCheckout(index)"
                          >
                            <b-icon
                              icon="trash"
                              style="cursor: pointer"
                            ></b-icon>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                    <v-text-field
                      v-model="discount"
                      :label="$local.vn.discount"
                      clearable
                    ></v-text-field>
                  </div>

                  <div>
                    <v-row>
                      <v-col>
                        <strong>{{ $local.vn.shipping }}</strong>
                      </v-col>
                      <v-col>
                        <h6>0 {{ $local.vn.currency }}</h6>
                      </v-col>
                    </v-row>
                    <v-row>
                      <v-col>
                        <strong>{{ $local.vn.total }}</strong>
                      </v-col>
                      <v-col>
                        <h6>
                          {{ parseInt(total).toLocaleString() }}
                          {{ $local.vn.currency }}
                        </h6>
                      </v-col>
                    </v-row>
                    <v-row>
                      <v-col class="d-flex justify-content-center">
                        <v-btn
                          class="ma-2"
                          :loading="loading"
                          :disabled="loading"
                          color="blue"
                          @click="loader = 'loading'"
                        >
                          {{ $local.vn.checkout }}
                        </v-btn>
                      </v-col>
                    </v-row>
                  </div>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Checkout',
  data() {
    return { discount: '', loading: false, loader: null }
  },
  computed: {
    user() {
      return this.$auth.user ? this.$auth.user : ''
    },
    checkout() {
      return this.$store.state.user.checkout.checkout
    },
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      total: 'user/checkout/total',
    }),
  },
  watch: {
    loader() {
      const l = this.loader
      this[l] = !this[l]
      setTimeout(() => (this[l] = false), 3000)
      this.loader = null
    },
  },
  methods: {
    removeProductCheckout(indexRemove) {
      if (this.checkout.length > 1) {
        this.$store.dispatch(
          this.$constant.user.ACTION_REMOVE_PRODUCTCART_CHECKOUT,
          indexRemove
        )
      }
    },
  },
}
</script>

<style lang="scss" scoped>
.shopping-cart {
  padding-top: 20px;
  padding-bottom: 40px;
  .cart-table {
    margin-bottom: 20px;
    table {
      width: 100%;
      border: 1px solid #ebebeb;
      tr th {
        font-size: 16px;
        color: #252525;
        font-weight: 500;
        border-bottom: 1px solid #ebebeb;
        text-align: center;
        padding: 18px 0 19px;
        text-transform: uppercase;
        .p-name {
          text-align: left;
        }
      }
      tr td {
        text-align: center;
        padding-bottom: 34px;
        .p-price {
          width: 16%;
        }
        .qua-col {
          width: 16%;
          .quantity {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-pack: center;
            -ms-flex-pack: center;
            justify-content: center;
          }
        }
        .total-price {
          width: 12%;
        }
      }
    }
  }
}
@media screen and (max-width: 600px) {
  .shopping-cart {
    .cart-table {
      table {
        tr th {
          font-size: 10px;
        }
      }
    }
  }
  * {
    font-size: 8px;
  }
}
</style>
