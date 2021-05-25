<template>
  <div class="acc text-center">
    <v-menu offset-y>
      <template #activator="{ on, attrs }">
        <v-btn v-bind="attrs" v-on="on" icon>
          <b-icon icon="person-check" id="person"></b-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in items" :key="index">
          <v-list-item-title class="text-center">
            <a :href="item.url" class="text">
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
.acc {
  margin: 0px 10px;
  #person {
    font-size: 1.5rem;
  }
}
a.text {
  color: rgb(0, 0, 0);
  text-decoration: none;
}
a:hover {
  color: #ce785c;
}
</style>
