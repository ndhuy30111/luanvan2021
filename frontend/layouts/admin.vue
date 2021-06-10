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
  computed: {
    menu() {
      return [
        {
          name: this.$local.vn_admin_menu.CONTENT_MANAGEMENT,
          function: [
            {
              name: this.$local.vn_admin_menu.CATEGORY_MANAGEMENT,
              function: [
                {
                  name: this.$local.vn_admin_menu.CATEGORY_VIEW,
                  url: 'admin-category',
                },
              ],
            },
            {
              name: this.$local.vn_admin_menu.PRODUCT_MANAGEMENT,
              function: [
                {
                  name: this.$local.vn_admin_menu.PRODUCT_VIEW,
                  url: 'admin-product',
                },
                {
                  name: this.$local.vn_admin_menu.PRODUCT_ADD,
                  url: 'admin-product-add',
                },
              ],
            },
            {
              name: this.$local.vn_admin_menu.COLOR_MANAGEMENT,
              function: [
                {
                  name: this.$local.vn_admin_menu.COLOR_VIEW,
                  url: 'admin-color',
                },
              ],
            },
          ],
        },
        {
          name: this.$local.vn_admin_menu.WAREHOUSE_MANAGEMENT,
          function: [
            {
              name: this.$local.vn_admin_menu.IMPORT_PRODUCT_MANAGEMENT,
              function: [
                {
                  name: this.$local.vn_admin_menu.IMPORT_PRODUCT_VIEW,
                  url: 'admin-coupon',
                },
              ],
            },
          ],
        },
      ]
    },
  },
  created() {
    this.$store.dispatch(this.$constant.admin.ACTION_ADMIN_CATEGORY_INIT)
    this.$store.dispatch(this.$constant.admin.ACTION_ADMIN_COLOR_INIT)
    this.$store.dispatch(this.$constant.admin.ACTION_ADMIN_PRODUCT_INIT)
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
