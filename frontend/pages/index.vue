<template>
  <v-container fluid>
    <v-row class="menu">
      <Carousel />
    </v-row>
    <v-row class="menu">
      <v-col cols="12">
        <CategoryMenu />
      </v-col>
    </v-row>
    <v-row class="list-product">
      <ListProduct :menutab="$local.vn.menuproduct" />
    </v-row>
    <v-row>
      <v-col>
        <Video />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Carousel from '../components/user/Carousel.vue'
import CategoryMenu from '../components/user/CategoryMenu.vue'
import ListProduct from '../components/user/ListProduct'
import Video from '~/components/user/Video.vue'
export default {
  components: {
    CategoryMenu,
    ListProduct,
    Carousel,
    Video,
  },
}
</script>

<style lang="scss" scoped>
.list-product {
  margin-top: 20px;
}
.menu {
  margin: 0px -50px;
}
</style>
