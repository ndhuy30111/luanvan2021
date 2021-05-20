<template>
  <v-container>
    <Crudactions
      :title="title"
      :headers="headers"
      :desserts="data"
    ></Crudactions>
  </v-container>
</template>

<script>
import Crudactions from '~/components/tabledata/Crudactions.vue'
export default {
  components: { Crudactions },
  layout: 'admin',
  async asyncData({ $axios, $auth }) {
    $axios.setToken($auth.strategy.token.get())
    const data = await $axios.$get('/admin/category')
    return { data }
  },
  data: () => ({
    title: 'Danh sách danh mục',
    headers: [
      {
        text: 'Tên danh mục',
        align: 'start',
        value: 'name',
      },
      { text: 'Đường dẫn', value: 'url' },
      { text: 'Độ ưu tiên', value: 'sort' },
      { text: 'Ngày tạo', value: 'createDate' },
      { text: 'Tài khoản cập nhập', value: 'lastModifiedBy' },
      { text: 'Ngày cập nhập', value: 'lastModifiedDate' },
      { text: 'Actions', value: 'actions', sortable: false },
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
  created() {},
  methods: {},
}
</script>

<style></style>
