<template>
  <v-container fluid>
    <Carousel />
    <v-row>
      <v-col class="collection">
        <div class="collection_img">
          <img
            src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-1_5293d77e-78ee-4182-bee0-97951ba99ecf.jpg?v=1517144750"
          />
        </div>
        <h3 class="collection_name">WOMEN</h3>
        <a href="#">SHOP NOW</a>
      </v-col>

      <v-col class="collection">
        <div class="collection_img">
          <img
            src="https://cdn.shopify.com/s/files/1/2598/7400/files/collection-2_406ae0b6-7a6d-4819-bf81-e0894fe83ace.jpg?v=1517144793"
          />
        </div>
        <h3 class="collection_name">MEN</h3>
        <a href="#">SHOP NOW</a>
      </v-col>
    </v-row>
    <v-row>
      <v-tabs color="accent-4" centered>
        <v-tab>New Arrivals</v-tab>
        <v-tab>Top Rated</v-tab>

        <v-tab-item v-for="n in 3" :key="n">
          <v-container fluid>
            <v-row>
              <v-col v-for="i in 6" :key="i" cols="12" md="3">
                <Product />
              </v-col>
            </v-row>
          </v-container>
        </v-tab-item>
      </v-tabs>
    </v-row>
  </v-container>
</template>

<script>
import Carousel from '../components/user/Carousel.vue'
import Product from '../components/user/Product.vue'
export default {
  components: {
    Carousel,
    Product,
  },
}
</script>

<style lang="scss" scoped>
ul li {
  list-style: none;
  margin-top: 20px;
  margin-left: 50px;
  display: inline-block;
  a {
    font-size: 30px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    color: black;
    text-decoration: none;
    transition: all 0.3s;
  }
  #active {
    border-bottom: 2px solid black;
  }
}
.collection {
  position: relative;
  margin: 40px;
  top: 40px;
  bottom: 40px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  .collection_name {
    position: relative;
    float: left;
    margin-left: 10px;
    padding-top: 5px;
    font-size: 20px;
    font-weight: 300;
    text-transform: uppercase;
  }
  .collection_img {
    flex: 25%;
    max-width: 100%;
    padding: 0 4px;
    img {
      margin-top: 4px;
      vertical-align: middle;
      width: 100%;
      vertical-align: middle;
      border-radius: 8px;
      cursor: pointer;
    }
  }
  .collection_img:hover {
    opacity: 0.5;
  }
  a {
    position: relative;
    float: right;
    padding-top: 5px;
    color: black;
    text-decoration: none;
    border-bottom: 2px solid black;
  }
  a:hover {
    color: #ce785c;
  }
}
@media screen and (max-width: 800px) {
  .collection_name {
    font-size: 10px;
  }
  .collection_img {
    flex: 50%;
    max-width: 50%;
    padding: auto;
  }
}
@media screen and (max-width: 600px) {
  .collection_name {
    font-size: 10px;
  }
  .collection_img {
    flex: 100%;
    max-width: 100%;
    padding: auto;
  }
}
</style>
