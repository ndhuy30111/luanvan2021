<template>
  <div>
    <v-tabs color="accent-4" centered>
      <v-tab v-for="item in menutab" id="menu_title" :key="item">{{
        item
      }}</v-tab>

      <v-tab-item v-for="n in 3" :key="n">
        <v-container fluid>
          <v-row>
            <v-col v-for="i in 4" :key="i" cols="6" md="4" lg="3" sm="6" xs="6">
              <Product />
            </v-col>
          </v-row>
        </v-container>
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
import Product from './Product'
export default {
  components: { Product },
  props: ['menutab'],
}
</script>

<style lang="scss" scoped>
#menu_title {
  font-size: 18px;
  font-weight: bold;
}
</style>
