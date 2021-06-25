<template>
  <v-container fluid>
    <v-row>
      <v-col class="checkout_title d-flex justify-content-center">
        <h2 class="hidden-sm-and-down">{{ $local.vn.info_checkout }}</h2>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" md="6">
        <v-card elevation="0">
          <v-card-title>
            <v-avatar color="#FF0000" size="32" class="avatar">1</v-avatar>
            <span class="text-h6">{{ $local.vn.info_bill }}</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col cols="12">
                  <v-text-field
                    :label="$local.vn.full_name"
                    :value="user.name"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="6">
                  <v-text-field
                    label="Email"
                    :value="user.email"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="6">
                  <v-text-field
                    :label="$local.vn.phone"
                    :value="user.numberPhone"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="4">
                  <v-select
                    v-model="select_provice"
                    :items="provice"
                    :label="$local.vn.provice"
                    item-text="name"
                    item-value="code"
                    @change="$fetch"
                  ></v-select>
                </v-col>
                <v-col cols="4">
                  <v-select
                    v-model="select_district"
                    :items="district"
                    :label="$local.vn.district"
                    item-text="name_with_type"
                    item-value="code"
                    @change="$fetch"
                  ></v-select>
                </v-col>
                <v-col cols="4">
                  <v-select
                    :items="commune"
                    :label="$local.vn.commune"
                    item-text="name_with_type"
                  ></v-select>
                </v-col>
                <v-col cols="12">
                  <v-text-field
                    :label="$local.vn.address"
                    :value="user.address"
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <v-textarea :label="$local.vn.note_bill"></v-textarea>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
        </v-card>
      </v-col>
      <v-col cols="12" md="6">
        <v-row>
          <v-col cols="12">
            <v-card elevation="0">
              <v-card-title>
                <v-avatar color="#FF0000" size="32" class="avatar">2</v-avatar>
                <span class="text-h6">{{ $local.vn.payment }}</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12">
                      <v-radio-group>
                        <v-radio :label="$local.vn.COD" value="COD"></v-radio>
                      </v-radio-group>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-card elevation="0">
              <v-card-title>
                <v-avatar color="#FF0000" size="32" class="avatar">3</v-avatar>
                <span class="text-h6">{{ $local.vn.info_cart }}</span>
              </v-card-title>
              <v-card-text>
                <v-container fluid>
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
                                  <img
                                    :src="item.image"
                                    alt=""
                                    style="width: 50%"
                                  />
                                </a>
                              </td>
                              <td class="cart-title">
                                <h6>
                                  {{ item.name }} / {{ item.color }} /
                                  {{ item.size }}
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
                      </div>

                      <div>
                        <v-row>
                          <v-col>
                            <strong>{{ $local.vn.provisional }}</strong>
                          </v-col>
                          <v-col>
                            <h6>
                              {{ parseInt(total).toLocaleString() }}
                              {{ $local.vn.currency }}
                            </h6>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col>
                            {{ $local.vn.shipping }}
                          </v-col>
                          <v-col>
                            <h6>
                              {{ parseInt(shipping).toLocaleString() }}
                              {{ $local.vn.currency }}
                            </h6>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col>
                            <strong>{{ $local.vn.total }}</strong>
                          </v-col>
                          <v-col>
                            <h6>
                              {{
                                (
                                  parseInt(shipping) + parseInt(total)
                                ).toLocaleString()
                              }}
                              {{ $local.vn.currency }}
                            </h6>
                          </v-col>
                        </v-row>
                        <v-row>
                          <v-col class="d-flex justify-content-center">
                            <v-btn
                              class="ma-2 white--text"
                              :loading="loading"
                              :disabled="loading"
                              color="#FF0000"
                              @click="loader = 'loading'"
                            >
                              {{ $local.vn.checkout }}
                            </v-btn>
                            <router-link :to="{ name: 'index' }">
                              <v-btn
                                class="ma-2 white--text"
                                color="black"
                                @click="loader = 'loading'"
                              >
                                {{ $local.vn.keep_buying }}
                              </v-btn>
                            </router-link>
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
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Checkout',
  data() {
    return {
      discount: '',
      loading: false,
      loader: null,
      shipping: 15000,
      select_provice: '',
      select_district: '',
      provice: [],
      district: [],
      commune: [],
    }
  },
  async fetch() {
    const data = await this.$content('location').fetch()
    Object.entries(data[0]).forEach((item) => {
      if (item[0] === item[1].code) {
        this.provice.push(item[1])
      }
    })
    if (this.select_provice) {
      const tam = []
      const data = await this.$content('location', 'quan-huyen').fetch()
      data.forEach((el) => {
        if (el.slug === this.select_provice) {
          Object.entries(el).forEach((item) => {
            if (item[0] === item[1].code) {
              tam.push(item[1])
            }
          })
        }
      })
      this.district = tam
    }
    if (this.select_district) {
      const tam = []
      const data = await this.$content('location', 'xa-phuong').fetch()
      data.forEach((el) => {
        if (el.slug === this.select_district) {
          Object.entries(el).forEach((item) => {
            if (item[0] === item[1].code) {
              tam.push(item[1])
            }
          })
        }
      })
      this.commune = tam
    }
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
.checkout_title {
  margin-top: -10px;
  margin-bottom: 10px;
}
.avatar {
  margin-right: 10px;
}
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
