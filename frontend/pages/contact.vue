<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12" class="hidden-sm-and-down" md="6">
        <Map />
      </v-col>
      <v-col cols="12" md="6">
        <Bubble1 style="transform: rotate(180deg) translateY(25%)" />
        <h3 align="center" justify="center">{{ $local.vn.shop }} Xin chào!!</h3>
        <h5 align="center" justify="center">SĐT: 01999556678</h5>
        <h5 align="center" justify="center">Facebook: {{ $local.vn.shop }}</h5>
        <h5 align="center" justify="center">
          Email: myduyen06122910@gmail.com
        </h5>
        <h5 align="center" justify="center">
          Địa chỉ: 18 Phạm Thị Tánh, Phường 4, Quận 8, Thành phố Hồ Chí Minh
        </h5>
        <Bubble2 style="transform: rotate(180deg) translate(-200px, -15%)" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Map from '../components/user/Map.vue'
import Bubble1 from '../components/Bubble1'
import Bubble2 from '../components/Bubble2'
export default {
  components: { Map, Bubble1, Bubble2 },
}
</script>
<style lang="scss" scoped></style>
