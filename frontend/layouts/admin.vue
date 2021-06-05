<template>
  <div id="app">
    <v-app id="inspire">
      <Navigation :menu="$local.vn_admin.menu" />
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
  build: {
    splitChunks: {
      layouts: true,
    },
  },
  created() {
    this.$store.dispatch('admin/category/init')
    this.$store.dispatch('admin/color/init')
    this.$store.dispatch('admin/product/init')
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
