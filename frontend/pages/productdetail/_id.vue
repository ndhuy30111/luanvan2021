<template>
  <b-container>
    <b-row>
      <b-col cols="12" sm="6" md="8">
        <image-magnifier
          class="img"
          :src="imgActive"
          :zoom-src="imgActive"
          alt="img product"
          width="100%"
          height="100%"
          zoom-width="400"
          zoom-height="300"
        />
      </b-col>

      <b-col cols="12" sm="6" md="4">
        <div class="wrapper">
          <div class="outer">
            <div class="content">
              <span class="product__content">{{ products.name }}</span>
              <div class="colors-wrap">
                <h5>{{ $local.vn.color }}:</h5>
                <span
                  v-for="(item, indexColor) in products.detailsProduct"
                  :key="indexColor"
                  class="colors"
                  :style="{ background: item.color.code }"
                  :class="
                    colorActive.code === item.color.code ? 'selected' : ''
                  "
                  @click="ColorActive(item)"
                ></span>
              </div>

              <div class="size-wrap">
                <h5>{{ $local.vn.size }}:</h5>
                <span
                  v-for="(item, indexSize) in size"
                  :key="indexSize"
                  class="size"
                  :value="item.name"
                  :class="sizeActive.id === item.id ? 'selected' : ''"
                  @click="SizeActive(item)"
                  >{{ item.name }}</span
                >
              </div>

              <div class="size-wrap">
                <h5>{{ $local.vn.quantity }}:</h5>
                <v-icon
                  slot="prepend"
                  color="green"
                  class="minus"
                  @click="minus()"
                >
                  mdi-minus
                </v-icon>
                <b-form-input
                  id="input-amount"
                  v-model="quantity"
                  type="number"
                  min="1"
                  class="count"
                  readonly
                  style="background-color: white; border: none"
                  >{{ quantity }}</b-form-input
                >
                <v-icon slot="append" color="red" class="plus" @click="plus()">
                  mdi-plus
                </v-icon>
              </div>

              <div class="button">
                <span>
                  <a href="#">
                    {{ parseInt(products.price).toLocaleString() }}
                    {{ $local.vn.currency }}</a
                  >
                  <a class="cart-btn" @click="addCart()">
                    <b-icon icon="cart"></b-icon> {{ $local.vn.add_cart }}</a
                  >
                </span>
              </div>
            </div>
          </div>
        </div>
      </b-col>
    </b-row>
    <b-row class="opinion">
      <div>
        <v-tabs color="accent-4">
          <v-tab
            v-for="item in $local.vn.menuoption"
            id="menu_title"
            :key="item"
            >{{ item }}</v-tab
          >

          <v-tab-item>
            <v-container fluid>
              <v-row>
                <v-col cols="12">
                  <div class="info_img" v-html="products.info"></div>
                </v-col>
              </v-row>
            </v-container>
          </v-tab-item>

          <v-tab-item>
            <v-container fluid>
              <v-row>
                <v-col> </v-col>
              </v-row>
            </v-container>
          </v-tab-item>
        </v-tabs>
      </div>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Productdetail',
  data() {
    return {
      quantity: 1,
      imgActive: '',
      size: [],
      colorActive: {},
      sizeActive: {},
    }
  },
  computed: {
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      product: 'user/product/getFindProduct',
    }),
    products: {
      get() {
        const item = this.product({ id: parseInt(this.$route.params.id) })
        if (item) {
          return this.cloneProduct(item)
        }
        return {}
      },
      set(value) {
        this.products = value
      },
    },
    user() {
      return this.$auth.user ? this.$auth.user : ''
    },
  },
  watch: {
    ColorActive(item) {
      this.colorActive = item.color
      this.imgActive = item.image
      this.size = item.size
      this.sizeActive = this.size[0]
    },
  },
  methods: {
    cloneProduct(item) {
      this.imgActive = item.image
      this.colorActive = item.detailsProduct[0].color
      this.size = item.detailsProduct[0].size
      this.sizeActive = item.detailsProduct[0].size[0]
      return this.$_.cloneDeep(item)
    },
    ColorActive(item) {
      this.colorActive = item.color
      this.imgActive = item.image
      this.size = item.size
      this.sizeActive = this.size[0]
    },
    SizeActive(item) {
      this.sizeActive = item
    },
    addCart() {
      const cartItem = {
        id: this.products.id,
        name: this.products.name,
        size: this.sizeActive,
        color: this.colorActive,
        img: this.imgActive,
        price: this.products.price,
        quantity: parseInt(this.quantity),
      }
      if (!this.user) {
        this.$toast.global.login()
        this.$router.push({ name: 'login' })
      } else {
        this.$store.dispatch(
          this.$constant.user.ACTION_CART_ADDTOCART,
          cartItem
        )
      }
    },
    plus() {
      this.quantity++
    },
    minus() {
      if (this.quantity > 1) {
        this.quantity--
      }
    },
  },
}
</script>

