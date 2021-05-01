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
    title: 'Danh sách sản phẩm',
  }),
  head() {
    return {
      title: this.title,
      meta: [
        {
          hid: 'Thêm sản phẩm',
          name: 'Thêm sản phẩm',
          content: 'Thêm sản phẩm vào cửa hàng 7755',
        },
      ],
    }
  },
}
</script>

<style></style>
