<template>
  <v-container
    ><v-row>{{ products }}</v-row></v-container
  >
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  layout: 'admin',
  computed: {
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      product: 'admin/product/getFindProduct',
    }),
    products() {
      const item = this.product({ id: this.$route.params.id })
      return item
    },
  },
}
</script>

<style></style>
