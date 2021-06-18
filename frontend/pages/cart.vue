<template>
  <b-container fluid class="shopping-cart">
    <b-row>
      <b-col cols="12" md="12">
        <div class="cart-table">
          <table>
            <thead>
              <tr>
                <th v-for="item in $local.vn.cart_tille" :key="item">
                  {{ item }}
                </th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(item, index) in cart" :key="index">
                <td class="cart-pic" style="width: 21%">
                  <a data-tip="Xem chi tiết" @click="productdetail(item)">
                    <img :src="item.img" alt="" style="width: 50%" />
                  </a>
                </td>
                <td class="cart-title">
                  <h5>
                    {{ item.name }} / {{ item.color.name }} /
                    {{ item.size.name }}
                  </h5>
                </td>
                <td class="p-price" aria-readonly="readonly">
                  {{ parseInt(item.price).toLocaleString() }}
                  {{ $local.vn.currency }}
                </td>
                <td class="qua-col">
                  <div class="quantity">
                    <div class="pro-qty">
                      <v-icon
                        slot="prepend"
                        color="green"
                        class="minus"
                        @click="minus(index)"
                      >
                        mdi-minus
                      </v-icon>
                      <input
                        class="count"
                        type="number"
                        min="1"
                        readonly
                        :value="item.quantity"
                      />
                      <v-icon
                        slot="append"
                        color="red"
                        class="plus"
                        @click="plus(index)"
                      >
                        mdi-plus
                      </v-icon>
                    </div>
                  </div>
                </td>
                <td class="total-price">
                  {{ parseInt(item.price * item.quantity).toLocaleString() }}
                  {{ $local.vn.currency }}
                </td>
                <td class="close-td" @click="removeProductCart(index)">
                  <b-icon icon="trash" style="cursor: pointer"></b-icon>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </b-col>
    </b-row>
    <b-row>
      <b-col class="col-lg-4 offset-lg-8">
        <div class="proceed-checkout">
          <ul>
            <li class="cart-total">
              {{ $local.vn.total }}
              <span
                >{{ parseInt(total).toLocaleString() }}
                {{ $local.vn.currency }}</span
              >
            </li>
          </ul>
          <router-link :to="{ name: 'checkout' }" class="proceed-btn">{{
            $local.vn.checkout
          }}</router-link>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Cart',
  computed: {
    cart() {
      return this.$store.state.user.cart.cart
    },
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      total: 'user/cart/total',
    }),
  },
  created() {
    this.$store.dispatch(
      this.$constant.user.ACTION_CHECKOUT_SETPRODUCT,
      this.cart
    )
  },
  methods: {
    productdetail(product) {
      this.$router.push({
        name: 'productdetail-id',
        params: {
          id: product.id,
        },
      })
    },
    removeProductCart(indexRemove) {
      this.$store.dispatch(
        this.$constant.user.ACTION_REMOVE_PRODUCTCART,
        indexRemove
      )
    },
    plus(i) {
      this.$store.dispatch(this.$constant.user.ACTION_PLUS_ITEMCART, i)
    },
    minus(i) {
      this.$store.dispatch(this.$constant.user.ACTION_MINUS_ITEMCART, i)
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
  .proceed-checkout {
    .proceed-btn {
      font-size: 14px;
      font-weight: 700;
      color: #000000;
      background: #ce785c;
      text-transform: uppercase;
      padding: 15px 25px 14px 25px;
      display: block;
      text-align: center;
      text-decoration: none;
    }
    .proceed-btn:hover {
      color: red;
    }
    ul {
      border: 2px solid #ebebeb;
      background: #f3f3f3;
      padding-left: 25px;
      padding-right: 25px;
      padding-top: 16px;
      padding-bottom: 20px;
      li {
        list-style: none;
        font-size: 16px;
        font-weight: 700;
        color: #252525;
        overflow: hidden;
        .cart-total {
          padding-top: 10px;
        }
        span {
          float: right;
          color: red;
        }
      }
    }
  }
}
.count {
  width: 30px;
}
.minus {
  font-size: 17px;
  margin-right: 10px;
  cursor: pointer;
}
.plus {
  font-size: 17px;
  margin-left: -7px;
  cursor: pointer;
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
    .proceed-checkout {
      .proceed-btn {
        font-size: 10px;
      }
      ul {
        li {
          font-size: 10px;
        }
      }
    }
  }
  * {
    font-size: 8px;
  }
  .count {
    width: 27px;
  }
  .minus {
    font-size: 10px;
    margin-right: 0px;
  }
  .plus {
    font-size: 10px;
    margin-left: -25px;
  }
}
</style>
