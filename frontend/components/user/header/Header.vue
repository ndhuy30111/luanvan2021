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
    <BtnCart />
    <MenuAccount />
    <!-- <v-avatar color="teal" size="38"></v-avatar> -->
  </v-app-bar>
</template>

<script>
import MenuAccount from '../MenuAccount.vue'
import BtnCart from '../../BtnCart'
export default {
  components: { MenuAccount, BtnCart },
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
      {
        content: 'NEWS',
        url: 'news',
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
</style>
