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
    <ProductFilter />
    <v-row class="list-product">
      <ListProduct :menutab="menutab" />
    </v-row>
  </v-container>
</template>

<script>
import ProductFilter from '~/components/user/ProductFilter.vue'
import ListProduct from '~/components/user/ListProduct'
export default {
  components: { ListProduct, ProductFilter },
  data: () => {
    return {
      menutab: ['Women', 'Men'],
      drawer: null,
    }
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
