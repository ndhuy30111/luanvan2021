<template>
  <v-container fluid>
    <v-row class="menu">
      <v-col class="collection">
        <div class="collection_img">
          <img
            src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-large.jpg?v=1516250004"
            style="width: 100%"
          />
        </div>
      </v-col>
    </v-row>

    <v-row>
      <v-col v-show="!mobileView" cols="12" sm="4" md="3">
        <FilterLeft />
      </v-col>
      <v-col v-show="!mobileView" cols="12" sm="8" md="9" class="list-product">
        <FilterTop />
        <h4>Tất cả sản phẩm</h4>
        <v-row>
          <v-col
            v-for="item in listproduct"
            :key="item.id"
            cols="6"
            md="4"
            lg="3"
            sm="6"
            xs="6"
          >
            <Product :product="item" />
          </v-col>
        </v-row>
      </v-col>

      <v-col v-show="mobileView" cols="12">
        <FiterMobile />
      </v-col>

      <v-col v-show="mobileView" cols="12" class="list-product">
        <FilterTop />
        <h4>Tất cả sản phẩm</h4>
        <v-row>
          <v-col
            v-for="item in listproduct"
            :key="item.id"
            cols="6"
            md="4"
            lg="3"
            sm="6"
            xs="6"
          >
            <Product :product="item" />
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import FilterLeft from '~/components/user/filter/Filter.vue'
import FilterTop from '~/components/user/filter/Filter1.vue'
import FiterMobile from '~/components/user/filter/FiterMobile.vue'
import Product from '~/components/user/Product.vue'
export default {
  name: 'Shop',
  components: { FilterLeft, FilterTop, Product, FiterMobile },
  data: () => {
    return {
      mobileView: true,
    }
  },
  computed: {
    listproduct() {
      return this.$store.state.user.product.list_products
    },
  },
  created() {
    this.handleView()
    addEventListener('resize', this.handleView)
  },
  methods: {
    handleView() {
      this.mobileView = window.innerWidth <= 700
    },
  },
}
</script>

<style lang="scss" scoped>
.menu {
  margin: 0px -47px;
}
.collection {
  margin-top: -40px;
}
</style>
