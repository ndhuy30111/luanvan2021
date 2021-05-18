<template>
  <v-container fluid>
    <v-row>
      <v-col class="collection">
        <div class="collection_img">
          <img
            src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-large.jpg?v=1516250004"
            style="width: 100%"
          />
        </div>
      </v-col>
    </v-row>
    <v-row class="list-product">
      <ListProduct :menutab="menutab" />
    </v-row>
  </v-container>
</template>

<script>
import ListProduct from '../components/user/ListProduct'
export default {
  components: { ListProduct },
  data: () => {
    return {
      menutab: ['Women', 'Men'],
    }
  },
}
</script>

<style lang="scss" scoped>
.list-product {
  margin-top: 20px;
}
</style>
