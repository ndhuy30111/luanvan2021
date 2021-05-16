<template>
  <v-app id="inspire">
    <HeaderMobile />
    <div class="content" :class="{ open: showNav }">
      <div class="top-bar container">
        <div v-if="mobileView" class="w-100 row">
          <div class="col" id="navigation-icon" @click="showNav = !showNav">
            <v-app-bar-nav-icon></v-app-bar-nav-icon>
          </div>
          <div class="col d-flex justify-content-end">
            <v-btn id="cart" icon>
              <b-icon icon="cart"></b-icon>
              <span>0</span>
            </v-btn>
            <v-avatar color="teal" size="29"></v-avatar>
          </div>
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
import Header from '../components/user/header/Header.vue'
import Footer from '../components/user/Footer.vue'
import HeaderMobile from '../components/user/header/HeaderMobile.vue'
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
  transition: 0.5s transform cubic-bezier(0, 0.12, 0.14, 1);
}
.open {
  transform: translateX(255px);
}
#cart {
  font-size: larger;
  margin-right: 10px;
  span {
    position: absolute;
    margin-top: -25px;
    margin-left: 25px;
    height: 15px;
    width: 15px;
    background: #ec410d;
    color: #ffffff;
    border-radius: 50%;
    font-size: 11px;
    font-weight: 650;
    text-align: center;
    line-height: 15px;
  }
}
</style>
