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
      <v-col cols="12" sm="3">
        <FilterLeft />
      </v-col>

      <v-col cols="12" sm="9" class="list-product">
        <FilterTop />
        <ListProduct :menutab="$local.vn.tilte_page_product" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import FilterLeft from '~/components/user/Filter.vue'
import FilterTop from '~/components/user/Filter1.vue'
import ListProduct from '~/components/user/ListProduct'
export default {
  name: 'Shop',
  components: { ListProduct, FilterLeft, FilterTop },
  created() {
    this.$store.dispatch('user/categorys/getAll')
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
