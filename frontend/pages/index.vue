<template>
  <v-container fluid>
    <v-row class="menu">
      <v-col cols="12">
        <a href="/shop">
          <img
            class="banner"
            :src="require(`~/assets/banner.jpg`)"
            alt="new banner"
            width="100%"
            style="cursor: pointer"
        /></a>
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

    <v-row class="mt-10">
      <v-col cols="12">
        <img
          class="banner"
          :src="require(`~/assets/banner1.jpg`)"
          alt="new banner"
          width="100%"
          style="cursor: pointer"
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
          class="banner"
          :src="require(`~/assets/fashion.jpg`)"
          alt="sale banner"
          width="100%"
          style="cursor: pointer"
        />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12" sm="3" md="3">
        <img
          :src="require(`~/assets/category/flashsale.gif`)"
          alt="single banner"
          width="100%"
        />
      </v-col>
      <v-col cols="12" sm="9">
        <ListProduct :menutab="$local.vn.menuproduct" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ListProduct from '../components/user/ListProduct'
export default {
  components: {
    ListProduct,
  },
}
</script>

<style lang="scss" scoped>
.menu {
  margin-top: -30px;
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
.banner {
  margin-top: -40px;
}
@media screen and (max-width: 880px) {
  .menu {
    margin-top: 0px;
  }
  .banner {
    width: 100%;
  }
  .center {
    p {
      font-size: 30px;
    }
  }
}
</style>
