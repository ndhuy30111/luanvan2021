<template>
  <v-sheet id="menu_category" class="mx-auto">
    <v-slide-group class="pa-4" show-arrows>
      <v-slide-item v-for="item in img" :key="item">
        <v-card class="ma-4">
          <v-row class="fill-height">
            <img :src="item" />
          </v-row>
        </v-card>
      </v-slide-item>
    </v-slide-group>
  </v-sheet>
</template>

<script>
export default {
  data() {
    return {
      img: [
        'https://cdn.shopify.com/s/files/1/2598/7400/files/collection-8.jpg?v=1517147164',

        'https://cdn.shopify.com/s/files/1/2598/7400/files/collection-1_1.jpg?v=1517146849',

        'https://cdn.shopify.com/s/files/1/2598/7400/files/collection-5_a69fcc2f-2f86-4469-a549-161b617ce07f.jpg?v=1517144883',

        'https://cdn.shopify.com/s/files/1/2598/7400/files/collection-1_5293d77e-78ee-4182-bee0-97951ba99ecf.jpg?v=1517144750',

        'https://cdn.shopify.com/s/files/1/2598/7400/files/2_b3c2593a-a26c-435c-a5af-fcde84b12fbd.jpg?v=1515226156',
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
#menu_category {
  margin-top: -15px;
}
img {
  margin-top: 8px;
  vertical-align: middle;
  width: 470px;
  height: 105%;
  filter: grayscale(0.5) brightness(0.5);
  cursor: pointer;
  transition: 0.3s linear;
}
img:hover {
  filter: grayscale(0);
}
@media screen and (max-width: 880px) {
  img {
    width: 315px;
  }
}
@media screen and (max-width: 600px) {
  img {
    width: 120px;
  }
}
</style>
