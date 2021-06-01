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
    <v-row>
      <v-col cols="12" sm="3" md="3">
        <img
          :src="require(`~/assets/category/women1.jpg`)"
          alt="single banner"
          width="100%"
        />
        <div class="center">
          <p>WOMEN'S</p>
        </div>
      </v-col>
      <v-col cols="12" sm="9">
        <ListProduct :menutab="$local.vn.menuproduct" />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <img
          class="sale"
          :src="require(`~/assets/sale.jpg`)"
          alt="sale banner"
          width="100%"
        />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" sm="9">
        <ListProduct :menutab="$local.vn.menuproduct" />
      </v-col>
      <v-col cols="12" sm="3" md="3">
        <img
          :src="require(`~/assets/category/man1.jpg`)"
          alt="single banner"
          width="100%"
        />
        <div class="center">
          <p>MAN'S</p>
        </div>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <img
          class="sale"
          :src="require(`~/assets/fashion.jpg`)"
          alt="sale banner"
          width="100%"
          style="cursor: pointer"
        />
      </v-col>
    </v-row>
    <Service />
  </v-container>
</template>

<script>
import Carousel from '../components/user/Carousel.vue'
import CategoryMenu from '../components/user/CategoryMenu.vue'
import ListProduct from '../components/user/ListProduct'
import Service from '../components/user/service'
export default {
  components: {
    CategoryMenu,
    ListProduct,
    Carousel,
    Service,
  },
}
</script>

<style lang="scss" scoped>
.menu {
  margin: 0px -50px;
}
.center {
  position: absolute;
  top: 35%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 15px;
  p {
    font-size: 40px;
    color: white;
  }
}
@media screen and (max-width: 880px) {
  .sale {
    width: 100%;
  }
  .center {
    p {
      font-size: 30px;
    }
  }
}
</style>
