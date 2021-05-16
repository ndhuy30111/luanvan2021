<template>
  <v-container fluid>
    <v-row class="float-left w-75">
      <v-col>
        <Map />
      </v-col>
    </v-row>
    <v-row class="float-right">
      <v-col> Thong tin cua hang </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Map from '~/components/user/Map.vue'

export default {
  components: { Map },
}
</script>
<style lang="scss" scoped></style>
