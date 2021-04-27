<template>
  <v-container>
    <Crudactions :title="title" url="/admin/product/add"></Crudactions
  ></v-container>
</template>

<script>
import Crudactions from '~/components/tabledata/Crudactions.vue'
export default {
  components: { Crudactions },
  layout: 'admin',
  data: () => ({
    title: 'Sản phẩm',
  }),
}
</script>

<style></style>
