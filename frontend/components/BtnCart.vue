<template>
  <router-link to="cart">
    <v-btn id="cart" icon>
      <b-icon icon="handbag"></b-icon>
      <span>{{ amount }}</span>
    </v-btn>
  </router-link>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'ButtonCart',
  computed: {
    ...mapGetters({
      amount: 'user/cart/amount',
    }),
  },
}
</script>

<style lang="scss" scoped>
#cart {
  font-size: larger;
  margin-right: 10px;
  span {
    position: absolute;
    margin-top: -25px;
    margin-left: 25px;
    height: 15px;
    width: 15px;
    background: #ec410d;
    color: #ffffff;
    border-radius: 50%;
    font-size: 11px;
    font-weight: 650;
    text-align: center;
    line-height: 15px;
  }
}
</style>
