<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat>
      <v-spacer></v-spacer>

      <ul>
        <li
          v-for="(menu, index) in menus"
          :key="index"
          @click="activeMemu(index)"
        >
          <a :id="menu.active ? 'active' : ''" class="link" href="#">{{
            menu.content
          }}</a>
        </li>
      </ul>

      <v-spacer></v-spacer>
      <v-responsive max-width="500">
        <v-text-field
          background-color="grey lighten-5"
          dense
          flat
          hide-details
          rounded
          solo
          append-icon="mdi-magnify"
          label="Search"
        >
        </v-text-field>
      </v-responsive>

      <v-btn id="cart" icon>
        <b-icon icon="cart"></b-icon>
        <span>0</span>
      </v-btn>

      <b-avatar src="https://placekitten.com/300/300"></b-avatar>
    </v-app-bar>

    <v-main class="grey lighten-4">
      <Nuxt />
    </v-main>
  </v-app>
</template>
<script>
export default {
  data: () => ({
    menus: [
      {
        content: 'HOME',
        url: 'home',
        active: true,
      },
      {
        content: 'SHOP',
        url: 'shop',
        active: false,
      },
      {
        content: 'COLLECTIONS',
        url: 'collections',
        active: false,
      },
      {
        content: 'CONTACT US',
        url: 'contact',
        active: false,
      },
    ],
  }),
  methods: {
    activeMemu(i) {
      this.menus.forEach((item, index) => {
        if (i === index) {
          item.active = true
        } else {
          item.active = false
        }
      })
    },
  },
}
</script>
<style lang="scss" scoped>
ul li {
  list-style: none;
  margin-top: 20px;
  margin-left: 30px;
  display: inline-block;
  a {
    font-size: 20px;
    font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
      sans-serif;
    color: black;
    text-decoration: none;
    transition: all 0.3s;
  }
  a:hover {
    color: #a1887f;
  }
  .link::after {
    content: '';
    width: 0%;
    height: 1px;
    display: block;
    background-color: black;
    transition: width 0.3s;
  }
  .link:hover::after {
    width: 100%;
    transition: width 0.3s;
  }
  #active {
    color: #a1887f;
  }
}
#cart {
  font-size: larger;
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
