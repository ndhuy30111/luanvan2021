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
      <v-col>
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
                  <!-- eslint-disable vue/no-v-html -->
                  <div class="info_img" v-html="products.info"></div>
                  <!--eslint-enable-->
                </v-col>
              </v-row>
            </v-container>
          </v-tab-item>

          <v-tab-item>
            <v-container fluid>
              <v-row>
                <v-col>
                  <v-form
                    ref="commet"
                    v-model="validCommet"
                    lazy-validation
                    @submit.prevent="onCommet"
                  >
                    <v-row>
                      <v-rating
                        v-model="userCommet.rate"
                        background-color="grey lighten-2"
                        color="red"
                        empty-icon="mdi-heart-outline"
                        full-icon="mdi-heart"
                        half-icon="mdi-heart"
                        hover
                        length="5"
                        size="25"
                      ></v-rating
                    ></v-row>
                    <v-row>
                      <v-textarea
                        v-model="userCommet.comment"
                        name="input-7-1"
                        auto-grow
                        label="Bình luận"
                        :rules="[$auth.user || 'Bạn phải đăng nhập']"
                      ></v-textarea
                    ></v-row>
                    <v-row class="d-flex justify-content-end"
                      ><v-btn
                        :disabled="!validCommet"
                        type="submit"
                        @click="validateComment"
                        >Bình luận</v-btn
                      ></v-row
                    >
                  </v-form>
                </v-col>
              </v-row>
              <v-row>
                <v-col> </v-col>
              </v-row>
            </v-container>
          </v-tab-item>
        </v-tabs>
      </v-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Productdetail',
  data() {
    return {
      validCommet: false,
      userCommet: {
        rate: 5,
        commet: '',
      },
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
    user() {},
  },
  methods: {
    init() {},
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
        idProduct: this.products.id,
        name: this.products.name,
        size: this.sizeActive.name,
        color: this.colorActive.name,
        image: this.imgActive,
        price: this.products.price,
        quantity: parseInt(this.quantity),
      }
      if (this.user !== '') {
        this.$store.dispatch(
          this.$constant.user.ACTION_CART_ADDTOCART_USER,
          cartItem
        )
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
    validateComment() {
      this.$refs.commet.validate()
    },
    async onCommet() {
      this.userCommet.product = this.products.id
      await this.$store.dispatch(
        this.$constant.user.ACTION_POST_REVIEW,
        this.userCommet
      )
    },
  },
}
</script>

<style lang="scss" scoped>
@import './assets/css/detailsproduct.scss';
</style>
