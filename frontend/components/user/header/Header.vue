<template>
  <v-app-bar app color="white" flat>
    <ul>
      <li
        v-for="(menu, index) in menus"
        :key="index"
        @click="activeMemu(index)"
      >
        <router-link
          :id="menu.active ? 'active' : ''"
          :to="menu.url"
          class="link"
          >{{ menu.content }}</router-link
        >
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

    <v-avatar color="teal" size="38"></v-avatar>
  </v-app-bar>
</template>

<script>
export default {
  data: () => ({
    menus: [
      {
        content: 'HOME',
        url: '/',
        active: true,
      },
      {
        content: 'SHOP',
        url: 'shop',
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
  margin-left: 20px;
  display: inline-block;
  a {
    font-size: 18px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    color: black;
    text-decoration: none;
    transition: all 0.3s;
  }
  a:hover {
    color: #ce785c;
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
    color: #ce785c;
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
