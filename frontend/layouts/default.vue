<template>
  <v-app id="inspire">
    <HeaderMobile />
    <div class="content" :class="{ open: showNav }">
      <div class="top-bar">
        <div v-if="mobileView" id="navigation-icon" @click="showNav = !showNav">
          <v-app-bar-nav-icon></v-app-bar-nav-icon>
        </div>
        <Header v-if="!mobileView" />
      </div>
      <v-main in>
        <Nuxt />
      </v-main>
      <Footer />
    </div>
  </v-app>
</template>
<script>
import Header from '../components/user/Header.vue'
import Footer from '../components/user/Footer.vue'
import HeaderMobile from '../components/user/HeaderMobile.vue'
export default {
  components: { Header, Footer, HeaderMobile },
  data: () => {
    return {
      mobileView: true,
      showNav: false,
    }
  },
  created() {
    this.handleView()
    addEventListener('resize', this.handleView)
  },
  methods: {
    handleView() {
      this.mobileView = window.innerWidth <= 990
    },
  },
}
</script>
<style lang="scss" scoped>
.top-bar {
  display: flex;
  width: 100%;
}
#navigation-icon {
  padding: 10px 10px 20px;
  margin-right: 10px;
  cursor: pointer;
  i {
    font-size: 2rem;
  }
}
.content {
  position: absolute;
  width: calc(100%);
  height: calc(50vh);
  padding: 20px;
  background-color: #fff;
  transition: 1s transform cubic-bezier(0, 0.12, 0.14, 1);
}
.open {
  transform: translateX(290px);
}
</style>
