<template>
  <v-container>
    <Crudactions
      :title="title"
      :headers="headers"
      :desserts="category"
      @new="saveNew"
      @edit="saveEdit"
      @del="deletes"
    ></Crudactions>
  </v-container>
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
      { text: 'Độ ưu tiên', value: 'sort' },
      { text: 'Cha', value: 'category' },
      { text: 'Ngày tạo', value: 'createDate' },
      { text: 'Người tạo', value: 'createBy' },
      { text: 'Người cập nhập', value: 'lastModifiedBy' },
      { text: 'Ngày cập nhập', value: 'lastModifiedDate' },

      { text: '', value: 'actions', sortable: false },
    ],
    data: [],
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
  computed: {
    category() {
      return this.$store.state.admin.category.contents
    },
  },

  methods: {
    init() {},

    saveNew(item) {
      this.$store.dispatch('admin/category/add', item)
    },
    saveEdit(item) {
      this.$store.dispatch('admin/category/edit', item)
    },
    deletes(item) {
      this.$store.dispatch('admin/category/delete', item)
    },
  },
}
</script>

<style></style>