<style lang="scss" scoped>
.wrapper {
  display: flex;
  align-items: center;
  justify-content: space-around;
  width: 100%;
  margin-top: 20px;
}
.outer {
  position: relative;
  background-color: #fff;
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  border-radius: 10px;
  margin-top: 30px;
}
p {
  width: 280px;
  font-size: 13px;
  line-height: 1.4;
  color: #aaa;
  margin: 20px 0;
}
.img {
  top: 0px;
  right: 0px;
  width: 80%;
  margin-top: -15px;
  height: 70%;
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
}
.content {
  position: relative;
  z-index: 3;
  margin-top: -20%;
  text-align: left;
  margin-bottom: 60px;
}
.bg {
  display: inline-block;
  overflow: hidden;
  position: relative;
  font-size: 15px;

  color: #fff;
  background-color: red;
  text-decoration: none;
  padding: 10px 10px;
  border: 1px solid #aaa;
  font-weight: bold;
  border-radius: 25px;
}
.button {
  width: fit-content;
  height: fit-content;
  margin-top: 10px;
}
.button a {
  display: inline-block;
  overflow: hidden;
  position: relative;
  font-size: 15px;
  color: #111;
  text-decoration: none;
  padding: 10px 10px;
  border: 1px solid #aaa;
  font-weight: bold;
}
.button a:after {
  content: '';
  position: absolute;
  top: 0;
  right: -10px;
  width: 0%;
  background-color: #111;
  height: 100%;
  z-index: -1;
  transition: width 0.3s ease-in-out;
  transform: skew(-25deg);
  transform-origin: right;
}
.product__content {
  font-size: 2.5em;
}
.button a:hover:after {
  width: 150%;
  left: -10px;
  transform-origin: left;
}
.button a:hover {
  color: #fff;
  transition: all 0.5s ease;
}
.button a:nth-of-type(1) {
  border-radius: 50px 0 0 50px;
  border-right: none;
}
.button a:nth-of-type(2) {
  border-radius: 0px 50px 50px 0;
}
.cart-icon {
  padding-right: 8px;
}
.colors {
  width: 20px;
  height: 20px;
  display: inline-block;
  transition: 0.3s all;
  border-radius: 50%;
  border: 1px solid black;
  margin: 0 15px;
}
.colors:hover,
.size:hover {
  transform: scale(1.2);
  box-shadow: 0 0 0 8px rgba(173, 173, 170, 0.3);
  cursor: pointer;
}
.colors:active,
.size:active {
  transform: scale(0.8);
}
.selected {
  box-shadow: 0 0 0 4px #fff, 0 0 0 8px rgba(173, 173, 170, 0.3);
}
.colors-wrap,
.size-wrap {
  width: 100%;
  height: auto;
  margin: 5px auto;
  padding: 10px;
  border-radius: 70px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.size {
  border-radius: 50%;
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 15px;
  cursor: pointer;
  transition: all 0.3s;
}
.sameproduct {
  margin-top: -10%;
}
.opinion {
  margin-top: -20%;
}
.count {
  width: 70px;
}
.minus {
  margin-right: 15px;
  cursor: pointer;
}
.plus {
  margin-left: 0px;
  cursor: pointer;
}
#menu_title {
  font-size: 18px;
  font-weight: bold;
}
@media (max-width: 700px) {
  .wrapper {
    margin: -90px 0px 5px -32px;
  }
  .outer {
    width: 95%;
    margin-top: 0;
  }
  .content {
    left: 50%;
    transform: translateX(-40%);
  }

  .img {
    /* display: none; */
    width: 100%;
    margin-top: 0px !important;
  }
  .product__content {
    font-size: 2em;
  }
  #menu_title {
    font-size: 14px;
  }
}
div.info_img ::v-deep p > img {
  width: 100%;
}
</style>
