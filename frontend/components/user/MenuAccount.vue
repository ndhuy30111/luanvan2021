<template>
  <div class="text-center">
    <v-menu offset-y>
      <template #activator="{ on, attrs }">
        <v-btn depressed v-bind="attrs" v-on="on">
          <b-icon icon="person-fill"></b-icon> Account
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in items" :key="index">
          <v-list-item-title class="text-center">
            <a :href="item.url">
              {{ item.title }}
            </a>
          </v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>
</template>

<script>
export default {
  data: () => ({
    items: [
      { title: 'Login', url: 'login' },
      { title: 'Register', url: 'register' },
    ],
  }),
}
</script>

<style lang="scss" scoped>
a {
  color: rgb(0, 0, 0);
  text-decoration: none;
}
a:hover {
  color: #ce785c;
}
</style>
