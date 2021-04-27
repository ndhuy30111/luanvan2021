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
            name: 'Quản lý sản phẩm',
            function: [
              { name: 'Xem danh sách', url: 'admin-product' },
              { name: 'Thêm sản phẩm', url: 'admin-product-add' },
            ],
          },
          {
            name: 'Quản lý Danh mục',
            function: [
              { name: 'Xem Danh mục', url: 'index' },
              { name: 'Thêm Danh mục', url: 'add' },
            ],
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
