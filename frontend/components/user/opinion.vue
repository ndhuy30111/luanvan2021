<template>
  <div>
    <v-tabs color="accent-4">
      <v-tab v-for="item in $local.vn.menuoption" id="menu_title" :key="item">{{
        item
      }}</v-tab>

      <v-tab-item>
        <v-container fluid>
          <v-row>
            <v-col cols="12">
              <img
                class="img"
                src="~/assets/product/vay3.jpg"
                alt="describe product"
            /></v-col>
          </v-row>
        </v-container>
      </v-tab-item>

      <v-tab-item>
        <v-container fluid>
          <v-row>
            <v-col id="fb-root"> </v-col>
          </v-row>
        </v-container>
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss" scoped>
#menu_title {
  font-size: 18px;
  font-weight: bold;
}
.img {
  width: 100%;
}
.comment {
  width: 700px;
}
.btn {
  display: block;
  height: 38px;
  border-radius: 20px;
  outline: none;
  border: none;
  background: rgb(16, 158, 241);
  color: white;
  background-size: 200%;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  text-transform: uppercase;
  cursor: pointer;
  transition: 0.5s;
}
.facebook {
  width: 20px;
  height: 20px;
  margin: 5px;
}
@media (max-width: 700px) {
  #menu_title {
    font-size: 14px;
  }
  .comment {
    width: 200px;
  }
}
</style>
