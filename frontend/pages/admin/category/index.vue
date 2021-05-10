<template>
  <v-container>
    <Crudactions
      :title="title"
      url="/admin/product/add"
      :headers="headers"
      :desserts="category"
    ></Crudactions
  ></v-container>
</template>

<script>
import Crudactions from '~/components/tabledata/Crudactions.vue'
export default {
  components: { Crudactions },
  layout: 'admin',
  data: () => ({
    title: 'Danh sách danh mục',
    headers: [
      {
        text: 'Tên danh mục',
        align: 'start',
        value: 'name',
      },
      { text: 'Đường dẫn', value: 'url' },
    ],
    category: [
      {
        id: '1',
        name: 'Áo',
        url: 'ao',
        children: [{ id: '3', name: 'Áo nữ', url: 'ao-nu' }],
      },
      { id: '2', name: 'quần', url: 'url' },
    ],
  }),
  head() {
    return {
      title: this.title,
      meta: [
        {
          hid: 'Danh sách danh mục',
          name: 'Danh sách danh mục',
          content: 'Danh sách danh mục vào cửa hàng 7755',
        },
      ],
    }
  },
}
</script>

<style></style>
