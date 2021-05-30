<template>
  <div id="app">
    <v-app id="inspire">
      <Navigation :menu="menu" />
      <v-main>
        <Nuxt />
      </v-main>
    </v-app>
  </div>
</template>

<script>
import Navigation from '~/components/admin/header/Navigation'
export default {
  components: { Navigation },
  middleware: 'authenticated',
  data: () => ({
    menu: [
      {
        name: 'Chủ cửa hàng',
        function: [
          {
            name: 'Quản lý khuyến mãi',
            function: [
              { name: 'Xem Khuyến mã', url: 'index' },
              { name: 'Thêm Khuyến mã', url: 'add' },
            ],
          },
        ],
      },
      {
        name: 'Quản lý nội dung',
        function: [
          {
            name: 'Quản lý Danh mục',
            function: [{ name: 'Xem Danh mục', url: 'admin-category' }],
          },
          {
            name: 'Quản lý sản phẩm',
            function: [
              { name: 'Xem danh sách', url: 'admin-product' },
              { name: 'Thêm sản phẩm', url: 'admin-product-add' },
            ],
          },
          {
            name: 'Quản lý màu sắc',
            function: [{ name: 'Xem danh sách màu sắc', url: 'admin-color' }],
          },
          {
            name: 'Quản lý Banner',
            function: [
              { name: 'Xem Banner', url: 'index' },
              { name: 'Thêm Banner', url: 'add' },
            ],
          },
        ],
      },
    ],
  }),
  mounted() {
    this.$store.dispatch('admin/category/init')
    this.$store.dispatch('admin/color/init')
  },
}
</script>

<style scoped>
.row.content {
  height: 550px;
}

.sidenav {
  background-color: #f1f1f1;
  height: 100%;
}

@media screen and (max-width: 767px) {
  .row.content {
    height: auto;
  }
}
</style>
