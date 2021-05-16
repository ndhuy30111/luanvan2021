<template>
  <v-container fluid>
    <v-row>
      <Carousel />
    </v-row>
    <v-row>
      <v-col class="img_shop" cols="12">
        <CardCarousel />
      </v-col>
    </v-row>
    <v-row class="list-product">
      <ListProduct :menutab="menutab" />
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
import CardCarousel from '../components/user/CardCarousel.vue'
import ListProduct from '../components/user/ListProduct'
import Video from '~/components/user/Video.vue'
export default {
  components: {
    CardCarousel,
    ListProduct,
    Carousel,
    Video,
  },
  data: () => {
    return {
      menutab: ['New Arrival', 'Top Rated'],
    }
  },
}
</script>

<style lang="scss" scoped>
.list-product {
  margin-top: 20px;
}
</style>
